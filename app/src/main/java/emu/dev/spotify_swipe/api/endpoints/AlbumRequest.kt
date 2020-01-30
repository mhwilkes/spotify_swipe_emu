package emu.dev.spotify_swipe.api.endpoints

import emu.dev.spotify_swipe.api.data.Album
import emu.dev.spotify_swipe.api.data.AlbumSimple
import emu.dev.spotify_swipe.api.data.TrackSimple
import emu.dev.spotify_swipe.api.spotify.AuthToken
import emu.dev.spotify_swipe.api.spotify.Request
import io.ktor.client.HttpClient

class AlbumRequest : Request<AlbumRequest>() {

    //TODO implement functionality and return types

    fun requestAlbum(
        client: HttpClient,
        token: AuthToken,
        id: String,
        market: String? = null
    ): Album? {
        return null
    }

    fun requestAlbumTracks(
        client: HttpClient,
        token: AuthToken,
        id: String,
        limit: Int = 20,
        offset: Int = 0,
        market: String? = null
    ): Array<TrackSimple>? {
        return emptyArray()
    }

    fun requestAlbums(
        client: HttpClient,
        token: AuthToken,
        ids: Array<String>,
        market: String? = null
    ): Array<AlbumSimple>? {
        return emptyArray()
    }
}