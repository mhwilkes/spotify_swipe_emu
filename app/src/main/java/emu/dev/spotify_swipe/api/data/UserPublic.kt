package emu.dev.spotify_swipe.api.data

import java.io.Serializable

data class UserPublic(
    val display_name: String?,
    val external_urls: ExternalURL?,
    val followers: Follower?,
    val href: String?,
    val id: String?,
    val images: Array<Image>,
    val type: String?,
    val uri: String?
) : Serializable