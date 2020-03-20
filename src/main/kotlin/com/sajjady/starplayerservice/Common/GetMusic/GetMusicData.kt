package com.sajjady.starplayerservice.Common.GetMusic

import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.util.UriBuilder


abstract class GetMusicData {
    private val BASE_URL = "https://mrtehran.com/"
    protected fun provideWebClient(vararg paths: String): WebClient {
        return WebClient.builder().baseUrl("$BASE_URL${paths.joinToString(postfix = "/", separator = "/")}").build()
    }

    protected fun WebClient.getQuery(vararg pair: Pair<String, String>): WebClient.ResponseSpec {
        val args: MultiValueMap<String, String> = LinkedMultiValueMap()
        pair.forEach {
            args.add(it.first, it.second)
        }
        return get().uri { uriBuilder: UriBuilder? ->
            if (args.isNotEmpty())
                uriBuilder!!.queryParams(args)
            uriBuilder!!.build()
        }.retrieve()
    }

    protected fun WebClient.postQuery(vararg pair: Pair<String, String>): WebClient.ResponseSpec {
        val args: MultiValueMap<String, String> = LinkedMultiValueMap()
        pair.forEach {
            args.add(it.first, it.second)
        }
        return post().uri { uriBuilder: UriBuilder? ->
            if (args.isNotEmpty())
                uriBuilder!!.queryParams(args)
            uriBuilder!!.build()
        }.retrieve()
    }


}