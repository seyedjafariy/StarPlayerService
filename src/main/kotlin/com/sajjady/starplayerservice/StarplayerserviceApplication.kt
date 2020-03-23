package com.sajjady.starplayerservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@EnableJpaRepositories(basePackages = ["com.sajjady.starplayerservice.Common"])
@SpringBootApplication(scanBasePackages = ["com.sajjady.starplayerservice"])
class StarplayerserviceApplication

fun main(args: Array<String>) {
    runApplication<StarplayerserviceApplication>(*args)
}