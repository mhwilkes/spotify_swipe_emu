package emu.dev.spotify_swipe.api.data

enum class Disallow(val uri: String) {
    INTERRUPTING_PLAYBACK("interrupting-playback"),
    PAUSING("pausing"),
    RESUMING("resuming"),
    SEEKING("seeking"),
    SKIPPING_NEXT("skipping-next"),
    SKIPPING_PREV("skipping-prev"),
    TOGGLING_REPEAT_CONTEXT("toggling-repeat-context"),
    TOGGLING_SHUFFLE("toggling-shuffle"),
    TOGGLING_REPEAT_TRACK("toggling-repeat-track"),
    TRANSFERRING_PLAYBACK("transferring-playback")
}