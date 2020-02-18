package emu.dev.spotify_swipe.api.data

import java.sql.Timestamp

data class SavedAlbum(
    val added_at: Timestamp?,
    val album: Album?
)