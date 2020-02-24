package emu.dev.spotify_swipe.api.endpoints

import com.google.gson.Gson
import emu.dev.spotify_swipe.api.data.Album
import emu.dev.spotify_swipe.api.data.AlbumSimple
import emu.dev.spotify_swipe.api.data.TrackSimple
import emu.dev.spotify_swipe.api.spotify.Token
import emu.dev.spotify_swipe.api.spotify.SpotifyRequest
import io.ktor.client.HttpClient
import io.ktor.client.request.accept
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.http.ContentType

class AlbumAPI(val spotifyRequest: SpotifyRequest) {

    //TODO implement functionality and return types

    suspend fun requestAlbum(
        id: String,
        market: String? = null
    ): Album? {
        val response =
            spotifyRequest.client.get<String>("https://api.spotify.com/v1/albums/${id}") {
                accept(ContentType.Application.Json)
                header("Authorization", "Bearer ${spotifyRequest.token.access_token}")
            }
        println(response)
        return Gson().fromJson(response, Album::class.java)
    }

    fun requestAlbumTracks(
        id: String,
        limit: Int = 20,
        offset: Int = 0,
        market: String? = null
    ): List<TrackSimple>? {
        return listOf()
    }

    fun requestAlbums(
        ids: Array<String>,
        market: String? = null
    ): List<AlbumSimple>? {
        return listOf()
    }
}