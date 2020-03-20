package com.sajjady.starplayerservice.Common.GetMusic

import com.sajjady.starplayerservice.Common.GetMusic.Interface.IGetMusicByName
import com.sajjady.starplayerservice.Common.Model.MusicModel
import org.springframework.http.ResponseEntity
import reactor.core.publisher.Mono


class GetMusicDataByName : GetMusicData(), IGetMusicByName {

    override fun getMusic(musicName: String): Mono<ResponseEntity<MusicModel>> {
        return provideWebClient("search", "track").getQuery(Pair("q", musicName)).toEntity(MusicModel::class.java)
    }

}