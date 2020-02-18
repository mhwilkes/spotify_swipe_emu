package emu.dev.spotify_swipe.api.data

data class Artist(
    val external_urls: Map<String, String> = mapOf(),
    val followers: Follower?,
    val genres: List<String>?,
    val href: String?,
    val id: String?,
    val images: List<Image>,
    val name: String?,
    val popularity: Int?,
    val type: String?,
    val uri: String?
)