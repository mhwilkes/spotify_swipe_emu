package emu.dev.spotify_swipe.api.endpoints

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import emu.dev.spotify_swipe.api.data.*
import emu.dev.spotify_swipe.api.spotify.SpotifyRequest
import io.ktor.client.request.*
import io.ktor.http.ContentType

// https://developer.spotify.com/documentation/general/guides/working-with-playlists/

class PlaylistAPI(private val spotifyRequest: SpotifyRequest) {

    val PLAYLIST_ENDPOINT = spotifyRequest.DEFAULT_ENDPOINT
        .plus("playlists")

    // @POST
    // Scope required: PLAYLIST_MODIFY_PUBLIC("playlist-modify-public")
    // Scope required: PLAYLIST_MODIFY_PRIVATE("playlist-modify-private")
    suspend fun addTrackToPlaylist(
        playlist_id: String,
        vararg uris: String? = arrayOf(),
        position: Int? = null
    ) {
        val response =
            spotifyRequest.client.post<String>(
                PLAYLIST_ENDPOINT
                    .plus("/$playlist_id/tracks")
                    .plus("?uris=${uris.joinToString("%2C")}")
                    .plus(if (position != null) "&position=$position" else "")
            ) {
                accept(ContentType.Application.Json)
                header("Authorization", "Bearer ${spotifyRequest.token.access_token}")
            }
    }


    // TODO Add params to body
    // @PUT
    // Scope required: PLAYLIST_MODIFY_PUBLIC("playlist-modify-public")
    // Scope required: PLAYLIST_MODIFY_PRIVATE("playlist-modify-private")
    suspend fun changePlaylistDetails(
        playlist_id: String,
        name: String? = null,
        public: Boolean = false,
        collaborative: Boolean = false,
        description: String? = null
    ) {
        val response =
            spotifyRequest.client.put<String>(
                PLAYLIST_ENDPOINT
                    .plus("/$playlist_id/")
            ) {
                accept(ContentType.Application.Json)
                header("Authorization", "Bearer ${spotifyRequest.token.access_token}")
            }
    }

    // TODO Add params to body

    // @POST
    // Scope required: PLAYLIST_MODIFY_PUBLIC("playlist-modify-public")
    // Scope required: PLAYLIST_MODIFY_PRIVATE("playlist-modify-private")
    suspend fun createPlaylist(
        user_id: String,
        name: String? = null,
        public: Boolean = false,
        collaborative: Boolean = false,
        description: String? = null
    ): Playlist {
        val typeToken = object : TypeToken<Playlist>() {}.type
        val response =
            spotifyRequest.client.put<String>(
                spotifyRequest.DEFAULT_ENDPOINT
                    .plus("/users/$user_id/playlists")
            ) {
                accept(ContentType.Application.Json)
                header("Authorization", "Bearer ${spotifyRequest.token.access_token}")
            }

        return Gson().fromJson(response, typeToken)
    }

    // @GET
    // Scope required: PLAYLIST_READ_COLLABORATIVE("playlist-read-collaborative")
    // Requires scope: PLAYLIST_READ_PRIVATE("playlist-read-private")
    suspend fun getCurrentUserPlaylists(
        limit: Int = 20,
        offset: Int = 0
    ): Page<PlaylistSimple> {
        val typeToken = object : TypeToken<Page<PlaylistSimple>>() {}.type
        val response =
            spotifyRequest.client.put<String>(
                spotifyRequest.DEFAULT_ENDPOINT
                    .plus("/me/playlists")
                    .plus("?limit=$limit")
                    .plus("&offset=$offset")
            ) {
                accept(ContentType.Application.Json)
                header("Authorization", "Bearer ${spotifyRequest.token.access_token}")
            }
        return Gson().fromJson(response, typeToken)
    }


    // TODO FINISH IMPLEMENT
    // @GET
    // Scope required: PLAYLIST_READ_COLLABORATIVE("playlist-read-collaborative")
    // Requires scope: PLAYLIST_READ_PRIVATE("playlist-read-private")
    suspend fun getUserPlaylists(
        user_id: String,
        limit: Int = 20,
        offset: Int = 0
    ): Page<PlaylistSimple>? {
        return null
    }

    // TODO FINISH IMPLEMENT
    // @GET
    suspend fun getPlaylistCoverImage(
        playlist_id: String
    ): Array<Image>? {
        return null
    }

    // TODO FINISH IMPLEMENT
    // @GET
    suspend fun getPlaylist(
        playlist_id: String,
        vararg fields: String? = arrayOf(),
        market: String? = null
    ): Playlist? {
        return null
    }

    // TODO FINISH IMPLEMENT
    // @GET
    suspend fun getPlaylistTracks(
        playlist_id: String,
        vararg fields: String? = arrayOf(),
        limit: Int = 100,
        offset: Int = 0,
        market: String? = null
    ) {

    }

    // @DELETE
    // Scope required: PLAYLIST_MODIFY_PUBLIC("playlist-modify-public")
    // Scope required: PLAYLIST_MODIFY_PRIVATE("playlist-modify-private")
    suspend fun removePlaylistTracks(
        playlist_id: String,
        vararg tracks: String
    ) {

    }

    // @PUT
    // Scope required: PLAYLIST_MODIFY_PUBLIC("playlist-modify-public")
    // Scope required: PLAYLIST_MODIFY_PRIVATE("playlist-modify-private")
    suspend fun reorderPlaylistTracks(
        playlist_id: String,
        range_start: Int,
        range_length: Int? = null,
        insert_before: Int? = null,
        snapshot_id: String? = null
    ) {

    }

    // @PUT
    // Scope required: PLAYLIST_MODIFY_PUBLIC("playlist-modify-public")
    // Scope required: PLAYLIST_MODIFY_PRIVATE("playlist-modify-private")
    suspend fun replacePlaylistTracks(
        playlist_id: String,
        vararg uris: String? = arrayOf()
    ) {

    }

    // @PUT
    // Requires scope: UGC_IMAGE_UPLOAD("ugc-image-upload")
    // Scope required: PLAYLIST_MODIFY_PUBLIC("playlist-modify-public")
    // Scope required: PLAYLIST_MODIFY_PRIVATE("playlist-modify-private")
    suspend fun uploadCustomPlaylistCoverImage(
        playlist_id: String,
        base_64_image: String
    ) {

    }
}