package com.sajjady.starplayerservice

import org.junit.jupiter.api.Test
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription
import org.springframework.boot.test.context.SpringBootTest
import reactor.core.publisher.Flux
import reactor.core.publisher.FluxSink
import java.util.function.LongConsumer

// @SpringBootTest
class StarplayerserviceApplicationTests {

    @Test
    fun contextLoads() {
        /*val musicLink = "https://www.youtube.com/watch?v=UfOxcrxhC0s"
        val runTime = Runtime.getRuntime()
        val executablePath = "youtube-dl.exe"
        val process: Process = runTime.exec("youtube-dl.exe -f mp3 --get-url --audio-format mp3 $musicLink")
        println(process.outputStream.toString())*/
        val flux = Flux.create<String> { t: FluxSink<String>? ->
            t!!.onRequest { t.next("sajjad") }

        }
        flux.subscribeWith(object : Subscriber<String> {
            override fun onComplete() {

            }

            override fun onSubscribe(s: Subscription?) {
                s!!.request(1)

            }

            override fun onNext(t: String?) {

            }

            override fun onError(t: Throwable?) {
                TODO("Not yet implemented")
            }

        })

        flux.doOnNext { t ->
            println(t)
        }.subscribe().dispose()


    }

}
