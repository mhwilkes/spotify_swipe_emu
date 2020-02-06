package emu.dev.spotify_swipe

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import emu.dev.spotify_swipe.api.endpoints.AlbumRequest
import emu.dev.spotify_swipe.api.spotify.AuthToken
import emu.dev.spotify_swipe.api.spotify.Request
import io.ktor.client.HttpClient
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.logging.DEFAULT
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logger
import io.ktor.client.features.logging.Logging
import kotlinx.coroutines.MainScope
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
            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.HEADERS
            }
        }

        MainScope().launch {
            println(
                AlbumRequest(
                    Request(
                        client,
                        AuthToken("BQCJq3cES9EKybMf2PswK3eeMriZ9WCR30hud33F_kUBVNrTXbHaMT96hRzld7Ayg1QSYX3AIu0tGLz8HkAMGetgNWa-xI1oCoWYUOckqcjQZ_jq02PqDK59FIOq8wopicrUvQYR-7NGZB4LJF1XLQJghfpADMlF-pE")
                    )
                ).requestAlbum("4aawyAB9vmqN3uQ7FjRGTy").toString()
            )
        }
    }
}
