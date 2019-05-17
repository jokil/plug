package com.jkilp.plug.repository

import com.jkilp.plug.entity.Reading
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.sql.Timestamp

interface ReadingRepository: JpaRepository<Reading, Long> {

    @Query("SELECT r FROM Reading r WHERE r.timestamp >= ?1 AND r.timestamp <= ?2 ORDER BY r.timestamp")
    fun findRange(from: Timestamp, to: Timestamp): List<Reading>?
}