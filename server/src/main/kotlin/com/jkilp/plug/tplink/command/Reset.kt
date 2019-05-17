package com.jkilp.plug.tplink.command

import com.jkilp.plug.tplink.command.`interface`.SystemCommand
import com.jkilp.plug.tplink.command.common.Delay
import com.jkilp.plug.tplink.command.wrapper.SystemWrapper
import com.jkilp.plug.tplink.response.`interface`.TPLinkResponse

class Reset(delay: Int = 1) : SystemWrapper<TPLinkResponse>(ResetWithDelay(delay), resultClass = TPLinkResponse::class.java) {
    data class ResetWithDelay(
            private val delay: Int,
            val reset: Delay = Delay(delay)
    ) : SystemCommand
}

/*
{"system":{"reset":{"delay":1}}}
 */