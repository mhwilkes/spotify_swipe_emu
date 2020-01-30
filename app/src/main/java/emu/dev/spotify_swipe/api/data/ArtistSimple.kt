package emu.dev.spotify_swipe.api.data

import java.io.Serializable

data class ArtistSimple(
    val external_urls: ExternalURL,
    val href: String?,
    val id: String?,
    val name: String?,
    val type: String?,
    val uri: String?
) : Serializable