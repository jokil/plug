package com.jkilp.plug.entity

import java.sql.Timestamp
import java.time.Instant
import javax.persistence.*

@Entity
data class Reading(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        val voltage_mv: Long? = null,
        val current_ma: Long? = null,
        val power_mw: Long? = null,
        val total_wh: Long? = null,
        val timestamp: Timestamp = Timestamp.from(Instant.now())
)