package emu.dev.spotify_swipe.api.endpoints

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import emu.dev.spotify_swipe.api.data.*
import emu.dev.spotify_swipe.api.spotify.SpotifyRequest
import io.ktor.client.request.accept
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.http.ContentType

class ArtistAPI(private val spotifyRequest: SpotifyRequest) {

    private val ARTIST_ENDPOINT: String =
        spotifyRequest.DEFAULT_ENDPOINT
            .plus("/artists/")

    suspend fun requestArtist(
        id: String
    ): Artist {
        val response =
            spotifyRequest.client.get<String>(
                ARTIST_ENDPOINT
                    .plus(id)
            ) {
                accept(ContentType.Application.Json)
                header("Authorization", "Bearer ${spotifyRequest.token.access_token}")
            }

        return Gson().fromJson(response, Artist::class.java)
    }

    suspend fun requestArtistAlbums(
        id: String,
        vararg include_groups: IncludeGroups? = arrayOf(),
        country: String? = null,
        limit: Int = 20,
        offset: Int = 0
    ): Page<AlbumSimple> {
        val typeToken = object : TypeToken<Page<AlbumSimple>>() {}.type
        val response =
            spotifyRequest.client.get<String>(
                ARTIST_ENDPOINT
                    .plus(id)
                    .plus("albums/")
                    .plus(include_groups.joinToString(separator = "%2C"))
                    .plus(if (country != null) "&market=$country" else "")
                    .plus("&limit=$limit")
                    .plus("&offset=$offset")
            ) {
                accept(ContentType.Application.Json)
                header("Authorization", "Bearer ${spotifyRequest.token.access_token}")
            }

        return Gson().fromJson(response, typeToken)

    }

    suspend fun requestArtistTopTracks(
        id: String,
        country: String? = null
    ): List<Track> {
        val response =
            spotifyRequest.client.get<String>(
                ARTIST_ENDPOINT
                    .plus(id)
                    .plus("top-tracks/")
                    .plus(if (country != null) "&market=$country" else "")
            ) {
                accept(ContentType.Application.Json)
                header("Authorization", "Bearer ${spotifyRequest.token.access_token}")
            }

        return Gson().fromJson(response, Tracks::class.java).asList()
    }

    suspend fun requestRelatedArtists(
        id: String
    ): List<Artist> {
        val response =
            spotifyRequest.client.get<String>(
                ARTIST_ENDPOINT
                    .plus(id)
                    .plus("related-artists/")
            ) {
                accept(ContentType.Application.Json)
                header("Authorization", "Bearer ${spotifyRequest.token.access_token}")
            }

        return Gson().fromJson(response, Artists::class.java).asList()
    }

    suspend fun requestArtists(
        vararg ids: String?
    ): List<Artist> {
        val response =
            spotifyRequest.client.get<String>(
                ARTIST_ENDPOINT
                    .plus(ids.joinToString(separator = "%2C"))
            ) {
                accept(ContentType.Application.Json)
                header("Authorization", "Bearer ${spotifyRequest.token.access_token}")
            }

        return Gson().fromJson(response, Artists::class.java).asList()
    }
}