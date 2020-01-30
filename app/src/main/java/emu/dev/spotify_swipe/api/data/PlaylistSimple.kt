package emu.dev.spotify_swipe.api.data

import java.io.Serializable

data class PlaylistSimple(
    val collaborative: Boolean?,
    val description: String?,
    val externalURL: ExternalURL?,
    val href: String?,
    val id: String?,
    val images: Array<Image>?,
    val name: String?,
    val owner: UserPublic?,
    val public: Boolean?,
    val snapshot_id: String?,
    val tracks: Collection<Track>?,
    val type: String?,
    val uri: String?
) : Serializable