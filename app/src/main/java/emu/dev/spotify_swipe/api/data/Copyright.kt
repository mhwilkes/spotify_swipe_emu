package emu.dev.spotify_swipe.api.data

import java.io.Serializable

data class Copyright(
    val text: String?,
    val type: String?
) : Serializable