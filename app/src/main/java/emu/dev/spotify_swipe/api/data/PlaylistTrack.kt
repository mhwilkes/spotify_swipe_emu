package emu.dev.spotify_swipe.api.data

import java.io.Serializable
import java.sql.Timestamp

data class PlaylistTrack(
    val added_at: Timestamp?,
    val added_by: UserPublic?,
    val is_local: Boolean?,
    val track: Track?
) : Serializable