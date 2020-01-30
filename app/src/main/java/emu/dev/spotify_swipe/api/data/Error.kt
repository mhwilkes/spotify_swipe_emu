package emu.dev.spotify_swipe.api.data

import java.io.Serializable

data class Error(
    val status: Int?,
    val message: String?
) : Serializable