package com.jkilp.plug.tplink.response

import com.jkilp.plug.tplink.response.`interface`.TPLinkResponse

class GetRealtimeResponse(val emeter: RealTimeResult): TPLinkResponse {
    class RealTimeResult(val get_realtime: Readings) {
        class Readings(
                val voltage_mv: Long,
                val current_ma: Long,
                val power_mw: Long,
                val total_wh: Long,
                val err_code: Int
        )
    }
}

/*
{"emeter":{"get_realtime":{"voltage_mv":235870,"current_ma":23,"power_mw":0,"total_wh":1,"err_code":0}}}
 */