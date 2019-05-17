package com.jkilp.plug.tplink.response

import com.jkilp.plug.tplink.response.`interface`.TPLinkResponse

class InfoResponse(val system: Systemwrap): TPLinkResponse {
    class Systemwrap(val get_sysinfo: GetSysInfo) {
        class GetSysInfo(
                val sw_ver: String,
                val hw_ver: String,
                val type: String,
                val model: String,
                val mac: String,
                val dev_name: String,
                val alias: String,
                val relay_state: Int,
                val on_time: Long,
                val active_mode: String,
                val feature: String,
                val updating: Int,
                val icon_hash: String,
                val rssi: Int,
                val led_off: Int,
                val longitude_i: Double,
                val latitude_i: Double,
                val hwId: String,
                val fwId: String,
                val deviceId: String,
                val oemId: String,
                val err_code: Int,
                val next_action: NextAction) {
            class NextAction(val type: Int)
        }
    }
}
/*
{
  "system": {
    "get_sysinfo": {
      "sw_ver": "1.5.4 Build 180815 Rel.121440",
      "hw_ver": "2.0",
      "type": "IOT.SMARTPLUGSWITCH",
      "model": "HS110(EU)",
      "mac": "D8:0D:17:AD:DF:7A",
      "dev_name": "Smart Wi-Fi Plug With Energy Monitoring",
      "alias": "TP-LINK_Smart Plug_DF7A",
      "relay_state": 1,
      "on_time": 661,
      "active_mode": "none",
      "feature": "TIM:ENE",
      "updating": 0,
      "icon_hash": "",
      "rssi": -42,
      "led_off": 0,
      "longitude_i": 0,
      "latitude_i": 0,
      "hwId": "044A516EE63C875F9458DA25C2CCC5A0",
      "fwId": "00000000000000000000000000000000",
      "deviceId": "80061FD84112D876D53822ADFC9229B21B1A5613",
      "oemId": "1998A14DAA86E4E001FD7CAF42868B5E",
      "next_action": {
        "type": -1
      },
      "err_code": 0
    }
  }
}
 */