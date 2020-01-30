package emu.dev.spotify_swipe.api.data

import java.io.Serializable

data class Category(
    val href: String?,
    val icons: Array<Image>?,
    val id: String?,
    val name: String?
) : Serializable