package emu.dev.spotify_swipe.api.endpoints

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import emu.dev.spotify_swipe.api.data.Artist
import emu.dev.spotify_swipe.api.data.CursorPage
import emu.dev.spotify_swipe.api.spotify.SpotifyRequest
import io.ktor.client.request.*
import io.ktor.http.ContentType

class FollowAPI(private val spotifyRequest: SpotifyRequest) {

    val FOLLOW_ENDPOINT =
        spotifyRequest.DEFAULT_ENDPOINT
            .plus("/me/following/")


    // @GET
    // Requires scope: USER_FOLLOW_READ("user-follow-read")
    suspend fun checkFollowUserArtist(
        type: String,
        vararg ids: String
    ): Boolean {
        val typeToken = object : TypeToken<Boolean>() {}.type
        val response =
            spotifyRequest.client.get<String>(
                FOLLOW_ENDPOINT
                    .plus("contains")
                    .plus("?type=$type")
                    .plus("&ids=${ids.joinToString(separator = "%2C")}")
            ) {
                accept(ContentType.Application.Json)
                header("Authorization", "Bearer ${spotifyRequest.token.access_token}")
            }

        return Gson().fromJson(response, typeToken)
    }

    // @GET
    // Requires scope: PLAYLIST_READ_PRIVATE("playlist-read-private")
    suspend fun checkFollowPlaylist(
        playlist_id: String,
        vararg ids: String
    ): Boolean {

        val typeToken = object : TypeToken<Boolean>() {}.type
        val response =
            spotifyRequest.client.get<String>(
                spotifyRequest.DEFAULT_ENDPOINT
                    .plus("/playlists/$playlist_id/followers/contains")
                    .plus("?ids=${ids.joinToString(separator = "%2C")}")
            ) {
                accept(ContentType.Application.Json)
                header("Authorization", "Bearer ${spotifyRequest.token.access_token}")
            }

        return Gson().fromJson(response, typeToken)
    }

    // @PUT
    // Requires scope: USER_FOLLOW_MODIFY("user-follow_modify")
    suspend fun followArtistUser(
        type: String,
        vararg ids: String
    ) {
        val typeToken = object : TypeToken<Boolean>() {}.type
        val response =
            spotifyRequest.client.put<String>(
                FOLLOW_ENDPOINT
                    .plus("?type=$type")
                    .plus("&ids=${ids.joinToString(separator = "%2C")}")
            ) {
                accept(ContentType.Application.Json)
                header("Authorization", "Bearer ${spotifyRequest.token.access_token}")
            }

        return Gson().fromJson(response, typeToken)
    }

    // @PUT
    // Scope required: PLAYLIST_MODIFY_PUBLIC("playlist-modify-public")
    // Scope required: PLAYLIST_MODIFY_PRIVATE("playlist-modify-private")
    suspend fun followPlaylist(
        playlist_id: String,
        public: Boolean = true
    ) {
        val response =
            spotifyRequest.client.put<String>(
                spotifyRequest.DEFAULT_ENDPOINT
                    .plus("/playlists/$playlist_id/followers")
                    .plus("?public=$public")
            ) {
                accept(ContentType.Application.Json)
                header("Authorization", "Bearer ${spotifyRequest.token.access_token}")
            }
    }

    // @GET
    // Requires scope: USER_FOLLOW_READ("user-follow-read")
    suspend fun getFollowedArtists(
        type: String,
        limit: Int = 20,
        after: String? = null
    ): CursorPage<Artist> {
        val typeToken = object : TypeToken<CursorPage<Artist>>() {}.type
        val response =
            spotifyRequest.client.get<String>(
                FOLLOW_ENDPOINT
                    .plus("?type=$type")
                    .plus("&limit=$limit")
                    .plus(if (after != null) "&after=$after" else "")
            ) {
                accept(ContentType.Application.Json)
                header("Authorization", "Bearer ${spotifyRequest.token.access_token}")
            }

        return Gson().fromJson(response, typeToken)
    }

    // @DELETE
    // Requires scope: USER_FOLLOW_MODIFY("user-follow_modify")
    suspend fun unfollowArtistUser(
        type: String,
        vararg ids: String
    ) {
        val response =
            spotifyRequest.client.delete<String>(
                FOLLOW_ENDPOINT
                    .plus("?type=$type")
                    .plus("&ids=${ids.joinToString(separator = "%2C")}")
            ) {
                accept(ContentType.Application.Json)
                header("Authorization", "Bearer ${spotifyRequest.token.access_token}")
            }
    }

    // @DELETE
    // Scope required: PLAYLIST_MODIFY_PUBLIC("playlist-modify-public")
    // Scope required: PLAYLIST_MODIFY_PRIVATE("playlist-modify-private")
    suspend fun unfollowPlaylist(
        playlist_id: String
    ) {
        spotifyRequest.client.delete<String>(
            spotifyRequest.DEFAULT_ENDPOINT
                .plus("/playlists/$playlist_id/followers")
        ) {
            accept(ContentType.Application.Json)
            header("Authorization", "Bearer ${spotifyRequest.token.access_token}")
        }
    }
}