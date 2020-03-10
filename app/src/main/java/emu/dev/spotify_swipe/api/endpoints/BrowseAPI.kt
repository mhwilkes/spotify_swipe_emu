package emu.dev.spotify_swipe.api.endpoints

import com.google.gson.Gson
import com.google.gson.internal.bind.util.ISO8601Utils
import com.google.gson.reflect.TypeToken
import emu.dev.spotify_swipe.api.data.*
import emu.dev.spotify_swipe.api.spotify.SpotifyRequest
import io.ktor.client.request.accept
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.http.ContentType
import java.sql.Timestamp

data class Message(private val message: String)

data class FeaturePlaylist(private val message: String, private val playlists: Page<Playlist>)

class BrowseAPI(private val spotifyRequest: SpotifyRequest) {

    private val BROWSE_ENDPOINT: String =
        spotifyRequest.DEFAULT_ENDPOINT
            .plus("/browse/")

    // TODO find out if first query string needs to be prepended with ? or it can be &


    suspend fun requestCategory(
        category_id: String,
        country: String? = null,
        locale: String? = null
    ): Category {
        val response =
            spotifyRequest.client.get<String>(
                BROWSE_ENDPOINT
                    .plus("/categories/")
                    .plus(category_id)
                    .plus(if (country != null) "?country=$country" else "")
                    .plus(if (locale != null) "&locale=$locale" else "")
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
                    .plus(if (country != null) "&country=$country" else "")
                    .plus(if (locale != null) "&locale=$locale" else "")
                    .plus("&offset=$offset")
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
                    .plus(if (country != null) "&country=$country" else "")
                    .plus(if (locale != null) "&locale=$locale" else "")
                    .plus("&limit=$limit")
                    .plus("&offset=$offset")
            ) {
                accept(ContentType.Application.Json)
                header("Authorization", "Bearer ${spotifyRequest.token.access_token}")
            }

        return Gson().fromJson(response, typeToken)
    }

    suspend fun requestFeaturedPlaylists(
        locale: String? = null,
        country: String? = null,
        timestamp: Timestamp? = null,
        limit: Int = 20,
        offset: Int = 0
    ): FeaturePlaylist {
        val typeToken = object : TypeToken<FeaturePlaylist>() {}.type
        val response =
            spotifyRequest.client.get<String>(
                BROWSE_ENDPOINT
                    .plus("/featured-playlists")
                    .plus(if (locale != null) "&locale=$locale" else "")
                    .plus(if (country != null) "&country=$country" else "")
                    .plus(if (timestamp != null) "&timestamp=${ISO8601Utils.format(timestamp)}" else "")
                    .plus("&limit=$limit")
                    .plus("&offset=$offset")

            ) {
                accept(ContentType.Application.Json)
                header("Authorization", "Bearer ${spotifyRequest.token.access_token}")
            }

        return Gson().fromJson(response, typeToken)
    }

    suspend fun requestNewReleases(
        country: String? = null,
        limit: Int = 20,
        offset: Int = 0
    ): Page<Album> {
        val typeToken = object : TypeToken<Page<Album>>() {}.type
        val response =
            spotifyRequest.client.get<String>(
                BROWSE_ENDPOINT
                    .plus("/new-releases")
                    .plus(if (country != null) "&country=$country" else "")
                    .plus("&limit=$limit")
                    .plus("&offset=$offset")

            ) {
                accept(ContentType.Application.Json)
                header("Authorization", "Bearer ${spotifyRequest.token.access_token}")
            }

        return Gson().fromJson(response, typeToken)
    }

    // TODO implement recommendation url query
    suspend fun requestRecommendationFromSeed(
        limit: Int = 20,
        market: String? = null,
        max_: Array<String>? = null,
        min_: Array<String>? = null,
        seed_artists: Array<String>?,
        seed_genres: Array<String>?,
        seed_tracks: Array<String>?,
        target_: Array<String>? = null

    ): Recommendation {
        val typeToken = object : TypeToken<Recommendation>() {}.type
        val response =
            spotifyRequest.client.get<String>(
                spotifyRequest.DEFAULT_ENDPOINT
                    .plus("recommendations")
                    .plus()

            ) {
                accept(ContentType.Application.Json)
                header("Authorization", "Bearer ${spotifyRequest.token.access_token}")
            }

        return Gson().fromJson(response, typeToken)
    }
}