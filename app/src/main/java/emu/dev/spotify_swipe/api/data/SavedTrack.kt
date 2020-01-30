package emu.dev.spotify_swipe.api.data

import java.io.Serializable
import java.sql.Timestamp

data class SavedTrack(
    val added_at: Timestamp?,
    val track: Track?
) : Serializable