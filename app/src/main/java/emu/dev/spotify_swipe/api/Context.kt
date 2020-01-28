package emu.dev.spotify_swipe.api

abstract class Context(
    val type: String?,
    val href: String?,
    val external_urls: ExternalURL?,
    val uri: String?
)