package com.sajjady.starplayerservice.Common.Model

import javax.persistence.*

@Table(name = "musics_info")
@Entity(name = "music_info")
public data class MusicBrowsingSpecs(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @get:Column(name = "id")
        var id: Long? = null,
        @get:Column(name = "page")
        var page: Long? = null,
        @get:Column(name = "link", unique = true)
        var musicLink: String? = null,
        @get:Column(name = "artist")
        var artist: String? = null,
        @get:Column(name = "cover")
        var cover: String? = null,
        @get:Column(name = "music_name")
        var name: String? = null


) {

}