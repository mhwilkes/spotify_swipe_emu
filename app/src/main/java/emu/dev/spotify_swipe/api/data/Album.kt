package emu.dev.spotify_swipe.api.data

import java.io.Serializable

data class Album(
    val album_type: String?,
    val artists: Array<ArtistSimple>?,
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
) : Serializable {
    override fun toString(): String {
        return "Album(album_type=$album_type, artists=${artists?.contentToString()}, available_markets=${available_markets?.contentToString()}, copyrights=${copyrights?.contentToString()}, external_ids=${external_ids?.contentToString()}, external_urls=${external_urls?.contentToString()}, genres=${genres?.contentToString()}, href=$href, id=$id, images=${images?.contentToString()}, label=$label, name=$name, popularity=$popularity, release_date=$release_date, release_date_precision=$release_date_precision, tracks=${tracks?.contentToString()}, type=$type, uri=$uri)"
    }
}