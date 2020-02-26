package emu.dev.spotify_swipe.api.data

data class Error(
    val status: Int?,
    val message: String?
)

data class ErrorPlayer(
    val status: Int?,
    val message: String?,
    val reason: String
)