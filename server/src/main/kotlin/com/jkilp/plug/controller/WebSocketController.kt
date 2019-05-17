package com.jkilp.plug.controller

import com.jkilp.plug.entity.Reading
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller
import org.springframework.messaging.simp.SimpMessagingTemplate



@Controller
class WebSocketController(@Autowired private val template: SimpMessagingTemplate) {

    fun publishReading(reading: Reading) = template.convertAndSend("/topic/readings", reading)

}