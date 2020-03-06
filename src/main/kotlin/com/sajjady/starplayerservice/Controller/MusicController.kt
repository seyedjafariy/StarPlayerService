package com.sajjady.starplayerservice.Controller

import com.sajjady.starplayerservice.GetMusic.GetMusicDataByName
import com.sajjady.starplayerservice.Model.MusicModel
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.concurrent.CompletableFuture

@RestController
class MusicController {

    @ResponseBody
    @GetMapping(params = ["musicName"], path = ["/api/request/byName"])
    fun searchMusic(@RequestParam musicName: String): CompletableFuture<ResponseEntity<MusicModel>> {
        return GetMusicDataByName().getMusic(musicName).toFuture()
    }
}