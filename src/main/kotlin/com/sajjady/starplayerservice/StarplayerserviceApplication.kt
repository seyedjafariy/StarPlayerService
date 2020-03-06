package com.sajjady.starplayerservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@SpringBootApplication(scanBasePackages = ["com.sajjady.starplayerservice"])
class StarplayerserviceApplication

fun main(args: Array<String>) {
    runApplication<StarplayerserviceApplication>(*args)
}
