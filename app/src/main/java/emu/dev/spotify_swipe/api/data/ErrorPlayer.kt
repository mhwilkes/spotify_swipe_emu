package emu.dev.spotify_swipe.api.data

import java.io.Serializable

data class ErrorPlayer(
    val status: Int?,
    val message: String?,
    val reason: String
) : Serializable
