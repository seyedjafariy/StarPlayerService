package com.sajjady.starplayerservice.Schedule

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@Configuration
@ConditionalOnProperty(name = ["spring.enable.scheduling"])
class ScheduleEnabling 