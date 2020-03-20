package com.sajjady.starplayerservice.Common.Controller.Dao

import com.sajjady.starplayerservice.Common.Model.MusicModel
import org.springframework.data.repository.CrudRepository

interface MusicScheduleModelDao : CrudRepository<MusicModel.Data, Long> {
}