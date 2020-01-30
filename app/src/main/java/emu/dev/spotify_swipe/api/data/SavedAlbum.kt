package emu.dev.spotify_swipe.api.data

import emu.dev.spotify_swipe.api.data.Album
import java.io.Serializable
import java.sql.Timestamp

data class SavedAlbum(
    val added_at: Timestamp?,
    val album: Album?
) : Serializable