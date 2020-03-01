package emu.dev.spotify_swipe

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.spotify.sdk.android.auth.AuthorizationClient
import com.spotify.sdk.android.auth.AuthorizationRequest
import com.spotify.sdk.android.auth.AuthorizationRequest.Builder
import com.spotify.sdk.android.auth.AuthorizationResponse
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
                ).requestAlbums("6JWc4iAiJ9FjyK0B59ABb4")
            )
        }
    }

    private fun onLoginClick(view: View) {
        val REQUEST_CODE = 1483
        val REDIRECT_URI = "spotify-swipe://auth"

        val builder = Builder(
            "3a36e58be96b4c4ab8829fb5702d05a5",
            AuthorizationResponse.Type.TOKEN,
            REDIRECT_URI
        )

        builder.setScopes(arrayOf(SpotifyScope.STREAMING.uri))
        val request: AuthorizationRequest = builder.build()

        AuthorizationClient.openLoginActivity(this, REQUEST_CODE, request)
    }
}
