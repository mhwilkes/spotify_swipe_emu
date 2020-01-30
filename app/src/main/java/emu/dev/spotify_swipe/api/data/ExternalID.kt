package emu.dev.spotify_swipe.api.data

import java.io.Serializable

data class ExternalID(
    val key: String?,
    val value: String?
) : Serializable