package emu.dev.spotify_swipe.api.data

import java.sql.Timestamp

data class PlayHistory(
    val track: TrackSimple?,
    val played_at: Timestamp?,
    val context: Context?
)