package com.jkilp.plug.tplink.command.`interface`

import com.jkilp.plug.tplink.response.`interface`.TPLinkResponse

interface TPLinkCommand<T: TPLinkResponse> {
    val resultClass: Class<T>
}