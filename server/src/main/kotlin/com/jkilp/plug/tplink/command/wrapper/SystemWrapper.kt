package com.jkilp.plug.tplink.command.wrapper

import com.fasterxml.jackson.annotation.JsonIgnore
import com.jkilp.plug.tplink.command.`interface`.SystemCommand
import com.jkilp.plug.tplink.command.`interface`.TPLinkCommand
import com.jkilp.plug.tplink.response.`interface`.TPLinkResponse

abstract class SystemWrapper<T: TPLinkResponse>(
        val system: SystemCommand,

        @JsonIgnore
        override val resultClass: Class<T>): TPLinkCommand<T>