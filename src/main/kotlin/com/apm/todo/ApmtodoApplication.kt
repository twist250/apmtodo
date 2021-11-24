package com.apm.todo

import org.apache.juli.logging.LogFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.boot.runApplication
import org.springframework.context.event.EventListener

@SpringBootApplication
class ApmtodoApplication {
    private val log = LogFactory.getLog(ApmtodoApplication::class.java)

    @EventListener(ApplicationReadyEvent::class)
    fun applicationStarted() {
        log.info("Application started successfully😀")
    }
}

fun main(args: Array<String>) {
    runApplication<ApmtodoApplication>(*args)
}
