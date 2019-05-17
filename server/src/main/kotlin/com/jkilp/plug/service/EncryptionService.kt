package com.jkilp.plug.service

import org.springframework.stereotype.Service
import java.nio.ByteBuffer

@Service
class EncryptionService {

    fun decrypt(message: ByteArray?, size: Int): String? {
        if (message == null || message.isEmpty()) return null

        // First 4 indices are trash
        val sliced = message.sliceArray(4 until size)
        var key = 0xAB
        for (i in sliced.indices) {
            val byte = (key xor sliced[i].toInt()).toByte()
            key = sliced[i].toInt()
            sliced[i] = byte
        }
        return String(sliced, Charsets.UTF_8)
    }


    fun encrypt(command: String): ByteArray {
        // Encrypt the command
        val data = IntArray(command.length)
        var key = 0xAB
        for (i in 0 until command.length) {
            data[i] = command[i].toInt() xor key
            key = data[i]
        }

        // Wrap the encrypted command
        val bufferHeader = ByteBuffer.allocate(4).putInt(command.length).array()
        val byteBuffer = ByteBuffer.allocate(bufferHeader.size + data.size).put(bufferHeader)

        for (num in data) {
            byteBuffer.put(num.toByte())
        }

        return byteBuffer.array()
    }
}