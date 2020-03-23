package com.sajjady.starplayerservice.Common.Controller

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.sajjady.starplayerservice.Common.Dao.MusicScheduleModelDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
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
    @GetMapping(path = ["/api/request"])
    fun searchMusic(@RequestParam(required = false, defaultValue = "null") musicName: String?, @RequestParam(required = false, defaultValue = "null") artist: String?): String?/*CompletableFuture<ResponseEntity<MusicModel>>*/ {
        val mapper = jacksonObjectMapper()

        val result = musicScheduleModelDao.queryFromDatabase(artist = artist?.isNullValue(), musicName = musicName?.isNullValue())

        return mapper.writeValueAsString(result)
    }

    private fun String.isNullValue(): String? {
        return if (this == "null")
            null
        else
            this
    }

    @ResponseBody
    @GetMapping(path = ["/api/paging"])
    public fun pagingRequest(@RequestParam(required = false, defaultValue = "50") count: Int,
                             @RequestParam(required = false, defaultValue = "1") page: Int): String {
        val pageable = PageRequest.of(page, count)
        val result = musicScheduleModelDao.findAll(pageable).toMutableList()
        val mapper = jacksonObjectMapper()
        return mapper.writeValueAsString(result)
    }


}