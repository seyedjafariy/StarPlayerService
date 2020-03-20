package com.sajjady.starplayerservice.Automatic.Schedule

import com.sajjady.starplayerservice.Automatic.General.IDoAfterFinish
import com.sajjady.starplayerservice.Automatic.General.IDoAfterNavigating
import com.sajjady.starplayerservice.Automatic.General.IPageNavigator
import com.sajjady.starplayerservice.Common.Controller.Dao.MusicScheduleModelDao
import com.sajjady.starplayerservice.Automatic.WebPageNavigation.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.text.SimpleDateFormat

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*

@Component
class ScheduledTasks(@Autowired val musicScheduleDao: MusicScheduleModelDao) {


    private val log: Logger = LoggerFactory.getLogger(ScheduledTasks::class.java)

    private val dateFormat = SimpleDateFormat("HH:mm:ss")

    @Scheduled(fixedRate = 120000)
    fun getMusicsBySchedule() {
        log.info("The time is now {}", dateFormat.format(Date()))
        val pageNavigator: IPageNavigator = PageNavigator()
        pageNavigator.start()
        pageNavigator.doAfterNavi = object : IDoAfterNavigating {
            override fun doAfterNavigate(): Boolean {
                println("a stage is done")
                return true
            }
        }
        pageNavigator.doWhenFinish = object : IDoAfterFinish {
            override fun doAfterFinish() {
                println("is finished")
            }
        }


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




