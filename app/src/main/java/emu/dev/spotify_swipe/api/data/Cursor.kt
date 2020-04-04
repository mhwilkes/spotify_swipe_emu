package emu.dev.spotify_swipe.api.data

data class Cursor(
    val after: String
)

data class CursorPage<T>(
    val href: String,
    val items: Array<T>,
    val limit: Int,
    val next: String,
    val cursors: Cursor,
    val total: Int
)