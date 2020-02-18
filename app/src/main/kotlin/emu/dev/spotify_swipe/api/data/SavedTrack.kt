package emu.dev.spotify_swipe.api.data

import java.sql.Timestamp

data class SavedTrack(
    val added_at: Timestamp?,
    val track: Track?
)