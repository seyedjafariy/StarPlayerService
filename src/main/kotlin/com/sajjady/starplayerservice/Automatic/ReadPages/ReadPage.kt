package com.sajjady.starplayerservice.Automatic.ReadPages

import com.sajjady.starplayerservice.Automatic.General.IReadLinks
import com.sajjady.starplayerservice.Automatic.General.IReadPage
import com.sajjady.starplayerservice.Automatic.Links.ReadLinks
import com.sajjady.starplayerservice.Common.Model.BrowsingCapabilities
import com.sajjady.starplayerservice.Common.Model.MusicBrowsingSpecs

class ReadPage : IReadPage {
    override fun readPage(page: String, number: Int): MutableList<MusicBrowsingSpecs> {
        val readLinks: IReadLinks = ReadLinks()
        return readLinks.readLinks(page, number)
    }
}