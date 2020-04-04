package emu.dev.spotify_swipe.api.data

data class Artists(
    val artists: List<Artist>
) {
    internal fun asList(): List<Artist> {
        return artists
    }
}

data class ArtistSimple(
    val external_urls: Map<String, String> = mapOf(),
    val href: String,
    val id: String,
    val name: String,
    val type: String,
    val uri: String
)

data class Artist(
    val external_urls: Map<String, String> = mapOf(),
    val followers: Follower,
    val genres: List<String>,
    val href: String,
    val id: String,
    val images: List<Image>,
    val name: String,
    val popularity: Int,
    val type: String,
    val uri: String
)