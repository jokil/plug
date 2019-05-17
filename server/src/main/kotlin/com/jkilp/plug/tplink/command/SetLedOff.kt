package com.jkilp.plug.tplink.command

import com.fasterxml.jackson.annotation.JsonFormat
import com.jkilp.plug.tplink.command.`interface`.SystemCommand
import com.jkilp.plug.tplink.command.wrapper.SystemWrapper
import com.jkilp.plug.tplink.response.`interface`.TPLinkResponse

class SetLedOff(off: Boolean) : SystemWrapper<TPLinkResponse>(SetWithOff(off), TPLinkResponse::class.java) {
    data class SetWithOff(
            private val off: Boolean,
            val set_led_off: Off = Off(off)): SystemCommand {
        data class Off(
                @JsonFormat(shape = JsonFormat.Shape.NUMBER)
                val off: Boolean
        )
    }
}

/*
Turn Off Device LED (Night mode)
{"system":{"set_led_off":{"off":1}}}

 */