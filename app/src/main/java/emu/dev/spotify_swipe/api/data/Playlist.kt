package emu.dev.spotify_swipe.api.data

import java.io.Serializable

data class Playlist(
    val collaborative: Boolean?,
    val description: String?,
    val external_urls: ExternalURL?,
    val follower: Follower?,
    val href: String?,
    val id: String?,
    val images: Array<Image>?,
    val name: String?,
    val owner: UserPublic?,
    val public: Boolean?,
    val snapshot_id: String?,
    val tracks: Array<Page<PlaylistTrack>>?,
    val type: String?,
    val uri: String
) : Serializable