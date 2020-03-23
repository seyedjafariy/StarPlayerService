package com.sajjady.starplayerservice.Automatic.Schedule

import com.sajjady.starplayerservice.Automatic.General.PlannedOperation
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.text.SimpleDateFormat

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired
import java.util.*

@Component
class ScheduledTasks {

    @Autowired
    lateinit var plannedOperation: PlannedOperation

    private val log: Logger = LoggerFactory.getLogger(ScheduledTasks::class.java)

    private val dateFormat = SimpleDateFormat("HH:mm:ss")

    @Scheduled(cron = "0 3 0 * * ?")
    fun getMusicsBySchedule() {
        log.info("The time is now {}", dateFormat.format(Date()))
        plannedOperation.startOperation()
    }
}



