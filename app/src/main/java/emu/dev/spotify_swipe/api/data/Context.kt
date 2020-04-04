package emu.dev.spotify_swipe.api.data

data class Context(
    val type: String?,
    val href: String?,
    val external_urls: Map<String, String> = mapOf(),
    val uri: String?
)