package com.sajjady.starplayerservice.Common.Controller

import com.sajjady.starplayerservice.Common.Dao.MusicScheduleModelDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.util.ResourceUtils
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import java.io.BufferedReader
import java.io.InputStreamReader

@RestController
class MusicController {

    @Autowired
    lateinit var musicScheduleModelDao: MusicScheduleModelDao

    @ResponseBody
    @GetMapping(path = ["/api/request/byName"])
    fun searchMusic(@RequestParam(required = false, defaultValue = "null") musicName: String?, @RequestParam(required = false, defaultValue = "null") artist: String?): String?/*CompletableFuture<ResponseEntity<MusicModel>>*/ {
        return musicScheduleModelDao.queryFromDatabase(artist = artist?.isNullValue(), musicName = musicName?.isNullValue()).toString()
    }

    private fun String.isNullValue(): String? {
        return if (this == "null")
            null
        else
            this
    }

}