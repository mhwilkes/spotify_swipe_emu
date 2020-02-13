package emu.dev.spotify_swipe.api.data

data class RecommendationSeed(
    val afterFilteringSize: Int?,
    val afterRelinkingSize: Int?,
    val href: String?,
    val id: String?,
    val initialPoolSize: Int?,
    val type: String?
)