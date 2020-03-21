package com.sajjady.starplayerservice.Common.DatabaseOperation.ReadPages

import com.sajjady.starplayerservice.Common.GetMusic.GetMusicData
import org.springframework.http.ResponseEntity
import java.util.concurrent.CompletableFuture

class GetLastPageEntityInfo : IGetLastPageEntityInfo, GetMusicData() {
    override fun getLastPageEntityInfo(reqPageNumber: String): CompletableFuture<ResponseEntity<String>> {
        return provideWebClient("browser", "featured", reqPageNumber).postQuery().toEntity(String::class.java).toFuture()
    }
}
