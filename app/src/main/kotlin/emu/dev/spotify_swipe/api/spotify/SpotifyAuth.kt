package emu.dev.spotify_swipe.api.spotify

import io.ktor.http.ContentType

class SpotifyAuth(
    val client_id: String,
    val response_type: ContentType,
    val redirect_uri: String,
    val state: String,
    val scope: List<String>
) {


    fun requestAuthCode(
        clientID: String,
        responseType: ContentType = ContentType.Application.Json,
        redirect_uri: String,
        state: String,
        scope: List<String>
    ): Pair<String, String> {
        // Display Scopes

        // Prompt User for Login if necessary

        // Login, get auth access

        return new SpotifyAuthToken (
        val accessToken: String, val refreshToken : String)
    }

    fun requestClientCredentials(

    ) {

    }

    fun requestImplicitGrant(

    ) {

    }
}