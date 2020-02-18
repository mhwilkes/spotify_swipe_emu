package emu.dev.spotify_swipe.api.data

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
    val tracks: Page<Track>,
    val type: String,
    val uri: String
) {
    override fun toString(): String {
        return "Album(album_type=$album_type, artists=${artists.toString()}, available_markets=${available_markets.toString()}, copyrights=${copyrights.toString()}, external_ids=${external_ids.toString()}, external_urls=${external_urls.toString()}, genres=${genres.toString()}, href=$href, id=$id, images=${images.toString()}, label=$label, name=$name, popularity=$popularity, release_date=$release_date, release_date_precision=$release_date_precision, tracks=${tracks.toString()}, type=$type, uri=$uri)"
    }
}