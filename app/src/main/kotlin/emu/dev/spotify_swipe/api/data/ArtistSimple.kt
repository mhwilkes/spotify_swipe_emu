package emu.dev.spotify_swipe.api.data

data class ArtistSimple(
    val external_urls: Map<String, String> = mapOf(),
    val href: String?,
    val id: String?,
    val name: String?,
    val type: String?,
    val uri: String?
)
