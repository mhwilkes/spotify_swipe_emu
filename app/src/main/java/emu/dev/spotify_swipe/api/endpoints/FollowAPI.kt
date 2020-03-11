package emu.dev.spotify_swipe.api.endpoints

import emu.dev.spotify_swipe.api.data.Artist
import emu.dev.spotify_swipe.api.data.CursorPage
import emu.dev.spotify_swipe.api.spotify.SpotifyRequest

class FollowAPI(private val spotifyRequest: SpotifyRequest) {
    // @GET
    // Requires scope: USER_FOLLOW_READ("user-follow-read")
    suspend fun checkFollowUserArtist(
        type: String,
        vararg ids: String
    ): Boolean {

    }

    // @GET
    // Requires scope: PLAYLIST_READ_PRIVATE("playlist-read-private")
    suspend fun checkFollowPlaylist(
        playlist_id: String,
        vararg ids: String
    ): Boolean {

    }

    // @PUT
    // Requires scope: USER_FOLLOW_MODIFY("user-follow_modify")
    suspend fun followArtistUser(
        type: String,
        vararg ids: String
    ) {

    }

    // @PUT
    // Scope required: PLAYLIST_MODIFY_PUBLIC("playlist-modify-public")
    // Scope required: PLAYLIST_MODIFY_PRIVATE("playlist-modify-private")
    suspend fun followPlaylist(
        playlist_id: String,
        public: Boolean = true
    ) {

    }

    // @GET
    // Requires scope: USER_FOLLOW_READ("user-follow-read")
    suspend fun getFollowedArtists(
        type: String,
        limit: Int = 20,
        after: String? = null
    ): CursorPage<Artist> {

    }

    // @DELETE
    // Requires scope: USER_FOLLOW_MODIFY("user-follow_modify")
    suspend fun unfollowArtistUser(
        type: String,
        vararg ids: String
    ) {

    }

    // @DELETE
    // Scope required: PLAYLIST_MODIFY_PUBLIC("playlist-modify-public")
    // Scope required: PLAYLIST_MODIFY_PRIVATE("playlist-modify-private")
    suspend fun unfollowPlaylist(
        playlist_id: String
    ) {

    }
}