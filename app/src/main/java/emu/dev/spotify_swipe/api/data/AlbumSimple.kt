package emu.dev.spotify_swipe.api.data

import java.io.Serializable
import java.util.*

data class AlbumSimple(
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
) : Serializable {
    override fun toString(): String {
        return "AlbumSimple(album_group=$album_group, album_type=$album_type, artists=${artists?.contentToString()}, available_markets=${available_markets?.contentToString()}, external_urls=${external_urls?.contentToString()}, href=$href, id=$id, images=${images?.contentToString()}, name=$name, release_date=$release_date, release_date_precision=$release_date_precision, restrictions=$restrictions, type=$type, uri=$uri)"
    }
}