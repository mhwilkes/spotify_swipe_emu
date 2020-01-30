package emu.dev.spotify_swipe.api.data

import java.io.Serializable

data class Recommendation(
    val seeds: Array<RecommendationSeed>?,
    val tracks: Array<TrackSimple>?
) : Serializable