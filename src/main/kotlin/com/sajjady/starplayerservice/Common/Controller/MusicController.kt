package com.sajjady.starplayerservice.Common.Controller

import org.springframework.util.ResourceUtils
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import java.io.BufferedReader
import java.io.InputStreamReader

@RestController
class MusicController {
    @ResponseBody
    @GetMapping(params = ["musicName"], path = ["/api/request/byName"])
    fun searchMusic(@RequestParam musicName: String): String?/*CompletableFuture<ResponseEntity<MusicModel>>*/ {
        // val pb = ProcessBuilder("myCommand", "myArg1", "myArg2")
        // pb.directory(File.)
        // val p = pb.start()
        val runTime = Runtime.getRuntime()


        val executablePath = "classpath:youtube-dl.exe"

        val file = ResourceUtils.getFile(executablePath)

        val process: Process = runTime.exec("${file.path} -f mp3 --get-url --audio-format mp3 https://www.youtube.com/watch?v=L6VJPHC5S8I")

        process.waitFor()

        println("is Alive : " + process.info().commandLine().toString())
        var response = ""

        val `in` = BufferedReader(InputStreamReader(process.inputStream))
        var line: String?
        while (`in`.readLine() != null) {
            response += `in`.readLine()
        }
        // process.waitFor()
        // `in`.close()
        println(response)
        return response
        /* val musicByNameObj: IGetMusicByName = GetMusicDataByName()
         return musicByNameObj.getMusic(musicName).toFuture().whenCompleteAsync { t, u ->

         }*/
    }

}