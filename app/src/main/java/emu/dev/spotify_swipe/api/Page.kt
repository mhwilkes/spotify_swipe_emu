package emu.dev.spotify_swipe.api

abstract class Page<T>(
    val href: String?,
    val items: Array<T>?,
    val limit: Int?,
    val next: String?,
    val offset: Int?,
    val previous: String?,
    val total: Int?
)