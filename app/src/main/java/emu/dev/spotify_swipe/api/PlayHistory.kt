package emu.dev.spotify_swipe.api

import java.sql.Timestamp

abstract class PlayHistory (
    val trick: TrackSimple?,
    val played_at: Timestamp?,
    val context: Context?
)