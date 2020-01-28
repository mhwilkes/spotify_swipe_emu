package emu.dev.spotify_swipe.api

abstract class Error(
    val status: Int?,
    val message: String?
)