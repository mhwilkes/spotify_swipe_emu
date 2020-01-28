package emu.dev.spotify_swipe.api

import java.sql.Timestamp

abstract class PlaylistTrack(
    val added_at: Timestamp?,
    val added_by: UserPublic?,
    val is_local: Boolean?,
    val track: Track?
)