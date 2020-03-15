package emu.dev.spotify_swipe.api.endpoints

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import emu.dev.spotify_swipe.api.data.UserPrivate
import emu.dev.spotify_swipe.api.data.UserPublic
import emu.dev.spotify_swipe.api.spotify.SpotifyRequest
import io.ktor.client.request.accept
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.http.ContentType

class UserAPI(private val spotifyRequest: SpotifyRequest) {

    // @GET
    // Scope implement: USER_READ_EMAIL("user-read-email")
    // When scope is provided, User object returns email with account
    // Scope required: USER_READ_PRIVATE("user-read-private")
    suspend fun getCurrentProfile(): UserPrivate {
        val typeToken = object : TypeToken<UserPrivate>() {}.type
        val response = spotifyRequest.client.get<String>(
            spotifyRequest.DEFAULT_ENDPOINT
                .plus("/me")
        ) {
            accept(ContentType.Application.Json)
            header("Authorization", "Bearer ${spotifyRequest.token.access_token}")
        }
        return Gson().fromJson(response, typeToken)
    }

    // @GET
    suspend fun getProfile(
        user_id: String
    ): UserPublic {
        val typeToken = object : TypeToken<UserPublic>() {}.type
        val response = spotifyRequest.client.get<String>(
            spotifyRequest.DEFAULT_ENDPOINT
                .plus("/users/$user_id")
        ) {
            accept(ContentType.Application.Json)
            header("Authorization", "Bearer ${spotifyRequest.token.access_token}")
        }
        return Gson().fromJson(response, typeToken)
    }
}