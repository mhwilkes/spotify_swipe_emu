package emu.dev.spotify_swipe.api.spotify

import io.ktor.client.HttpClient
import io.ktor.client.request.accept
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.http.ContentType

data class SpotifyRequest(val client: HttpClient, val spotifyAuthToken: SpotifyAuthToken)
data class SpotifyAuthToken(val token: String)

class SpotifyAPI(val client: HttpClient) {
    internal val AUTH_ENDPOINT: String = "https://accounts.spotify.com/authorize"
    internal val CLIENT_ID: String = "3a36e58be96b4c4ab8829fb5702d05a5"

    suspend fun authorizationCodeRequest(
        client_id: String = CLIENT_ID,
        response_type: String = "code",
        redirect_uri: String,
        state: String?,
        scope: String?,
        show_dialog: Boolean?
    ) {
        val response = client.get<String>(
            AUTH_ENDPOINT
                .plus("?client_id=${client_id}")
                .plus("&response_type=${response_type}")
                .plus("&redirect_uri=${redirect_uri}")
                .plus(if (state != null) "&state=${state}" else "")
                .plus(if (scope != null) "&scope=${scope}" else "")
                .plus(if (show_dialog != null && show_dialog) "&show_dialog=${show_dialog}" else "")
        ) {
            accept(ContentType.Application.Json)
        }
    }


    fun implicitGrantRequest(
        client_id: String = CLIENT_ID,
        response_type: String = "token",
        redirect_uri: String,
        state: String?,
        scope: String?,
        show_dialog: Boolean?
    ) {

    }

    fun clientCredentialsRequest(
        client_id: String = CLIENT_ID,
        client_secret: String,
        grant_type: String = "client_credentials"
    ) {

    }
}