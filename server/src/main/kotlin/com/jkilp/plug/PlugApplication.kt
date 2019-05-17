package com.jkilp.plug

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PlugApplication

fun main(args: Array<String>) {
	runApplication<PlugApplication>(*args)
}
