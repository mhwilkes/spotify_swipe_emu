package emu.dev.spotify_swipe

import emu.dev.spotify_swipe.api.endpoints.TrackAPI
import emu.dev.spotify_swipe.api.spotify.SpotifyAPI
import emu.dev.spotify_swipe.api.spotify.SpotifyRequest
import io.ktor.client.HttpClient
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*

class TrackUnitTest {
    private val client = HttpClient {
        install(JsonFeature) {
            serializer = GsonSerializer {
                serializeNulls()
                disableHtmlEscaping()
                setPrettyPrinting()
            }
        }
    }

    private val API = SpotifyAPI(client)


    @Test
    fun testRequestTrack() = runBlocking<Unit>
    {
        requestTrack_Functional()
    }

    private suspend fun requestTrack_Functional() {
        delay(10)

        val correctResponse = "{\n" +
                "  \"album\" : {\n" +
                "    \"album_type\" : \"single\",\n" +
                "    \"artists\" : [ {\n" +
                "      \"external_urls\" : {\n" +
                "        \"spotify\" : \"https://open.spotify.com/artist/6sFIWsNpZYqfjUpaCgueju\"\n" +
                "      },\n" +
                "      \"href\" : \"https://api.spotify.com/v1/artists/6sFIWsNpZYqfjUpaCgueju\",\n" +
                "      \"id\" : \"6sFIWsNpZYqfjUpaCgueju\",\n" +
                "      \"name\" : \"Carly Rae Jepsen\",\n" +
                "      \"type\" : \"artist\",\n" +
                "      \"uri\" : \"spotify:artist:6sFIWsNpZYqfjUpaCgueju\"\n" +
                "    } ],\n" +
                "    \"available_markets\" : [ ],\n" +
                "    \"external_urls\" : {\n" +
                "      \"spotify\" : \"https://open.spotify.com/album/0tGPJ0bkWOUmH7MEOR77qc\"\n" +
                "    },\n" +
                "    \"href\" : \"https://api.spotify.com/v1/albums/0tGPJ0bkWOUmH7MEOR77qc\",\n" +
                "    \"id\" : \"0tGPJ0bkWOUmH7MEOR77qc\",\n" +
                "    \"images\" : [ {\n" +
                "      \"height\" : 640,\n" +
                "      \"url\" : \"https://i.scdn.co/image/ab67616d0000b2737359994525d219f64872d3b1\",\n" +
                "      \"width\" : 640\n" +
                "    }, {\n" +
                "      \"height\" : 300,\n" +
                "      \"url\" : \"https://i.scdn.co/image/ab67616d00001e027359994525d219f64872d3b1\",\n" +
                "      \"width\" : 300\n" +
                "    }, {\n" +
                "      \"height\" : 64,\n" +
                "      \"url\" : \"https://i.scdn.co/image/ab67616d000048517359994525d219f64872d3b1\",\n" +
                "      \"width\" : 64\n" +
                "    } ],\n" +
                "    \"name\" : \"Cut To The Feeling\",\n" +
                "    \"release_date\" : \"2017-05-26\",\n" +
                "    \"release_date_precision\" : \"day\",\n" +
                "    \"total_tracks\" : 1,\n" +
                "    \"type\" : \"album\",\n" +
                "    \"uri\" : \"spotify:album:0tGPJ0bkWOUmH7MEOR77qc\"\n" +
                "  },\n" +
                "  \"artists\" : [ {\n" +
                "    \"external_urls\" : {\n" +
                "      \"spotify\" : \"https://open.spotify.com/artist/6sFIWsNpZYqfjUpaCgueju\"\n" +
                "    },\n" +
                "    \"href\" : \"https://api.spotify.com/v1/artists/6sFIWsNpZYqfjUpaCgueju\",\n" +
                "    \"id\" : \"6sFIWsNpZYqfjUpaCgueju\",\n" +
                "    \"name\" : \"Carly Rae Jepsen\",\n" +
                "    \"type\" : \"artist\",\n" +
                "    \"uri\" : \"spotify:artist:6sFIWsNpZYqfjUpaCgueju\"\n" +
                "  } ],\n" +
                "  \"available_markets\" : [ ],\n" +
                "  \"disc_number\" : 1,\n" +
                "  \"duration_ms\" : 207959,\n" +
                "  \"explicit\" : false,\n" +
                "  \"external_ids\" : {\n" +
                "    \"isrc\" : \"USUM71703861\"\n" +
                "  },\n" +
                "  \"external_urls\" : {\n" +
                "    \"spotify\" : \"https://open.spotify.com/track/11dFghVXANMlKmJXsNCbNl\"\n" +
                "  },\n" +
                "  \"href\" : \"https://api.spotify.com/v1/tracks/11dFghVXANMlKmJXsNCbNl\",\n" +
                "  \"id\" : \"11dFghVXANMlKmJXsNCbNl\",\n" +
                "  \"is_local\" : false,\n" +
                "  \"name\" : \"Cut To The Feeling\",\n" +
                "  \"popularity\" : 6,\n" +
                "  \"preview_url\" : null,\n" +
                "  \"track_number\" : 1,\n" +
                "  \"type\" : \"track\",\n" +
                "  \"uri\" : \"spotify:track:11dFghVXANMlKmJXsNCbNl\"\n" +
                "}"

        val spotifyRequest = SpotifyRequest(client, API.clientCredentialsRequest())
        val trackAPI = TrackAPI(spotifyRequest)
        trackAPI.requestTrack("11dFghVXANMlKmJXsNCbNl")
        val testOutput = trackAPI.getTestResponse()

        assertEquals(correctResponse, testOutput)
    }

    @Test
    fun testMultipleTracks() = runBlocking<Unit>
    {
        requestMultipleTracks_Functional()
    }

    private suspend fun requestMultipleTracks_Functional() {
        delay(10)

        val correctResponse = "{\n" +
                "  \"tracks\" : [ {\n" +
                "    \"album\" : {\n" +
                "      \"album_type\" : \"album\",\n" +
                "      \"artists\" : [ {\n" +
                "        \"external_urls\" : {\n" +
                "          \"spotify\" : \"https://open.spotify.com/artist/0C0XlULifJtAgn6ZNCW2eu\"\n" +
                "        },\n" +
                "        \"href\" : \"https://api.spotify.com/v1/artists/0C0XlULifJtAgn6ZNCW2eu\",\n" +
                "        \"id\" : \"0C0XlULifJtAgn6ZNCW2eu\",\n" +
                "        \"name\" : \"The Kill}"

        val spotifyRequest = SpotifyRequest(client, API.clientCredentialsRequest())
        val trackAPI = TrackAPI(spotifyRequest)
        trackAPI.requestMultipleTracks("3n3Ppam7vgaVa1iaRUc9Lp","3twNvmDtFQtAd5gMKedhLD")
        val testOutput = trackAPI.getTestResponse()
        val trimOutput = testOutput.removeRange(350, testOutput.length-1)
        assertEquals(correctResponse, trimOutput)
    }

    @Test
    fun testRequestTrackAudioFeature() = runBlocking<Unit>
    {
        requestTrackAudioFeature_Functional()
    }

    private suspend fun requestTrackAudioFeature_Functional() {
        delay(10)

        val correctResponse = "{\n" +
                "  \"danceability\" : 0.735,\n" +
                "  \"energy\" : 0.578,\n" +
                "  \"key\" : 5,\n" +
                "  \"loudness\" : -11.840,\n" +
                "  \"mode\" : 0,\n" +
                "  \"speechiness\" : 0.0461,\n" +
                "  \"acousticness\" : 0.514,\n" +
                "  \"instrumentalness\" : 0.0902,\n" +
                "  \"liveness\" : 0.159,\n" +
                "  \"valence\" : 0.636,\n" +
                "  \"tempo\" : 98.002,\n" +
                "  \"type\" : \"audio_features\",\n" +
                "  \"id\" : \"06AKEBrKUckW0KREUWRnvT\",\n" +
                "  \"uri\" : \"spotify:track:06AKEBrKUckW0KREUWRnvT\",\n" +
                "  \"track_href\" : \"https://api.spotify.com/v1/tracks/06AKEBrKUckW0KREUWRnvT\",\n" +
                "  \"analysis_url\" : \"https://api.spotify.com/v1/audio-analysis/06AKEBrKUckW0KREUWRnvT\",\n" +
                "  \"duration_ms\" : 255349,\n" +
                "  \"time_signature\" : 4\n" +
                "}"

        val spotifyRequest = SpotifyRequest(client, API.clientCredentialsRequest())
        val trackAPI = TrackAPI(spotifyRequest)
        trackAPI.requestTrackAudioFeature("06AKEBrKUckW0KREUWRnvT")
        val testOutput = trackAPI.getTestResponse()

        assertEquals(correctResponse, testOutput)
    }

}