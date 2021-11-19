package com.apm.todo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ApmtodoApplication

fun main(args: Array<String>) {
    runApplication<ApmtodoApplication>(*args)
}
