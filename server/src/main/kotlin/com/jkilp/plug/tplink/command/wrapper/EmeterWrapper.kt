package com.jkilp.plug.tplink.command.wrapper

import com.fasterxml.jackson.annotation.JsonIgnore
import com.jkilp.plug.tplink.command.`interface`.EmeterCommand
import com.jkilp.plug.tplink.command.`interface`.TPLinkCommand
import com.jkilp.plug.tplink.response.`interface`.TPLinkResponse

abstract class EmeterWrapper<T: TPLinkResponse>(
        val emeter: EmeterCommand,

        @JsonIgnore
        override val resultClass: Class<T>): TPLinkCommand<T>