package emu.dev.spotify_swipe.api.data

import java.io.Serializable

data class Follower(
    val href: String?,
    val total: Int?
) : Serializable