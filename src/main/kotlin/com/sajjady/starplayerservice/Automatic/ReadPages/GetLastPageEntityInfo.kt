package com.sajjady.starplayerservice.Automatic.ReadPages

import com.sajjady.starplayerservice.Common.GetMusic.GetMusicData
import org.springframework.http.ResponseEntity
import java.util.concurrent.CompletableFuture

class GetLastPageEntityInfo : IGetLastPageEntityInfo, GetMusicData() {
    override fun getLastPageEntityInfo(reqPageNumber: String): CompletableFuture<ResponseEntity<String>> {
        return provideWebClient("browse", "featured", reqPageNumber).getQuery().toEntity(String::class.java).toFuture()
    }
}
