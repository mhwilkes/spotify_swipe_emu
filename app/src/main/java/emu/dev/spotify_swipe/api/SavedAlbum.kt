package emu.dev.spotify_swipe.api

import java.sql.Timestamp

abstract class SavedAlbum(
    val added_at: Timestamp?,
    val album: Album?
)