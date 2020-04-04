package emu.dev.spotify_swipe.api.spotify

import com.google.gson.Gson
import emu.dev.spotify_swipe.utils.base64encoded
import io.ktor.client.HttpClient
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import java.io.Serializable

data class SpotifyRequest(val client: HttpClient, val token: Token) {
    val DEFAULT_ENDPOINT: String = "https://api.spotify.com/v1/"
}

data class Token(
    val access_token: String,
    val token_type: String,
    val expires_in: Int,
    var scope: String
) : Serializable

class SpotifyAPI(private val client: HttpClient) {
    private val REQUEST_CODE = 1483
    private val TOKEN_ENDPOINT: String = "https://accounts.spotify.com/api/token"
    private val CLIENT_ID: String = "3a36e58be96b4c4ab8829fb5702d05a5"
    private val CLIENT_SECRET: String = "9b7780574cb1414596bf3a241d15ace0"
    private val REDIRECT_URI = "spotify-swipe://auth"

    // Intermediary test for public grants
    suspend fun clientCredentialsRequest(
        client_id: String = CLIENT_ID,
        client_secret: String = CLIENT_SECRET,
        grant_type: String = "client_credentials"
    ): Token {
        val clientCredentials = ("$client_id:$client_secret").base64encoded
        val request = client.post<String>(
            TOKEN_ENDPOINT
        ) {
            header(HttpHeaders.ContentType, ContentType.Application.FormUrlEncoded.toString())
            header("Authorization", "Basic $clientCredentials")
            body = "grant_type=client_credentials"
        }
        return Gson().fromJson(request, Token::class.java)
    }
}