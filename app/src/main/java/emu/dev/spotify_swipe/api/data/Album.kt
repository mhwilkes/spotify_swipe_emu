package emu.dev.spotify_swipe.api.data

data class Albums(
    val albums: List<Album>
) {
    internal fun asList(): List<Album> {
        return albums
    }
}

enum class IncludeGroups(val uri: String){
    ALBUM("album"),
    SINGLE("single"),
    APPEARS_ON("appears_on"),
    COMPILATION("compilation")
}

data class AlbumSimple(
    @Transient
    val album_group: String,
    val album_type: String,
    val artists: List<ArtistSimple>,
    val available_markets: List<String>,
    val external_urls: Map<String, String> = mapOf(),
    val href: String,
    val id: String,
    val images: List<Image>,
    val name: String,
    val release_date: String,
    val release_date_precision: String,
    val restrictions: Restriction,
    val type: String,
    val uri: String
)

data class Album(
    val album_type: String,
    val artists: List<ArtistSimple>,
    val available_markets: List<String> = listOf(),
    val copyrights: List<Copyright>,
    val external_ids: Map<String, String> = hashMapOf(),
    val external_urls: Map<String, String> = mapOf(),
    val genres: List<String>,
    val href: String,
    val id: String,
    val images: List<Image>,
    val label: String,
    val name: String,
    val popularity: Int,
    val release_date: String,
    val release_date_precision: String,
    val tracks: Page<TrackSimple>,
    val type: String,
    val uri: String
)
