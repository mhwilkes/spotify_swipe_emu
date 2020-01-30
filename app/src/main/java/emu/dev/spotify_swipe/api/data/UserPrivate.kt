package emu.dev.spotify_swipe.api.data

import java.io.Serializable

data class UserPrivate(
    val country: String?,
    val display_name: String?,
    val email: String?,
    val external_urls: ExternalURL?,
    val followers: Follower?,
    val href: String?,
    val id: String?,
    val images: Array<Image>?,
    val product: String?,
    val type: String?,
    val uri: String?
) : Serializable