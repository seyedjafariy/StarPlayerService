package com.sajjady.starplayerservice.Common.Dao

import com.sajjady.starplayerservice.Common.Model.MusicBrowsingSpecs
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MusicScheduleModelDao : CrudRepository<MusicBrowsingSpecs, Int> {
}