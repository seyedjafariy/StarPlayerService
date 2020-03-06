package com.sajjady.starplayerservice.GetMusic.Interface

import com.sajjady.starplayerservice.Model.MusicModel
import org.springframework.http.ResponseEntity
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


interface IGetMusicByName {
    public fun getMusic(musicName: String): Mono<ResponseEntity<MusicModel>>
}