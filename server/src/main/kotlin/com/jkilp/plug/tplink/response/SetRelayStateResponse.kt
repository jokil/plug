package com.jkilp.plug.tplink.response

import com.jkilp.plug.tplink.response.`interface`.TPLinkResponse

class SetRelayStateResponse(val system: RelayErr): TPLinkResponse {
    class RelayErr(val set_relay_state: ErrCode) {
        class ErrCode(val err_code: Int)
    }
}

/*
{"system":{"set_relay_state":{"err_code":0}}}
 */