package emu.dev.spotify_swipe.api.endpoints

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import emu.dev.spotify_swipe.api.data.Track
import emu.dev.spotify_swipe.api.data.Album
import emu.dev.spotify_swipe.api.data.AlbumSimple
import emu.dev.spotify_swipe.api.data.TrackSimple
import emu.dev.spotify_swipe.api.data.Page
import emu.dev.spotify_swipe.api.spotify.SpotifyRequest
import io.ktor.client.HttpClient
import io.ktor.client.request.accept
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.http.ContentType

class AlbumAPI(val spotifyRequest: SpotifyRequest) {

    internal val DEFAULT_ENDPOINT = "https://api.spotify.com/v1/albums/"

    //TODO implement functionality and return types

    suspend fun requestAlbum(
        id: String,
        market: String? = null
    ): Album? {
        val response =
            spotifyRequest.client.get<String>(
                DEFAULT_ENDPOINT
                    .plus(id)
                    .plus(if (market != null) "&market=$market" else "&market=from_token")
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
                DEFAULT_ENDPOINT
                    .plus(id)
                    .plus("/tracks")
            ) {
                accept(ContentType.Application.Json)
                header("Authorization", "Bearer ${spotifyRequest.token.access_token}")
            }
        return Gson().fromJson(response, typeToken)
    }

    // TODO Issue currently 401

    suspend fun requestAlbums(
        vararg ids: String,
        market: String? = null
    ): List<AlbumSimple>? {
        val typeToken = object : TypeToken<List<AlbumSimple>>() {}.type
        val response =
            spotifyRequest.client.get<String>(
                DEFAULT_ENDPOINT
                    .plus("?ids=")
                    .plus(ids.joinToString(limit = 20))
                    .plus(if (market != null) "&market=$market" else "&market=from_token")
            )

        return Gson().fromJson(response, typeToken)
    }
}