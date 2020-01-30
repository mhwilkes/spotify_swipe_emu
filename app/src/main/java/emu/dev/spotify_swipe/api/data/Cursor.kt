package emu.dev.spotify_swipe.api.data

import java.io.Serializable

data class Cursor(
    val text: String?,
    val type: String
) : Serializable