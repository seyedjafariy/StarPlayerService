package com.sajjady.starplayerservice.Common.Dao

import com.sajjady.starplayerservice.Common.Model.MusicBrowsingSpecs
import org.hibernate.annotations.DynamicInsert
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import javax.persistence.NamedQuery
import javax.transaction.Transactional

@Repository
interface MusicScheduleModelDao : PagingAndSortingRepository<MusicBrowsingSpecs, Int> {
    @Query(value = "SELECT * FROM musics_info WHERE (( :artist is null) or artist = :artist ) AND (( :musicName is null) or `name` = :musicName )", nativeQuery = true)
    public fun queryFromDatabase(@Param("artist") artist: String?, @Param("musicName") musicName: String?): MutableList<MusicBrowsingSpecs>




}