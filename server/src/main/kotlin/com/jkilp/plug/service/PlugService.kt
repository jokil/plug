package com.jkilp.plug.service

import com.jkilp.plug.controller.WebSocketController
import com.jkilp.plug.entity.Reading
import com.jkilp.plug.tplink.command.GetRealtime
import com.jkilp.plug.tplink.command.Info
import com.jkilp.plug.tplink.command.Reset
import com.jkilp.plug.tplink.command.SetRelayState
import com.jkilp.plug.tplink.command.`interface`.TPLinkCommand
import com.jkilp.plug.mapper
import com.jkilp.plug.repository.ReadingRepository
import com.jkilp.plug.tplink.response.GetRealtimeResponse
import com.jkilp.plug.tplink.response.`interface`.TPLinkResponse
import com.jkilp.plug.serialize
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import java.net.InetSocketAddress
import java.net.Socket

@Service
@EnableScheduling
class PlugService(
        @Value("\${plug.ip}") private val ip: String,
        @Value("\${plug.port}") private val port: Int,
        @Autowired private val encryptionService: EncryptionService,
        @Autowired private val readingRepository: ReadingRepository,
        @Autowired private val webSocketController: WebSocketController) {

    private val log = LoggerFactory.getLogger(this.javaClass)

    fun getConsumption(): GetRealtimeResponse {
        return sendCommand(GetRealtime() as TPLinkCommand<TPLinkResponse>) as GetRealtimeResponse
    }

    fun getInfo() = sendCommand(Info() as TPLinkCommand<TPLinkResponse>)

    fun sendClose() = sendCommand(SetRelayState(false) as TPLinkCommand<TPLinkResponse>)

    fun sendOpen() = sendCommand(SetRelayState(true) as TPLinkCommand<TPLinkResponse>)

    fun sendReset() = sendCommand(Reset())

    @Synchronized
    private fun sendCommand(command: TPLinkCommand<TPLinkResponse>): TPLinkResponse? {
        val serialized = command.serialize()
        //log.info("Request: $serialized")
        val encrypted = encryptionService.encrypt(serialized)

        val socket = Socket()
        socket.connect(InetSocketAddress(ip, port))
        val outputStream = socket.getOutputStream()
        outputStream.write(encrypted)
        outputStream.flush()

        val inputStream = socket.getInputStream()

        val responseArray = ByteArray(2048)
        val bytesRead = inputStream.read(responseArray)
        //log.info("Read $bytesRead bytes.")
        val decrypted = encryptionService.decrypt(responseArray, bytesRead)
        //log.info("Answer: $decrypted")
        inputStream.close()
        outputStream.close()
        socket.close()
        return decrypted?.let {
            mapper.readValue(it, command.resultClass)
        }
    }

    @Scheduled(initialDelay = 1, fixedDelay = 1000)
    fun scheduledReading() = getConsumption().let {
        val reading = Reading(
                voltage_mv = it.emeter.get_realtime.voltage_mv,
                current_ma = it.emeter.get_realtime.current_ma,
                power_mw = it.emeter.get_realtime.power_mw,
                total_wh = it.emeter.get_realtime.total_wh
        )
        readingRepository.save(reading)
        webSocketController.publishReading(reading)
    }

}