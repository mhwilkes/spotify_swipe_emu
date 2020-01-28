package emu.dev.spotify_swipe.api

abstract class Album(
    val album_type: String?,
    val artists: Artist?,
    val available_markets: Array<String>?,
    val copyrights: Array<Copyright>?,
    val external_ids: Array<ExternalID>?,
    val external_urls: Array<ExternalURL>?,
    val genres: Array<String>?,
    val href: String?,
    val id: String?,
    val images: Array<Image>?,
    val label: String?,
    val name: String?,
    val popularity: Int?,
    val release_date: String?,
    val release_date_precision: String?,
    val tracks: Array<Page<Track>>?,
    val type: String?,
    val uri: String?
)