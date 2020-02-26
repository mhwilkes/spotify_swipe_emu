package emu.dev.spotify_swipe.api.data

data class Tracks(val tracks: List<Track>) {
    internal fun asList(): List<Track> {
        return tracks
    }
}

data class TrackSimple(
    val artists: List<ArtistSimple>?,
    val available_markets: List<String>?,
    val disc_number: Int?,
    val duration_ms: Int?,
    val explicit: Boolean?,
    val external_urls: Map<String, String> = mapOf(),
    val href: String?,
    val id: String?,
    val is_playable: Boolean?,
    val linked_from: TrackLink?,
    val restrictions: Restriction?,
    val name: String?,
    val preview_url: String?,
    val track_number: Int?,
    val type: String?,
    val uri: String?,
    val is_local: Boolean?
)

data class Track(
    val album: AlbumSimple?,
    val artists: List<ArtistSimple>?,
    val available_markets: List<String>?,
    val disc_number: Int?,
    val duration_ms: Int?,
    val explicit: Boolean?,
    val external_ids: Map<String, String> = hashMapOf(),
    val external_urls: Map<String, String> = mapOf(),
    val href: String?,
    val id: String?,
    val is_playable: Boolean?,
    val linked_from: TrackLink?,
    val restrictions: Restriction?,
    val name: String?,
    val popularity: Int?,
    val preview_url: String?,
    val track_number: Int?,
    val type: String?,
    val uri: String?,
    val is_local: Boolean?
)

data class TrackLink(
    val external_urls: Map<String, String> = mapOf(),
    val href: String?,
    val id: String?,
    val type: String?,
    val uri: String?
)