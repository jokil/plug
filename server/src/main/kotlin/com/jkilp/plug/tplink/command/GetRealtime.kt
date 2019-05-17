package com.jkilp.plug.tplink.command

import com.jkilp.plug.tplink.command.`interface`.EmeterCommand
import com.jkilp.plug.tplink.command.wrapper.EmeterWrapper
import com.jkilp.plug.tplink.response.GetRealtimeResponse

class GetRealtime: EmeterWrapper<GetRealtimeResponse>(
        resultClass = GetRealtimeResponse::class.java,
        emeter = GetRealtimeComm()) {

    data class GetRealtimeComm(val get_realtime: String? = null): EmeterCommand
}

/*
  {"emeter":{"get_realtime":{}}}
 */