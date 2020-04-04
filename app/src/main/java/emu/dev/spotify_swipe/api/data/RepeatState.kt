package emu.dev.spotify_swipe.api.data

enum class RepeatState(val uri: String){
    TRACK("track"),
    CONTEXT("context"),
    OFF("off")
}