package emu.dev.spotify_swipe.api

import java.sql.Timestamp

abstract class SavedTrack(
    val added_at: Timestamp?,
    val track: Track?
)