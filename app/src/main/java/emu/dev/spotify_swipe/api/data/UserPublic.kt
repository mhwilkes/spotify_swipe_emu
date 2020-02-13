package emu.dev.spotify_swipe.api.data

data class UserPublic(
    val display_name: String?,
    val external_urls: Map<String, String> = mapOf(),
    val followers: Follower?,
    val href: String?,
    val id: String?,
    val images: List<Image>,
    val type: String?,
    val uri: String?
)