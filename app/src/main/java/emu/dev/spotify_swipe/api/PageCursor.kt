package emu.dev.spotify_swipe.api

abstract class PageCursor<T>(
    val href: String?,
    val items: Array<T>?,
    val limit: Int?,
    val next: String?,
    val cursors: Cursor?,
    val total: Int?
)