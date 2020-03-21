package com.sajjady.starplayerservice.Automatic.Links

import com.sajjady.starplayerservice.Automatic.General.IReadLinks
import com.sajjady.starplayerservice.Common.Model.MusicBrowsingSpecs
import org.jsoup.Jsoup
import javax.tools.DocumentationTool

class ReadLinks : IReadLinks {
    override fun readLinks(page: String, number: Int): MutableList<MusicBrowsingSpecs> {
        val musicBrowsingSpecs = mutableListOf<MusicBrowsingSpecs>()
        val doc = Jsoup.parse(page).body()
        val musicInBox = doc.getElementsByClass("col-4 col-sm-4 col-md-2 col-lg-2 col-xl-2 mb-3 musicbox-item")
        musicInBox.forEach {
            val url = it.attr("mtp-data-song")
            val name = it.attr("mtp-data-title")
            val artist = it.attr("mtp-data-artist")
            val cover = it.attr("mtp-data-thumb")
            val id = it.attr("mtp-data-id")
            musicBrowsingSpecs.add(
                    MusicBrowsingSpecs(
                            name = name.toString(),
                            artist = artist.toString(),
                            cover = cover.toString(),
                            musicLink = url.toString(),
                            page = number.toLong(),
                            id = id.toLong()
                    ))
        }
        return musicBrowsingSpecs
    }
}