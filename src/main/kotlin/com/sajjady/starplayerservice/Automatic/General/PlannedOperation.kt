package com.sajjady.starplayerservice.Automatic.General

import com.sajjady.starplayerservice.Automatic.ReadPages.ReadPage
import com.sajjady.starplayerservice.Automatic.WebPageNavigation.PageNavigator
import com.sajjady.starplayerservice.Common.Dao.MusicScheduleModelDao
import com.sajjady.starplayerservice.Common.Model.MusicBrowsingSpecs
import com.sajjady.starplayerservice.Common.Model.WebPageModel
import com.sun.istack.logging.Logger
import org.hibernate.exception.ConstraintViolationException
import org.jsoup.Jsoup
import org.jsoup.internal.StringUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Component
import java.sql.SQLException

@Component
public class PlannedOperation : IPlannedOperation {

    @Autowired
    lateinit var musicScheduleDao: MusicScheduleModelDao

    // private var entity = mutableListOf<MusicBrowsingSpecs>()
    override var operationIsStressful: Boolean = false
    override fun startOperation() {
        val firstNumber = musicScheduleDao.count()
        val firstValue = musicScheduleDao.findAll() as MutableList
        val pageNavigator: IPageNavigator = PageNavigator()
        pageNavigator.start()
        pageNavigator.doAfterNavi = object : IDoAfterNavigating {
            override fun doAfterNavigate(t: WebPageModel): Boolean {
                val readPage: IReadPage = ReadPage()
                val entities = readPage.readPage(t.contents!!, t.pageNumber!!)
                if (entities.isNotEmpty())
                    entities.forEach {
                        try {
                            musicScheduleDao.save(it)
                        } catch (e: Exception) {
                            println(e.message + "is conflicted")
                        }
                    }
                firstValue.addAll(entities)
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