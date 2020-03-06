package com.sajjady.starplayerservice.GetMusic

import com.sajjady.starplayerservice.GetMusic.Interface.IGetMusicByName
import com.sajjady.starplayerservice.Model.MusicModel
import org.springframework.http.ResponseEntity
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.util.UriBuilder
import reactor.core.publisher.Mono


class GetMusicDataByName : GetMusicData(), IGetMusicByName {

    override fun getMusic(musicName: String): Mono<ResponseEntity<MusicModel>> {
        val webClient = WebClient.builder().baseUrl("https://api.deezer.com/search").build()
        return webClient.get().uri { uriBuilder: UriBuilder? ->
            uriBuilder!!.path("/track/").queryParam("q", musicName).build()
        }.retrieve().toEntity(MusicModel::class.java)
    }

}