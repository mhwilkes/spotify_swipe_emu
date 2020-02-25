package emu.dev.spotify_swipe

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import emu.dev.spotify_swipe.api.endpoints.AlbumAPI
import emu.dev.spotify_swipe.api.spotify.Token
import emu.dev.spotify_swipe.api.spotify.SpotifyRequest
import io.ktor.client.HttpClient
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import emu.dev.spotify_swipe.api.spotify.SpotifyAPI

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

        GlobalScope.launch {
            println(
                AlbumAPI(
                    SpotifyRequest(
                        client,
                        API.clientCredentialsRequest()
                    )
                ).requestAlbums("6akEvsycLGftJxYudPjmqK", "6akEvsycLGftJxYudPjmqK", "6akEvsycLGftJxYudPjmqK").toString()
            )
        }
    }
}
