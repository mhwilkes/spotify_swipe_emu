package emu.dev.spotify_swipe.api.data

import java.io.Serializable

data class TrackLink(
    val external_urls: ExternalURL?,
    val href: String?,
    val id: String?,
    val type: String?,
    val uri: String?
) : Serializable