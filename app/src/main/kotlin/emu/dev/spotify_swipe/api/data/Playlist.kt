package emu.dev.spotify_swipe.api.data

data class Playlist(
    val collaborative: Boolean?,
    val description: String?,
    val external_urls: Map<String, String> = mapOf(),
    val follower: Follower?,
    val href: String?,
    val id: String?,
    val images: List<Image>?,
    val name: String?,
    val owner: UserPublic?,
    val public: Boolean?,
    val snapshot_id: String?,
    val tracks: Page<PlaylistTrack>?,
    val type: String?,
    val uri: String
)