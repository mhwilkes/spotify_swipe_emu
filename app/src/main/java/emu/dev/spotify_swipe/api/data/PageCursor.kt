package emu.dev.spotify_swipe.api.data

import java.io.Serializable

data class PageCursor<T>(
    val href: String?,
    val items: Array<T>?,
    val limit: Int?,
    val next: String?,
    val cursors: Cursor?,
    val total: Int?
) : Serializable