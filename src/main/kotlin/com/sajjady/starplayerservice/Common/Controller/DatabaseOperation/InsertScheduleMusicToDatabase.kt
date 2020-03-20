package com.sajjady.starplayerservice.Common.Controller.DatabaseOperation

import com.sajjady.starplayerservice.Common.Controller.Dao.MusicScheduleModelDao
import com.sajjady.starplayerservice.Common.Controller.DatabaseOperation.Interface.IInsertScheduleMusicToDatabase
import com.sajjady.starplayerservice.Common.Model.MusicModel
import org.springframework.beans.factory.annotation.Autowired

class InsertScheduleMusicToDatabase(@Autowired val musicSDao: MusicScheduleModelDao) : InsertToDatabase(), IInsertScheduleMusicToDatabase {

    override fun IInsertScheduleMusicToDatabase(musicData: String) {

        val musicScheduleEntity: MusicModel.Data = MusicModel.Data()


    }
}