package emu.dev.spotify_swipe

import emu.dev.spotify_swipe.api.endpoints.FollowAPI
import emu.dev.spotify_swipe.api.spotify.SpotifyAPI
import emu.dev.spotify_swipe.api.spotify.SpotifyRequest
import io.ktor.client.HttpClient
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class FollowUnitTest
{
    private val client = HttpClient {
        install(JsonFeature) {
            serializer = GsonSerializer {
                serializeNulls()
                disableHtmlEscaping()
                setPrettyPrinting()
            }
        }
    }

    // not sure how to implement these type of user checks

    private val API = SpotifyAPI(client)
    @Test
    fun testRequestCategoryList() = runBlocking<Unit>
    {
        val actual = ""
    }

}