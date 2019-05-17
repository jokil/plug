package com.jkilp.plug.tplink.command

import com.jkilp.plug.tplink.command.`interface`.SystemCommand
import com.jkilp.plug.tplink.command.wrapper.SystemWrapper
import com.jkilp.plug.tplink.response.InfoResponse

class Info: SystemWrapper<InfoResponse>(GetSysInfo(), resultClass = InfoResponse::class.java) {
    data class GetSysInfo(val get_sysinfo: String? = null) : SystemCommand
}

/*
    {"system":{"get_sysinfo":null}}
 */