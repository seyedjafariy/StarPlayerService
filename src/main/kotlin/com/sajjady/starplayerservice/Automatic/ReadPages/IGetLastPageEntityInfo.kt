package com.sajjady.starplayerservice.Automatic.ReadPages

import org.springframework.http.ResponseEntity
import java.util.concurrent.CompletableFuture

interface IGetLastPageEntityInfo {
    fun getLastPageEntityInfo(reqPageNumber: String): CompletableFuture<ResponseEntity<String>>
}