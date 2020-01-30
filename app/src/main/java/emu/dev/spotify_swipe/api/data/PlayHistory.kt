package emu.dev.spotify_swipe.api.data

import java.io.Serializable
import java.sql.Timestamp

data class PlayHistory(
    val trick: TrackSimple?,
    val played_at: Timestamp?,
    val context: Context?
) : Serializable