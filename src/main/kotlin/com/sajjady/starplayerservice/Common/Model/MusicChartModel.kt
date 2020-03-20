/*
package com.sajjady.starplayerservice.Common.Model

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*


data class MusicChartModel(
        @JsonProperty("albums")
        var albums: Albums?,
        @JsonProperty("artists")
        var artists: Artists?,
        @JsonProperty("playlists")
        var playlists: Playlists?,
        @JsonProperty("podcasts")
        var podcasts: Podcasts?,
        @JsonProperty("tracks")
        var tracks: Tracks?
) {
    data class Albums(
            @JsonProperty("data")
            var `data`: List<Data?>?,
            @JsonProperty("total")
            var total: Int?
    ) {
        @Entity(name = "tbl_album_data")
        @Table(name = "tbl_album_data")
        data class Data(
                @JsonProperty("id")
                @get:Id
                @Column(name = "id")
                @GeneratedValue(strategy = GenerationType.IDENTITY)
                var id: Long,
                @get:OneToOne(targetEntity = Artist::class)
                @get:JoinColumn(name = "tbl_album_id")
                @JsonProperty("artist")
                var artist: Artist?,
                @JsonProperty("cover")
                var cover: String?,
                @JsonProperty("cover_big")
                var coverBig: String?,
                @JsonProperty("cover_medium")
                var coverMedium: String?,
                @JsonProperty("cover_small")
                var coverSmall: String?,
                @JsonProperty("cover_xl")
                var coverXl: String?,
                @JsonProperty("explicit_lyrics")
                var explicitLyrics: Boolean?,
                @JsonProperty("link")
                var link: String?,
                @JsonProperty("position")
                var position: Int?,
                @JsonProperty("record_type")
                var recordType: String?,
                @JsonProperty("title")
                var title: String?,
                @JsonProperty("tracklist")
                var tracklist: String?,
                @JsonProperty("type")
                var type: String?
        ) {
            @Entity(name = "tbl_artist")
            @Table(name = "tbl_artist")
            data class Artist(
                    @JsonProperty("id")
                    var id: Int?,
                    @JsonProperty("link")
                    var link: String?,
                    @JsonProperty("name")
                    var name: String?,
                    @JsonProperty("picture")
                    var picture: String?,
                    @JsonProperty("picture_big")
                    var pictureBig: String?,
                    @JsonProperty("picture_medium")
                    var pictureMedium: String?,
                    @JsonProperty("picture_small")
                    var pictureSmall: String?,
                    @JsonProperty("picture_xl")
                    var pictureXl: String?,
                    @JsonProperty("radio")
                    var radio: Boolean?,
                    @JsonProperty("tracklist")
                    var tracklist: String?,
                    @JsonProperty("type")
                    var type: String?
            )
        }
    }

    data class Artists(
            @JsonProperty("data")
            var `data`: List<Data?>?,
            @JsonProperty("total")
            var total: Int?
    ) {
        data class Data(
                @JsonProperty("id")
                var id: Int?,
                @JsonProperty("link")
                var link: String?,
                @JsonProperty("name")
                var name: String?,
                @JsonProperty("picture")
                var picture: String?,
                @JsonProperty("picture_big")
                var pictureBig: String?,
                @JsonProperty("picture_medium")
                var pictureMedium: String?,
                @JsonProperty("picture_small")
                var pictureSmall: String?,
                @JsonProperty("picture_xl")
                var pictureXl: String?,
                @JsonProperty("position")
                var position: Int?,
                @JsonProperty("radio")
                var radio: Boolean?,
                @JsonProperty("tracklist")
                var tracklist: String?,
                @JsonProperty("type")
                var type: String?
        )
    }

    data class Playlists(
            @JsonProperty("data")
            var `data`: List<Data?>?,
            @JsonProperty("total")
            var total: Int?
    ) {
        data class Data(
                @JsonProperty("checksum")
                var checksum: String?,
                @JsonProperty("creation_date")
                var creationDate: String?,
                @JsonProperty("id")
                var id: Long?,
                @JsonProperty("link")
                var link: String?,
                @JsonProperty("nb_tracks")
                var nbTracks: Int?,
                @JsonProperty("picture")
                var picture: String?,
                @JsonProperty("picture_big")
                var pictureBig: String?,
                @JsonProperty("picture_medium")
                var pictureMedium: String?,
                @JsonProperty("picture_small")
                var pictureSmall: String?,
                @JsonProperty("picture_xl")
                var pictureXl: String?,
                @JsonProperty("public")
                var `public`: Boolean?,
                @JsonProperty("title")
                var title: String?,
                @JsonProperty("tracklist")
                var tracklist: String?,
                @JsonProperty("type")
                var type: String?,
                @JsonProperty("user")
                var user: User?
        ) {
            data class User(
                    @JsonProperty("id")
                    var id: Int?,
                    @JsonProperty("name")
                    var name: String?,
                    @JsonProperty("tracklist")
                    var tracklist: String?,
                    @JsonProperty("type")
                    var type: String?
            )
        }
    }

    data class Podcasts(
            @JsonProperty("data")
            var `data`: List<Data?>?,
            @JsonProperty("total")
            var total: Int?
    ) {
        data class Data(
                @JsonProperty("available")
                var available: Boolean?,
                @JsonProperty("description")
                var description: String?,
                @JsonProperty("fans")
                var fans: Int?,
                @JsonProperty("id")
                var id: Int?,
                @JsonProperty("link")
                var link: String?,
                @JsonProperty("picture")
                var picture: String?,
                @JsonProperty("picture_big")
                var pictureBig: String?,
                @JsonProperty("picture_medium")
                var pictureMedium: String?,
                @JsonProperty("picture_small")
                var pictureSmall: String?,
                @JsonProperty("picture_xl")
                var pictureXl: String?,
                @JsonProperty("share")
                var share: String?,
                @JsonProperty("title")
                var title: String?,
                @JsonProperty("type")
                var type: String?
        )
    }

    data class Tracks(
            @JsonProperty("data")
            var `data`: List<Data?>?,
            @JsonProperty("total")
            var total: Int?
    ) {
        data class Data(
                @JsonProperty("album")
                var album: Album?,
                @JsonProperty("artist")
                var artist: Artist?,
                @JsonProperty("duration")
                var duration: Int?,
                @JsonProperty("explicit_content_cover")
                var explicitContentCover: Int?,
                @JsonProperty("explicit_content_lyrics")
                var explicitContentLyrics: Int?,
                @JsonProperty("explicit_lyrics")
                var explicitLyrics: Boolean?,
                @JsonProperty("id")
                var id: Int?,
                @JsonProperty("link")
                var link: String?,
                @JsonProperty("position")
                var position: Int?,
                @JsonProperty("preview")
                var preview: String?,
                @JsonProperty("rank")
                var rank: Int?,
                @JsonProperty("title")
                var title: String?,
                @JsonProperty("title_short")
                var titleShort: String?,
                @JsonProperty("title_version")
                var titleVersion: String?,
                @JsonProperty("type")
                var type: String?
        ) {
            data class Album(
                    @JsonProperty("cover")
                    var cover: String?,
                    @JsonProperty("cover_big")
                    var coverBig: String?,
                    @JsonProperty("cover_medium")
                    var coverMedium: String?,
                    @JsonProperty("cover_small")
                    var coverSmall: String?,
                    @JsonProperty("cover_xl")
                    var coverXl: String?,
                    @JsonProperty("id")
                    var id: Int?,
                    @JsonProperty("title")
                    var title: String?,
                    @JsonProperty("tracklist")
                    var tracklist: String?,
                    @JsonProperty("type")
                    var type: String?
            )

            data class Artist(
                    @JsonProperty("id")
                    var id: Int?,
                    @JsonProperty("link")
                    var link: String?,
                    @JsonProperty("name")
                    var name: String?,
                    @JsonProperty("picture")
                    var picture: String?,
                    @JsonProperty("picture_big")
                    var pictureBig: String?,
                    @JsonProperty("picture_medium")
                    var pictureMedium: String?,
                    @JsonProperty("picture_small")
                    var pictureSmall: String?,
                    @JsonProperty("picture_xl")
                    var pictureXl: String?,
                    @JsonProperty("radio")
                    var radio: Boolean?,
                    @JsonProperty("tracklist")
                    var tracklist: String?,
                    @JsonProperty("type")
                    var type: String?
            )
        }
    }
}*/
