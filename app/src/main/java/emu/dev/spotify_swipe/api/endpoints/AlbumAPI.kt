package emu.dev.spotify_swipe.api.endpoints

import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import emu.dev.spotify_swipe.api.data.Album
import emu.dev.spotify_swipe.api.data.Albums
import emu.dev.spotify_swipe.api.data.Page
import emu.dev.spotify_swipe.api.data.TrackSimple
import emu.dev.spotify_swipe.api.spotify.SpotifyRequest
import io.ktor.client.request.accept
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.http.ContentType

class AlbumAPI(val spotifyRequest: SpotifyRequest) {

    private val ALBUM_ENDPOINT = "https://api.spotify.com/v1/albums/"

    //TODO implement functionality and return types

    suspend fun requestAlbum(
        id: String,
        market: String? = null
    ): Album? {
        val response =
            spotifyRequest.client.get<String>(
                ALBUM_ENDPOINT
                    .plus(id)
                    .plus(if (market != null) "&market=$market" else "")
            ) {
                accept(ContentType.Application.Json)
                header("Authorization", "Bearer ${spotifyRequest.token.access_token}")
            }

        return Gson().fromJson(response, Album::class.java)
    }

    suspend fun requestAlbumTracks(
        id: String,
        limit: Int = 20,
        offset: Int = 0,
        market: String? = null
    ): Page<TrackSimple>? {
        val typeToken = object : TypeToken<Page<TrackSimple>>() {}.type
        val response =
            spotifyRequest.client.get<String>(
                ALBUM_ENDPOINT
                    .plus(id)
                    .plus("/tracks")
                    .plus()
            ) {
                accept(ContentType.Application.Json)
                header("Authorization", "Bearer ${spotifyRequest.token.access_token}")
            }

        return Gson().fromJson(response, typeToken)
    }

    // TODO fix this
    // Scuffed way of taking albums return array into object then returning inner list

    suspend fun requestAlbums(
        vararg ids: String,
        market: String? = null
    ): List<Album>? {
        val typeToken = object : TypeToken<List<Album>>() {}.type
        val response =
            spotifyRequest.client.get<String>(
                ALBUM_ENDPOINT
                    .plus("?ids=")
                    .plus(ids.joinToString(limit = 20, separator = "%2C"))
                    .plus(if (market != null) "&market=$market" else "")
            ) {
                accept(ContentType.Application.Json)
                header("Authorization", "Bearer ${spotifyRequest.token.access_token}")
            }

        return Gson().fromJson(response, Albums::class.java).asList()
    }
}