package emu.dev.spotify_swipe.api.data

import java.io.Serializable

data class Artist(
    val external_urls: ExternalURL?,
    val followers: Follower?,
    val genres: Array<String>?,
    val href: String?,
    val id: String?,
    val images: Array<Image>,
    val name: String?,
    val popularity: Int?,
    val type: String?,
    val uri: String?
) : Serializable