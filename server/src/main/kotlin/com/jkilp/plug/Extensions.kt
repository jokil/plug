package com.jkilp.plug

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.module.kotlin.KotlinModule
import java.text.SimpleDateFormat
import java.util.*

private fun initMapper(): ObjectMapper {
    val mapper = ObjectMapper().registerModule(KotlinModule())
    mapper.dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    mapper.dateFormat.timeZone = TimeZone.getTimeZone("UTC")
    //mapper.propertyNamingStrategy = PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES
    return mapper
}

val mapper = initMapper()
inline fun <reified T> String.deserialize(): T = mapper.readValue<T>(this, T::class.java)
inline fun <reified T> String.deserializeList(): List<T> = mapper.readValue<List<T>>(this, mapper.typeFactory.constructCollectionType(List::class.java, T::class.java))
fun Any.serialize() = mapper.writeValueAsString(this)