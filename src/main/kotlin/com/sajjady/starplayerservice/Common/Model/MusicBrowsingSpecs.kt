package com.sajjady.starplayerservice.Common.Model


data class MusicBrowsingSpecs(
        override val website: String,
        override val etc: String?,
        override val page: Number?,
        override val musicLink: String,
        override val artist: String, override var id: Int)
    : BrowsingCapabilities