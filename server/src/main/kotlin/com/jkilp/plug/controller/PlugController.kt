package com.jkilp.plug.controller

import com.jkilp.plug.entity.Reading
import com.jkilp.plug.repository.ReadingRepository
import com.jkilp.plug.service.PlugService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.sql.Timestamp
import java.time.Instant

@RestController
class PlugController(@Autowired private val plugService: PlugService, @Autowired private val readingRepository: ReadingRepository) {

    @GetMapping("consumption")
    fun getCurrentConsumption() = plugService.getConsumption()

    @GetMapping("close")
    fun sendClose() = plugService.sendClose()

    @GetMapping("open")
    fun sendOpen() = plugService.sendOpen()

    @GetMapping("reset")
    fun sendReset() = plugService.sendReset()

    @GetMapping("info")
    fun getInfo() = plugService.getInfo()

    @GetMapping("history")
    fun getHistory(@RequestParam from: Timestamp?, @RequestParam to: Timestamp?): List<Reading>? {
        if (from == null || to == null) {
            return readingRepository.findRange(Timestamp.from(Instant.now().minusSeconds(600)), Timestamp.from(Instant.now()))
        }
        return readingRepository.findRange(from, to)
    }
}