package emu.dev.spotify_swipe.api

import java.util.*

abstract class AlbumSimple(
    val album_group: Optional<String>?,
    val album_type: String?,
    val artists: Array<ArtistSimple>?,
    val available_markets: Array<String>?,
    val external_urls: Array<ExternalURL>?,
    val href: String?,
    val id: String?,
    val images: Array<Image>?,
    val name: String?,
    val release_date: String?,
    val release_date_precision: String?,
    val restrictions: Restriction?,
    val type: String?,
    val uri: String?
)