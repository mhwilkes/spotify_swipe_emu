package emu.dev.spotify_swipe

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import emu.dev.spotify_swipe.api.endpoints.AlbumAPI
import emu.dev.spotify_swipe.api.spotify.SpotifyAuthToken
import emu.dev.spotify_swipe.api.spotify.SpotifyRequest
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
                serializer = GsonSerializer{
                    serializeNulls()
                    disableHtmlEscaping()
                    setPrettyPrinting()
                }
            }

        }

        GlobalScope.launch {
            println(
                AlbumAPI(
                    SpotifyRequest(
                        client,
                        SpotifyAuthToken("BQA8rJtSdG-Z-MfEj-zxXO7fEn7MQy6bd3VxoE3rsEUJUM7c_H8FWqm4lsTN5mNKWlbL_JZdQp91V9YuHEZ425CPJI9GccmlO7rqFe7FGEzImA7ncX_Ag6Ojr5amF74MB3VmaR2gMnPUJJ6e_ocutKm6v16l-DGbsqLjSZmRJ6Xm6FpBPfxkLcbEGYfz0-oiJ4HhnbKs0o8y9lw-hI17YpX8p6xQrRIPU-NGILd2A02zV7lWgsc0bb_lZpGMGf1fJ2TRHwZOJXhZhoBZs_xX0FUjPwdE9WOaiQ")
                    )
                ).requestAlbum("0sNOF9WDwhWunNAHPD3Baj").toString()
            )
        }
    }
}
