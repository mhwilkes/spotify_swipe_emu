package emu.dev.spotify_swipe

import emu.dev.spotify_swipe.api.data.Album
import emu.dev.spotify_swipe.api.data.Artist
import emu.dev.spotify_swipe.api.data.ArtistSimple
import emu.dev.spotify_swipe.api.endpoints.AlbumAPI
import emu.dev.spotify_swipe.api.spotify.SpotifyAPI
import emu.dev.spotify_swipe.api.spotify.SpotifyRequest
import io.ktor.client.HttpClient
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import org.junit.Test

import org.junit.Assert.*

class AlbumUnitTest {

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

    @Test
    suspend fun requestAlbum_Functional() {
        assertEquals(
            (),
            AlbumAPI(
            SpotifyRequest(
                client,
                API.clientCredentialsRequest()
            )
        ).requestAlbum("6JWc4iAiJ9FjyK0B59ABb4"))
    }

}