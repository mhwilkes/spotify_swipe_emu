package emu.dev.spotify_swipe.api

abstract class ErrorPlayer(
    val status: Int?,
    val message: String?,
    val reason: String
)
