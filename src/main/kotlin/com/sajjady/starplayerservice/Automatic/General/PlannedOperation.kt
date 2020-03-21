package com.sajjady.starplayerservice.Automatic.General

import com.sajjady.starplayerservice.Automatic.ReadPages.ReadPage
import com.sajjady.starplayerservice.Automatic.WebPageNavigation.PageNavigator
import com.sajjady.starplayerservice.Common.Dao.MusicScheduleModelDao
import com.sajjady.starplayerservice.Common.Model.WebPageModel
import org.jsoup.Jsoup
import org.jsoup.internal.StringUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Component

@Component
public class PlannedOperation : IPlannedOperation {

    @Autowired
    lateinit var musicScheduleDao: MusicScheduleModelDao

    // private var entity = mutableListOf<MusicBrowsingSpecs>()
    override var operationIsStressful: Boolean = false
    override fun startOperation() {
        val firstNumber = musicScheduleDao.count()
        val pageNavigator: IPageNavigator = PageNavigator()
        var numberOfTracks = 0
        pageNavigator.start()
        pageNavigator.doAfterNavi = object : IDoAfterNavigating {
            override fun doAfterNavigate(t: WebPageModel): Boolean {
                val readPage: IReadPage = ReadPage()
                val entities = readPage.readPage(t.contents!!, t.pageNumber!!)
                musicScheduleDao.saveAll(entities)
                return (musicScheduleDao.count() - firstNumber) < 100
            }
        }
        pageNavigator.doWhenFinish = object : IDoAfterFinish {
            override fun doAfterFinish() {
                // musicScheduleDao!!.saveAll(entity)
                println("is finished")
            }
        }

    }

}