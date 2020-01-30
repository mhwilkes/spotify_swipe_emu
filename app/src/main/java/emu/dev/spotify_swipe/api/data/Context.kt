package emu.dev.spotify_swipe.api.data

import java.io.Serializable

data class Context(
    val type: String?,
    val href: String?,
    val external_urls: ExternalURL?,
    val uri: String?
) : Serializable