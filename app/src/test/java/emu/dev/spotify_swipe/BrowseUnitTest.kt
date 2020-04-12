package emu.dev.spotify_swipe

import emu.dev.spotify_swipe.api.endpoints.BrowseAPI
import emu.dev.spotify_swipe.api.spotify.SpotifyAPI
import emu.dev.spotify_swipe.api.spotify.SpotifyRequest
import io.ktor.client.HttpClient
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*

class BrowseUnitTest {
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
    fun testRequestCategory() = runBlocking<Unit>
    {
        requestCategory_Functional()
    }

    private suspend fun requestCategory_Functional() {
        delay(10)

        val correctResponse = "{\n" +
                "  \"href\" : \"https://api.spotify.com/v1/browse/categories/dinner\",\n" +
                "  \"icons\" : [ {\n" +
                "    \"height\" : 274,\n" +
                "    \"url\" : \"https://t.scdn.co/media/original/dinner_1b6506abba0ba52c54e6d695c8571078_274x274.jpg\",\n" +
                "    \"width\" : 274\n" +
                "  } ],\n" +
                "  \"id\" : \"dinner\",\n" +
                "  \"name\" : \"Cooking & Dining\"\n" +
                "}"

        val spotifyRequest = SpotifyRequest(client, API.clientCredentialsRequest())
        val browseAPI = BrowseAPI(spotifyRequest)
        browseAPI.requestCategory("dinner")
        val testOutput = browseAPI.getTestResponse()

        assertEquals(correctResponse, testOutput)
    }

    @Test
    fun testRequestCategoryPlaylists() = runBlocking<Unit>
    {
        requestCategoryPlaylists_Functional()
    }

    private suspend fun requestCategoryPlaylists_Functional() {
        delay(10)

        val correctResponse = "{\n" +
                "  \"playlists\" : {\n" +
                "    \"href\" : \"https://api.spotify.com/v1/browse/categories/party/playlists?country=US&offset=0&limit=20\",\n" +
                "    \"items\" : [ {\n" +
                "      \"collaborative\" : false,\n" +
                "      \"description\" : \"Turn up with the biggest party tracks of the '90s and '00s.\",\n" +
                "      \"external_urls\" : {\n" +
                "        \"spotify\" : \"https://open.spotify.com/playlist/37i9dQZF1DX8ky12eWIvcW\"\n" +
                "      },\n" +
                "      }"

        val spotifyRequest = SpotifyRequest(client, API.clientCredentialsRequest())
        val browseAPI = BrowseAPI(spotifyRequest)
        browseAPI.requestCategoryPlaylists("party", "US")
        val testOutput = browseAPI.getTestResponse()
        val trimOutput = testOutput.removeRange(380, testOutput.length-1)
        assertEquals(correctResponse, trimOutput)
    }

    @Test
    fun testRequestCategoryList() = runBlocking<Unit>
    {
        requestCategoryList_Functional()
    }

    private suspend fun requestCategoryList_Functional() {
        delay(10)

        val correctResponse = "{\n" +
                "  \"categories\" : {\n" +
                "    \"href\" : \"https://api.spotify.com/v1/browse/categories?country=US&offset=0&limit=1\",\n" +
                "    \"items\" : [ {\n" +
                "      \"href\" : \"https://api.spotify.com/v1/browse/categories/toplists\",\n" +
                "      \"icons\" : [ {\n" +
                "        \"height\" : 275,\n" +
                "        \"url\" : \"https://t.scdn.co/media/derived/toplists_11160599e6a04ac5d6f2757f5511778f_0_0_275_275.jpg\",\n" +
                "        \"width\" : 275\n" +
                "      } ],\n" +
                "      \"id\" : \"toplists\",\n" +
                "      \"name\" : \"Top Lists\"\n" +
                "    } ],\n" +
                "    \"limit\" : 1,\n" +
                "    \"next\" : \"https://api.spotify.com/v1/browse/categories?country=US&offset=1&limit=1\",\n" +
                "    \"offset\" : 0,\n" +
                "    \"previous\" : null,\n" +
                "    \"total\" : 45\n" +
                "  }\n" +
                "}"

        val spotifyRequest = SpotifyRequest(client, API.clientCredentialsRequest())
        val browseAPI = BrowseAPI(spotifyRequest)
        browseAPI.requestCategoryList("US",null,1)
        val testOutput = browseAPI.getTestResponse()
        assertEquals(correctResponse, testOutput)
    }

    // featured playlist request needs work
/*
    @Test
    fun testRequestFeaturedPlaylists() = runBlocking<Unit>
    {
        val actual = requestFeaturedPlaylists_Functional()
    }

    private suspend fun requestFeaturedPlaylists_Functional() {
        delay(100)

        val correctResponse = "{\n" +
                "  \"playlists\" : {\n" +
                "    \"href\" : \"https://api.spotify.com/v1/browse/categories/party/playlists?country=US&offset=0&limit=20\",\n" +
                "    \"items\" : [ {\n" +
                "      \"collaborative\" : false,\n" +
                "      \"description\" : \"Turn up with the biggest party tracks of the '90s and '00s.\",\n" +
                "      \"external_urls\" : {\n" +
                "        \"spotify\" : \"https://open.spotify.com/playlist/37i9dQZF1DX8ky12eWIvcW\"\n" +
                "      },\n" +
                "      }"

        val spotifyRequest = SpotifyRequest(client, API.clientCredentialsRequest())
        val browseAPI = BrowseAPI(spotifyRequest)
        val requestOutput = browseAPI.requestFeaturedPlaylists()
        val testOutput = browseAPI.getTestResponse()
        val trimOutput = testOutput.removeRange(380, testOutput.length-1)
        assertEquals(correctResponse, trimOutput)
    }
 */
    @Test
    fun testRequestRecommendationFromSeed() = runBlocking<Unit>
    {
        requestRecommendationFromSeed_Functional()
    }

    private suspend fun requestRecommendationFromSeed_Functional() {
        delay(10)

        val correctResponse = "{\n" +
                "  \"tracks\" : [ {\n" +
                "    \"album\" : {\n" +
                "      \"album_type\" : \"ALBUM\",\n" +
                "      \"artists\" : [ {\n" +
                "        \"external_urls\" : {\n" +
                "          \"spotify\" : \"https://open.spotify.com/artist/4NHQUGzhtTLFvgF5SZesLK\"\n" +
                "      }"
        val seed_artist = Array(1) {"4NHQUGzhtTLFvgF5SZesLK"}
        val seed_tracks = Array(1) {"0c6xIDDpzE81m2q797ordA"}
        val spotifyRequest = SpotifyRequest(client, API.clientCredentialsRequest())
        val browseAPI = BrowseAPI(spotifyRequest)
        browseAPI.requestRecommendationFromSeed(1,"US",null,null, seed_artist,null,seed_tracks)

        val testOutput = browseAPI.getTestResponse()
        val trimOutput = testOutput.removeRange(200, testOutput.length-1)
        assertEquals(correctResponse, trimOutput)
    }
}
