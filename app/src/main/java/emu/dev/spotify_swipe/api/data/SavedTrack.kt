package emu.dev.spotify_swipe.api.data

import emu.dev.spotify_swipe.utils.Timestamp

data class SavedTrack(
    val added_at: Timestamp?,
    val track: Track?
)