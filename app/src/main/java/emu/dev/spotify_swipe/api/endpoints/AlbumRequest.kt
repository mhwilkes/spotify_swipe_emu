package emu.dev.spotify_swipe.api.endpoints

import com.google.gson.Gson
import emu.dev.spotify_swipe.api.data.Album
import emu.dev.spotify_swipe.api.data.AlbumSimple
import emu.dev.spotify_swipe.api.data.TrackSimple
import emu.dev.spotify_swipe.api.spotify.AuthToken
import emu.dev.spotify_swipe.api.spotify.Request
import io.ktor.client.HttpClient
import io.ktor.client.request.accept
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.http.ContentType

class AlbumRequest(val request: Request) {

    //TODO implement functionality and return types


    suspend fun requestAlbum(
        id: String,
        market: String? = null
    ): Album? {
        val response = request.client.get<String>("https://api.spotify.com/v1/albums/${id}") {
            accept(ContentType.Application.Json)
            header("Authorization", "Bearer ${request.authToken.token}")
        }
        println(response)
        return Gson().fromJson(response, Album::class.java)
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