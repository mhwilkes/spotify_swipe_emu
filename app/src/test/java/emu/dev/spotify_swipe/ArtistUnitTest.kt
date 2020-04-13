package emu.dev.spotify_swipe

import emu.dev.spotify_swipe.api.endpoints.ArtistAPI
import emu.dev.spotify_swipe.api.spotify.SpotifyAPI
import emu.dev.spotify_swipe.api.spotify.SpotifyRequest
import io.ktor.client.HttpClient
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*

class ArtistUnitTest {

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
    fun testRequestArtist() = runBlocking<Unit>
    {
        requestArtist_Functional()
    }

    suspend fun requestArtist_Functional()

    {
        delay(10)

        val correctResponse = "\"genres\" : [ \"chamber pop\", \"indie folk\", \"indie pop\", \"indie rock\", \"modern rock\", \"stomp and holler\" ],\n" +
                "  \"href\" : \"https://api.spotify.com/v1/artists/0OdUWJ0sBjDrqHygGUXeCF\",\n" +
                "  \"id\" : \"0OdUWJ0sBjDrqHygGUXeCF\",\n" +
                "  \"images\" : [ {\n" +
                "    \"height\" : 640,\n" +
                "    \"url\" : \"https://i.scdn.co/image/0f9a5013134de288af7d49a962417f4200539b47\",\n" +
                "    \"width\" : 640\n" +
                "  }, {\n" +
                "    \"height\" : 320,\n" +
                "    \"url\" : \"https://i.scdn.co/image/8ae35be1043f330173de198c35a49161337e829c\",\n" +
                "    \"width\" : 320\n" +
                "  }, {\n" +
                "    \"height\" : 160,\n" +
                "    \"url\" : \"https://i.scdn.co/image/602dd7b3a2ee3f3fd86c6c4f50ab9b5a82e23c59\",\n" +
                "    \"width\" : 160\n" +
                "  } ],\n" +
                "  \"name\" : \"Band of Horses\",\n" +
                "  \"popularity\" : 63,\n" +
                "  \"type\" : \"artist\",\n" +
                "  \"uri\" : \"spotify:artist:0OdUWJ0sBjDrqHygGUXeCF\"\n" +
                "}"

        val spotifyRequest = SpotifyRequest(client, API.clientCredentialsRequest())
        val ArtistAPI = ArtistAPI(spotifyRequest)

        val testOutput = ArtistAPI.requestArtist("0OdUWJ0sBjDrqHygGUXeCF")
        val trimOutput = testOutput.removeRange(0, 167)
        assertEquals(correctResponse, trimOutput)
    }

    // artist albums request is a little broken
    /*
    @Test
    fun testRequestArtistAlbums() = runBlocking<Unit>
    {
        val actual = requestArtistAlbums_Functional()
    }
    suspend fun requestArtistAlbums_Functional()
    {
        delay(100)
        val correctResponse = "{\n" +
                "  \"external_urls\" : {\n" +
                "    \"spotify\" : \"https://open.spotify.com/artist/0OdUWJ0sBjDrqHygGUXeCF\"\n" +
                "  },\n" +
                "  \"followers\" : {\n" +
                "    \"href\" : null,\n" +
                "    \"total\" : 791818\n" +
                "  },\n" +
                "  \"genres\" : [ \"chamber pop\", \"indie folk\", \"indie pop\", \"indie rock\", \"modern rock\", \"stomp and holler\" ],\n" +
                "  \"href\" : \"https://api.spotify.com/v1/artists/0OdUWJ0sBjDrqHygGUXeCF\",\n" +
                "  \"id\" : \"0OdUWJ0sBjDrqHygGUXeCF\",\n" +
                "  \"images\" : [ {\n" +
                "    \"height\" : 640,\n" +
                "    \"url\" : \"https://i.scdn.co/image/0f9a5013134de288af7d49a962417f4200539b47\",\n" +
                "    \"width\" : 640\n" +
                "  }, {\n" +
                "    \"height\" : 320,\n" +
                "    \"url\" : \"https://i.scdn.co/image/8ae35be1043f330173de198c35a49161337e829c\",\n" +
                "    \"width\" : 320\n" +
                "  }, {\n" +
                "    \"height\" : 160,\n" +
                "    \"url\" : \"https://i.scdn.co/image/602dd7b3a2ee3f3fd86c6c4f50ab9b5a82e23c59\",\n" +
                "    \"width\" : 160\n" +
                "  } ],\n" +
                "  \"name\" : \"Band of Horses\",\n" +
                "  \"popularity\" : 63,\n" +
                "  \"type\" : \"artist\",\n" +
                "  \"uri\" : \"spotify:artist:0OdUWJ0sBjDrqHygGUXeCF\"\n" +
                "}"
        val spotifyRequest = SpotifyRequest(client, API.clientCredentialsRequest())
        val ArtistAPI = ArtistAPI(spotifyRequest)
        ArtistAPI.requestArtistAlbums("0OdUWJ0sBjDrqHygGUXeCF")
        val testOutput = ArtistAPI.getTestResponse()
        val trimOutput = testOutput.removeRange(380, testOutput.length-1)
        assertEquals(correctResponse, trimOutput)
    }
     */


    @Test
    fun testRequestArtistTopTracks() = runBlocking<Unit>
    {
        requestArtistTopTracks_Functional()
    }

    suspend fun requestArtistTopTracks_Functional()

    {
        delay(10)

        val correctResponse = "{\n" +
                "  \"tracks\" : [ {\n" +
                "    \"album\" : {\n" +
                "      \"album_type\" : \"album\",\n" +
                "      \"artists\" : [ {\n" +
                "        \"external_urls\" : {\n" +
                "          \"spotify\" : \"https://open.spotify.com/artist/0OdUWJ0sBjDrqHygGUXeCF\"\n" +
                "        },\n" +
                "        \"href\" : \"https://api.spotify.com/v1/artists/0OdUWJ0sBjDrqHygGUXeCF\",\n" +
                "        \"id\" : \"0OdUWJ0sBjDrqHygGUXeCF\",\n" +
                "        \"name\" : \"Band of Horses\",\n" +
                "        \"type\" : \"artist\",\n" +
                "        \"uri\" : \"spotify:artist:0OdUWJ0sBjDrqHygGUXeCF\"\n" +
                "      } ],\n" +
                "      \"external_urls\" : {\n" +
                "        \"spotify\" : \"}"

        val spotifyRequest = SpotifyRequest(client, API.clientCredentialsRequest())
        val ArtistAPI = ArtistAPI(spotifyRequest)
        ArtistAPI.requestArtistTopTracks("0OdUWJ0sBjDrqHygGUXeCF","US")
        val testOutput = ArtistAPI.getTestResponse()
        val trimOutput = testOutput.removeRange(500, testOutput.length-1)
        assertEquals(correctResponse, trimOutput)
    }

    @Test
    fun testRequestRelatedArtists() = runBlocking<Unit>
    {
        requestRelatedArtists_Functional()
    }

    suspend fun requestRelatedArtists_Functional()

    {
        delay(10)

        val correctResponse = " \"genres\" : [ \"albuquerque indie\", \"alternative rock\", \"chamber pop\", \"garage rock\", \"indie folk\", \"indie pop\", \"indie rock\", \"modern rock\", \"portland indie\", \"rock\", \"stomp and holler\" ],\n" +
                "    \"href\" : \"https://api.spotify.com/v1/artists/4LG4Bs1Gadht7TCrMytQUO\",\n" +
                "    \"id\" : \"4LG4Bs1Gadht7TCrMytQUO\",\n" +
                "}"

        val spotifyRequest = SpotifyRequest(client, API.clientCredentialsRequest())
        val ArtistAPI = ArtistAPI(spotifyRequest)
        val testOutput =  ArtistAPI.requestRelatedArtists("0OdUWJ0sBjDrqHygGUXeCF")
        val trimOutput = testOutput.removeRange(0,200)
        val trimmedOutput = trimOutput.removeRange(300, trimOutput.length-1)
        assertEquals(correctResponse, trimmedOutput)
    }

    @Test
    fun testRequestArtists() = runBlocking<Unit>
    {
        requestArtists_Functional()
    }

    suspend fun requestArtists_Functional()

    {
        delay(10)

        val correctResponse = "  \"genres\" : [ \"album rock\", \"art rock\", \"classic rock\", \"dance rock\", \"glam rock\", \"permanent wave\", \"protopunk\", \"rock\" ],\n" +
                "    \"href\" : \"https://api.spotify.com/v1/artists/0oSGxfWSnnOXhD2fKuz2Gy\",\n" +
                "    \"id\" : \"0oSGxfWSnnOXhD2fKuz2Gy\",\n" +
                "    \"images\" :}"

        val spotifyRequest = SpotifyRequest(client, API.clientCredentialsRequest())
        val ArtistAPI = ArtistAPI(spotifyRequest)
        val requestOutput = ArtistAPI.requestArtists("0oSGxfWSnnOXhD2fKuz2Gy","3dBVyJ7JuOMt4GE9607Qin")
        val trimOutput = "requestOutput".removeRange(0,200)
        val trimmedOutput = trimOutput.removeRange(250, trimOutput.length-1)
        assertEquals(correctResponse, trimmedOutput)
    }
}