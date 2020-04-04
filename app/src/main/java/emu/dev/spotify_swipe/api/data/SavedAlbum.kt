package emu.dev.spotify_swipe.api.data

import emu.dev.spotify_swipe.utils.Timestamp

data class SavedAlbum(
    val added_at: Timestamp?,
    val album: Album?
)