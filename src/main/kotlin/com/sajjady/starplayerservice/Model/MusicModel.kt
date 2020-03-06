package com.sajjady.starplayerservice.Model

data class MusicModel(
        val `data`: List<Data?>?,
        val next: String?,
        val total: Int?
) {
    data class Data(
            val album: Album?,
            val artist: Artist?,
            val duration: Int?,
            val explicitContentCover: Int?,
            val explicitContentLyrics: Int?,
            val explicitLyrics: Boolean?,
            val id: Int?,
            val link: String?,
            val preview: String?,
            val rank: Int?,
            val readable: Boolean?,
            val title: String?,
            val titleShort: String?,
            val titleVersion: String?,
            val type: String?
    ) {
        data class Album(
                val cover: String?,
                val coverBig: String?,
                val coverMedium: String?,
                val coverSmall: String?,
                val coverXl: String?,
                val id: Int?,
                val title: String?,
                val tracklist: String?,
                val type: String?
        )

        data class Artist(
                val id: Int?,
                val link: String?,
                val name: String?,
                val picture: String?,
                val pictureBig: String?,
                val pictureMedium: String?,
                val pictureSmall: String?,
                val pictureXl: String?,
                val tracklist: String?,
                val type: String?
        )
    }
}