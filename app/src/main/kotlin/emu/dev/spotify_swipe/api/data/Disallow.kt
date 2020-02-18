package emu.dev.spotify_swipe.api.data

enum class Disallow {
    interrupting_playback,
    pausing,
    resuming,
    seeking,
    skipping_next,
    skipping_prev,
    toggling_repeat_context,
    toggling_shuffle,
    toggling_repeat_track,
    transferring_playback
}