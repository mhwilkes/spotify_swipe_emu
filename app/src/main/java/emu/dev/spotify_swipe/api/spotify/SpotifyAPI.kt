package emu.dev.spotify_swipe.api.spotify

import android.content.Context
import android.content.Intent
import com.google.gson.Gson
import emu.dev.spotify_swipe.utils.base64encoded
import io.ktor.client.HttpClient
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders

data class SpotifyRequest(val client: HttpClient, val token: Token) {
    val DEFAULT_ENDPOINT: String = "https://www.spotify.com/v1"
}

data class Token(
    val access_token: String,
    val token_type: String,
    val expires_in: Int,
    val scope: String
)

enum class LoginMethod(val uri: String) {
    LOGIN_ACTIVITY("login-activity"),
    WEB_LOGIN("web-login"),
}

class SpotifyAPI(val client: HttpClient) {
    private val AUTH_ENDPOINT: String = "https://accounts.spotify.com/authorize"
    private val TOKEN_ENDPOINT: String = "https://accounts.spotify.com/api/token"
    private val CLIENT_ID: String = "3a36e58be96b4c4ab8829fb5702d05a5"
    private val CLIENT_SECRET: String = "9b7780574cb1414596bf3a241d15ace0"
    private val REDIRECT_URI: String = "https://www.accounts.spotify.com/callback"

    // TODO need login activity and callback system

    // https://developer.spotify.com/documentation/android/guides/android-authentication/
    // https://developer.spotify.com/documentation/android/quick-start/#register-application-fingerprints

    fun buildAuthCodeURL(
        client_id: String = CLIENT_ID,
        response_type: String = "code",
        redirect_uri: String = REDIRECT_URI,
        state: String? = null,
        vararg scopes: String?,
        show_dialog: Boolean? = true
    ): String {
        return AUTH_ENDPOINT
            .plus("?client_id=${client_id}")
            .plus("&response_type=${response_type}")
            .plus("&redirect_uri=${redirect_uri}")
            .plus(if (state != null) "&state=${state}" else "")
            .plus("&scope=${scopes.joinToString("%20")}")
            .plus(if (show_dialog != null && show_dialog) "&show_dialog=${show_dialog}" else "")
    }

    // 500 error when running
    fun authorizationCodeRequest(
        context: Context,
        request_url: String,
        method: LoginMethod
    ) {

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