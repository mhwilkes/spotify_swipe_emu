package emu.dev.spotify_swipe.api.data

import emu.dev.spotify_swipe.utils.Timestamp

data class PlaylistTrack(
    val added_at: Timestamp?,
    val added_by: UserPublic?,
    val is_local: Boolean?,
    val track: Track?
)