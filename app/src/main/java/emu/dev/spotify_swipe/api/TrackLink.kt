package emu.dev.spotify_swipe.api

abstract class TrackLink(
    val external_urls: ExternalURL?,
    val href: String?,
    val id: String?,
    val type: String?,
    val uri: String?
)