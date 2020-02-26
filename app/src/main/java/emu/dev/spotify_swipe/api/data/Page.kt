package emu.dev.spotify_swipe.api.data

data class PageCursor<T>(
    val href: String?,
    val items: List<T>?,
    val limit: Int?,
    val next: String?,
    val cursors: Cursor?,
    val total: Int?
)

data class Page<T>(
    val href: String?,
    val items: List<T>?,
    val limit: Int?,
    val next: String?,
    val offset: Int?,
    val previous: String?,
    val total: Int?
)