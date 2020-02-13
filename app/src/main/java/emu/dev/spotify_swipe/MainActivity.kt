package emu.dev.spotify_swipe

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import emu.dev.spotify_swipe.api.endpoints.AlbumRequest
import emu.dev.spotify_swipe.api.spotify.AuthToken
import emu.dev.spotify_swipe.api.spotify.Request
import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val client = HttpClient{
            install(JsonFeature) {
                serializer = KotlinxSerializer()
            }

        }

        GlobalScope.launch {
            println(
                AlbumRequest(
                    Request(
                        client,
                        AuthToken("BQACA-QSQavVO9RUztwVAMkGoFoA0WSbwUA1xv96X_2_OlrobO5xax9WElI3oE2My6DtfzG57IAOZfenOB1lbCrzKimnDHmusISBdu-GArpt5CxukpK2Ml7zouhzueKtYe1lWPXliWER4ZHRM5dU2zyGbBnAdobGIDLmewg-vioktrvkQS-83CbHsyNc5Egn2hHEhJbDur12Wa5qZdTvW8CvNmvYr93VX9yzoUUsRe3w0jKZsVZ1sfHg1EyOoa2-bCTFnPyFjBXcG5GqTOnmP4pSAx0MQCX--Q")
                    )
                ).requestAlbum("0sNOF9WDwhWunNAHPD3Baj").toString()
            )
        }
    }
}
