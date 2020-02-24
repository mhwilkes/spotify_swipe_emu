package emu.dev.spotify_swipe.api.spotify

import com.google.gson.Gson
import io.ktor.http.content.TextContent
import io.ktor.client.HttpClient
import io.ktor.client.request.accept
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.header
import io.ktor.http.*
import emu.dev.spotify_swipe.api.spotify.SpotifyScope

data class SpotifyRequest(val client: HttpClient, val token: Token)
data class Token(val access_token: String, val token_type: String, val expires_in : Int, val scope : String)

class SpotifyAPI(val client: HttpClient) {
    internal val AUTH_ENDPOINT: String = "https://accounts.spotify.com/authorize"
    internal val TOKEN_ENDPOINT: String = "https://accounts.spotify.com/api/token"
    internal val CLIENT_ID: String = "3a36e58be96b4c4ab8829fb5702d05a5"
    internal val CLIENT_SECRET: String = "9b7780574cb1414596bf3a241d15ace0"
    internal val REDIRECT_URI: String = "https://www.accounts.spotify.com/callback"

    suspend fun authorizationCodeRequest(
        client_id: String = CLIENT_ID,
        response_type: String = "code",
        redirect_uri: String = REDIRECT_URI,
        state: String? = null,
        vararg scopes: String?,
        show_dialog: Boolean? = true
    ) {
        val response = client.get<String>(
            AUTH_ENDPOINT
                .plus("?client_id=${client_id}")
                .plus("&response_type=${response_type}")
                .plus("&redirect_uri=${redirect_uri}")
                .plus(if (state != null) "&state=${state}" else "")
                .plus(if (scopes != null) "&scope=${scopes.joinToString("%20")}" else "")
                .plus(if (show_dialog != null && show_dialog) "&show_dialog=${show_dialog}{it.uri}" else "")
        ) {
            accept(ContentType.Application.Json)
        }
    }


    suspend fun implicitGrantRequest(
        client_id: String = CLIENT_ID,
        response_type: String = "token",
        redirect_uri: String,
        state: String?,
        scope: String?,
        show_dialog: Boolean?
    ) {

    }

    suspend fun clientCredentialsRequest(
        client_id: String = CLIENT_ID,
        client_secret: String = CLIENT_SECRET,
        grant_type: String = "client_credentials"
    ) : Token {
        val clientCredentials = java.util.Base64.getEncoder().encodeToString((client_id + ":" + client_secret).toByteArray())
        val request = client.post<String>(
            TOKEN_ENDPOINT
        ) {
            header(HttpHeaders.ContentType, ContentType.Application.FormUrlEncoded.toString())
            header("Authorization", "Basic ${clientCredentials}")
            body = "grant_type=client_credentials"
        }

        return Gson().fromJson(request, Token::class.java)
    }
}