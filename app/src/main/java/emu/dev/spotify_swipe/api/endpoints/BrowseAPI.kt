package emu.dev.spotify_swipe.api.endpoints

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import emu.dev.spotify_swipe.api.data.Artist
import emu.dev.spotify_swipe.api.data.Category
import emu.dev.spotify_swipe.api.data.Page
import emu.dev.spotify_swipe.api.data.Playlist
import emu.dev.spotify_swipe.api.spotify.SpotifyRequest
import io.ktor.client.request.accept
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.http.ContentType

class BrowseAPI(private val spotifyRequest: SpotifyRequest) {

    private val BROWSE_ENDPOINT: String =
        spotifyRequest.DEFAULT_ENDPOINT
            .plus("/browse/")


    // TODO add query strings from funciton to url
    suspend fun requestCategory(
        category_id: String,
        country: String? = null,
        locale: String? = null
    ): Category {
        val response =
            spotifyRequest.client.get<String>(
                BROWSE_ENDPOINT
                    .plus(category_id)
            ) {
                accept(ContentType.Application.Json)
                header("Authorization", "Bearer ${spotifyRequest.token.access_token}")
            }

        return Gson().fromJson(response, Category::class.java)
    }

    suspend fun requestCategoryPlaylists(
        category_id: String,
        country: String? = null,
        locale: String? = null,
        offset: Int = 0
    ): Page<Playlist> {
        val typeToken = object : TypeToken<Page<Playlist>>() {}.type
        val response =
            spotifyRequest.client.get<String>(
                BROWSE_ENDPOINT
                    .plus(category_id)
                    .plus("/playlists")
            ) {
                accept(ContentType.Application.Json)
                header("Authorization", "Bearer ${spotifyRequest.token.access_token}")
            }

        return Gson().fromJson(response, typeToken)
    }

    suspend fun requestCategoryList(
        country: String? = null,
        locale: String? = null,
        limit: Int = 20,
        offset: Int = 0
    ): Page<Category> {
        val typeToken = object : TypeToken<Page<Category>>() {}.type
        val response =
            spotifyRequest.client.get<String>(
                BROWSE_ENDPOINT
                    .plus("/categories")
            ) {
                accept(ContentType.Application.Json)
                header("Authorization", "Bearer ${spotifyRequest.token.access_token}")
            }

        return Gson().fromJson(response, typeToken)
    }

    suspend fun requestFeaturedPlaylists(

    ) {

    }

    suspend fun requestNewReleases(

    ) {

    }

    suspend fun requestRecommenndationFromSeed(

    ) {

    }
}