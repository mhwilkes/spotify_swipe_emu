package emu.dev.spotify_swipe.api

abstract class Recommendation(
    val seeds: Array<RecommendationSeed>?,
    val tracks: Array<TrackSimple>?
)