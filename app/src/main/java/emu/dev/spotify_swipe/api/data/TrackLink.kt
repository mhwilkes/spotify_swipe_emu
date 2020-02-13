package emu.dev.spotify_swipe.api.data

data class TrackLink(
    val external_urls: Map<String, String> = mapOf(),
    val href: String?,
    val id: String?,
    val type: String?,
    val uri: String?
)