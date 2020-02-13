package emu.dev.spotify_swipe.api.data

data class Recommendation(
    val seeds: List<RecommendationSeed>?,
    val tracks: List<TrackSimple>?
)