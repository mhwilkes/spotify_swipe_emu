package emu.dev.spotify_swipe.api.data

import java.io.Serializable

data class Image(
    val height: Int?,
    val url: String?,
    val width: Int
) : Serializable