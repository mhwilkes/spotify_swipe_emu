package emu.dev.spotify_swipe.api.endpoints

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import emu.dev.spotify_swipe.api.data.*
import emu.dev.spotify_swipe.api.spotify.SpotifyRequest
import io.ktor.client.request.*
import io.ktor.http.ContentType

class LibraryAPI(private val spotifyRequest: SpotifyRequest) {

    val LIBRARY_ENDPOINT = spotifyRequest.DEFAULT_ENDPOINT
        .plus("me")


    // @GET
    // Requires scope: USER_LIBRARY_READ("user-library-read")
    suspend fun checkSavedAlbum(
        vararg ids: String
    ): Array<Boolean> {
        val typeToken = object : TypeToken<Array<Boolean>>() {}.type
        val response = spotifyRequest.client.get<String>(
            LIBRARY_ENDPOINT
                .plus("/albums/contains")
                .plus("?ids=${ids.joinToString(separator = "%2C")}")
        ) {
            accept(ContentType.Application.Json)
            header("Authorization", "Bearer ${spotifyRequest.token.access_token}")
        }
        return Gson().fromJson(response, typeToken)
    }

    // @GET
    // Requires scope: USER_LIBRARY_READ("user-library-read")
    suspend fun checkSavedTrack(
        vararg ids: String
    ): Array<Boolean> {
        val typeToken = object : TypeToken<Array<Boolean>>() {}.type
        val response = spotifyRequest.client.get<String>(
            LIBRARY_ENDPOINT
                .plus("/tracks/contains")
                .plus("?ids=${ids.joinToString(separator = "%2C")}")
        ) {
            accept(ContentType.Application.Json)
            header("Authorization", "Bearer ${spotifyRequest.token.access_token}")
        }
        return Gson().fromJson(response, typeToken)
    }

    // @GET
    // Requires scope: USER_LIBRARY_READ("user-library-read")
    suspend fun getSavedAlbum(
        limit: Int = 20,
        offset: Int = 0,
        market: String? = null
    ): Page<SavedAlbum> {
        val typeToken = object : TypeToken<Page<SavedAlbum>>() {}.type
        val response = spotifyRequest.client.get<String>(
            LIBRARY_ENDPOINT
                .plus("/albums")
                .plus("?limit=$limit")
                .plus("&offset=$offset")
                .plus(if (market != null) "&market=$market" else "")
        ) {
            accept(ContentType.Application.Json)
            header("Authorization", "Bearer ${spotifyRequest.token.access_token}")
        }
        return Gson().fromJson(response, typeToken)
    }

    // @GET
    // Requires scope: USER_LIBRARY_READ("user-library-read")
    suspend fun getSavedTrack(
        limit: Int = 20,
        offset: Int = 0,
        market: String? = null
    ): Page<SavedTrack> {
        val typeToken = object : TypeToken<Page<SavedTrack>>() {}.type
        val response = spotifyRequest.client.get<String>(
            LIBRARY_ENDPOINT
                .plus("/tracks")
                .plus("?limit=$limit")
                .plus("&offset=$offset")
                .plus(if (market != null) "&market=$market" else "")
        ) {
            accept(ContentType.Application.Json)
            header("Authorization", "Bearer ${spotifyRequest.token.access_token}")
        }
        return Gson().fromJson(response, typeToken)
    }

    // @DELETE
    // Requires scope: USER_LIBRARY_MODIFY("user-library-modify")
    suspend fun removeAlbumsForUser(
        vararg ids: String
    ) {
        val response = spotifyRequest.client.delete<String>(
            LIBRARY_ENDPOINT
                .plus("/albums")
                .plus("?ids=${ids.joinToString(separator = "%2C")}")
        ) {
            accept(ContentType.Application.Json)
            header("Authorization", "Bearer ${spotifyRequest.token.access_token}")
        }
    }

    // @DELETE
    // Requires scope: USER_LIBRARY_MODIFY("user-library-modify")
    suspend fun removeTrackForUser(
        vararg ids: String
    ) {
        val response = spotifyRequest.client.delete<String>(
            LIBRARY_ENDPOINT
                .plus("/tracks")
                .plus("?ids=${ids.joinToString(separator = "%2C")}")
        ) {
            accept(ContentType.Application.Json)
            header("Authorization", "Bearer ${spotifyRequest.token.access_token}")
        }
    }

    // @PUT
    // Requires scope: USER_LIBRARY_MODIFY("user-library-modify")
    suspend fun saveAlbumForUser(
        vararg ids: String
    ) {
        val response = spotifyRequest.client.put<String>(
            LIBRARY_ENDPOINT
                .plus("/albums")
                .plus("?ids=${ids.joinToString(separator = "%2C")}")
        ) {
            accept(ContentType.Application.Json)
            header("Authorization", "Bearer ${spotifyRequest.token.access_token}")
        }
    }

    // @PUT
    // Requires scope: USER_LIBRARY_MODIFY("user-library-modify")
    suspend fun saveTrackForUser(
        vararg ids: String
    ) {
        val response = spotifyRequest.client.put<String>(
            LIBRARY_ENDPOINT
                .plus("/tracks")
                .plus("?ids=${ids.joinToString(separator = "%2C")}")
        ) {
            accept(ContentType.Application.Json)
            header("Authorization", "Bearer ${spotifyRequest.token.access_token}")
        }
    }

}