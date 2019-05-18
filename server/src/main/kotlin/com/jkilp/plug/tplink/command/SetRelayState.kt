package com.jkilp.plug.tplink.command

import com.fasterxml.jackson.annotation.JsonFormat
import com.jkilp.plug.tplink.command.`interface`.SystemCommand
import com.jkilp.plug.tplink.command.wrapper.SystemWrapper
import com.jkilp.plug.tplink.response.SetRelayStateResponse

class SetRelayState(state: Boolean): SystemWrapper<SetRelayStateResponse>(SetRelayWithState(state), SetRelayStateResponse::class.java) {
    data class SetRelayWithState(
            private val state: Boolean,
            val set_relay_state: State = State(state)): SystemCommand {
        data class State(
                @JsonFormat(shape = JsonFormat.Shape.NUMBER)
                val state: Boolean
        )
    }
}

/*
Turn On
{"system":{"set_relay_state":{"state":1}}}

Turn Off
{"system":{"set_relay_state":{"state":0}}}
 */