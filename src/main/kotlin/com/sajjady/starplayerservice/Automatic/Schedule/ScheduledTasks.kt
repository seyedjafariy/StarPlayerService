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

    @Scheduled(fixedRate = 1200000)
    fun getMusicsBySchedule() {
        log.info("The time is now {}", dateFormat.format(Date()))
        plannedOperation.startOperation()

        /* val pageNavigator: IPageNavigator = PageNavigator()
        pageNavigator.start()
        pageNavigator.doAfterNavi = object : IDoAfterNavigating {
            override fun doAfterNavigate(t: String?): Boolean {
                println("a stage is done")
                return true
            }
        }
        pageNavigator.doWhenFinish = object : IDoAfterFinish {
            override fun doAfterFinish() {
                println("is finished")
            }
        }*/


        /*val flux = Flux.create<String> { t: FluxSink<String>? ->
            t!!.onRequest {
                t.next("sajjad")
            }
        }

        flux.subscribeWith(object : Subscriber<String> {
            override fun onComplete() {

            }

            override fun onSubscribe(s: Subscription?) {

            }

            override fun onNext(t: String?) {
            }

            override fun onError(t: Throwable?) {

            }

        })


        flux.doOnNext {
            printlprn(it)
        }.map { t ->
            t.length
        }.doOnSubscribe { t: Subscription? ->
            t!!.request(50)

        }.doOnComplete {

        }.subscribe().dispose()

*/
    }
}


/*private fun insertMusicToDatabase(value: List<MusicModel.Data?>?) {
        val musicModel = MusicModel()
        musicScheduleDao.saveAll(musicModel.data!!.toMutableList())
    }*/




