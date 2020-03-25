package emu.dev.spotify_swipe

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.spotify.sdk.android.auth.AuthorizationClient
import com.spotify.sdk.android.auth.AuthorizationRequest
import com.spotify.sdk.android.auth.AuthorizationRequest.Builder
import com.spotify.sdk.android.auth.AuthorizationResponse
import com.spotify.sdk.android.auth.LoginActivity.REQUEST_CODE
import emu.dev.spotify_swipe.api.endpoints.AlbumAPI
import emu.dev.spotify_swipe.api.spotify.SpotifyAPI
import emu.dev.spotify_swipe.api.spotify.SpotifyRequest
import emu.dev.spotify_swipe.api.spotify.SpotifyScope
import io.ktor.client.HttpClient
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val client = HttpClient {
            install(JsonFeature) {
                serializer = GsonSerializer {
                    serializeNulls()
                    disableHtmlEscaping()
                    setPrettyPrinting()
                }
            }
        }

        val API = SpotifyAPI(client)
        val button = findViewById<Button>(R.id.login)

        button.setOnClickListener(this::onLoginClick)

        GlobalScope.launch {
            println(
                AlbumAPI(
                    SpotifyRequest(
                        client,
                        API.clientCredentialsRequest()
                    )
                ).requestAlbum("4aawyAB9vmqN3uQ7FjRGTy")
            )
        }
        println(intent.getStringExtra("response"))
    }

    private fun onLoginClick(view: View) {
        val REQUEST_CODE = 1138
        val REDIRECT_URI = "spotify-swipe-app-212985://callback"

        val builder = Builder(
            "3a36e58be96b4c4ab8829fb5702d05a5",
            AuthorizationResponse.Type.CODE,
            REDIRECT_URI
        )
        builder.setScopes(arrayOf(SpotifyScope.APP_REMOTE_CONTROL.uri))
        builder.setShowDialog(true)
        val request: AuthorizationRequest = builder.build()
        AuthorizationClient.clearCookies(this)
        AuthorizationClient.openLoginActivity(this, REQUEST_CODE, request)
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        intent: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, intent)

        // Check if result comes from the correct activity
        if (requestCode == REQUEST_CODE) {
            val response: AuthorizationResponse =
                AuthorizationClient.getResponse(resultCode, intent)

            when (response.type) {
                AuthorizationResponse.Type.TOKEN -> {
                    println(response.accessToken)
                }
                AuthorizationResponse.Type.CODE -> {
                    println(response.code)
                }
                AuthorizationResponse.Type.ERROR -> {
                    println(response.error)
                }
                AuthorizationResponse.Type.UNKNOWN -> {
                    println("Busted")
                }
                AuthorizationResponse.Type.EMPTY -> {
                    println("Empty")
                }
                else -> {
                    println("Busted")
                }
            }
        }
    }

}
