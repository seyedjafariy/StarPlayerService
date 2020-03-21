/*
package com.sajjady.starplayerservice.Common.Model

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

data class MusicModel(
        @JsonProperty("data")
        var `data`: List<Data?>? = null,
        @JsonProperty("next")
        var next: String? = null,
        @JsonProperty("total")
        var total: Int? = null
) {
    @Table(name = "data")
    @Entity(name = "data")
    */
/*@SecondaryTables(
            SecondaryTable(name = "album", pkJoinColumns = [PrimaryKeyJoinColumn(name = "id")]),
            SecondaryTable(name = "artist", pkJoinColumns = [PrimaryKeyJoinColumn(name = "id")]))*//*

    data class Data(
            @JsonProperty("id")
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            @get:Id
            var id: Long? = null,
            @get:OneToOne(targetEntity = Album::class)
            @get:JoinColumn(name = "album_id")
            var album: Album? = null,
            @get:JoinColumn(name = "artist_id")
            @get:OneToOne(targetEntity = Artist::class)
            var artist: Artist? = null,
            var duration: Int? = null,
            var explicitContentCover: Int? = null,
            var explicitContentLyrics: Int? = null,
            var explicitLyrics: Boolean? = null,
            var link: String? = null,
            var preview: String? = null,
            var rank: Int? = null,
            var readable: Boolean? = null,
            var title: String? = null,
            var titleShort: String? = null,
            var titleVersion: String? = null,
            var type: String? = null
    ) {
        @Table(name = "album")
        @Entity(name = "album")
        data class Album(
                @get:Id
                @Column(name = "album_id")
                @GeneratedValue(strategy = GenerationType.IDENTITY)
                var id: Long? = null,
                @get:Column(name = "cover")
                var cover: String? = null,
                @Column(name = "coverBig")
                var coverBig: String? = null,
                var coverMedium: String? = null,
                var coverSmall: String? = null,
                var coverXl: String? = null,
                @get:Column(name = "title_album")
                var title: String? = null,
                @get:Column(name = "tracklist_album")
                var tracklist: String? = null,
                @get:Column(name = "type_album")
                var type: String? = null)

        @Table(name = "artist")
        @Entity(name = "artist")
        data class Artist(
                @get:Id
                @Column(name = "artist_id")
                @GeneratedValue(strategy = GenerationType.IDENTITY)
                var id: Long? = null,
                var name: String? = null,
                var picture: String? = null,
                var pictureBig: String? = null,
                var pictureMedium: String? = null,
                var pictureSmall: String? = null,
                var pictureXl: String? = null,
                @get:Column(name = "tracklist_artist")
                var tracklist: String? = null,
                @get:Column(name = "type_artist")
                var type: String? = null
        ) {

        }
    }
}*/
