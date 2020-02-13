package emu.dev.spotify_swipe.api.data

data class UserPrivate(
    val country: String?,
    val display_name: String?,
    val email: String?,
    val external_urls: Map<String, String> = mapOf(),
    val followers: Follower?,
    val href: String?,
    val id: String?,
    val images: List<Image>?,
    val product: String?,
    val type: String?,
    val uri: String?
)