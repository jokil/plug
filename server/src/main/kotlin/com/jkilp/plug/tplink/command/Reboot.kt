package com.jkilp.plug.tplink.command

import com.jkilp.plug.tplink.command.`interface`.SystemCommand
import com.jkilp.plug.tplink.command.common.Delay
import com.jkilp.plug.tplink.command.wrapper.SystemWrapper
import com.jkilp.plug.tplink.response.`interface`.TPLinkResponse

class Reboot(delay: Int = 1) : SystemWrapper<TPLinkResponse>(RebootWithDelay(delay), resultClass = TPLinkResponse::class.java) {
    data class RebootWithDelay(
            private val delay: Int,
            val reboot: Delay = Delay(delay)) : SystemCommand
}

/*
{"system":{"reboot":{"delay":1}}}
 */