package emu.dev.spotify_swipe.api.endpoints

import emu.dev.spotify_swipe.api.spotify.SpotifyRequest

class FollowAPI(private val spotifyRequest: SpotifyRequest) {
    // @GET
    // Requires scope: USER_FOLLOW_READ("user-follow-read")
    suspend fun checkFollowUserArtist(

    ): Boolean {

    }

    // @GET
    // Requires scope: PLAYLIST_READ_PRIVATE("playlist-read-private")
    suspend fun checkFollowPlaylist(

    ): Boolean {

    }

    // @PUT
    // Requires scope: USER_FOLLOW_MODIFY("user-follow_modify")
    suspend fun followArtistUser(

    ) {

    }

    // @PUT
    // Scope required: PLAYLIST_MODIFY_PUBLIC("playlist-modify-public")
    // Scope required: PLAYLIST_MODIFY_PRIVATE("playlist-modify-private")
    suspend fun followPlaylist(

    ) {

    }

    // @GET
    // Requires scope: USER_FOLLOW_READ("user-follow-read")
    suspend fun getFollowedArtists(

    ) {

    }

    // @DELETE
    // Requires scope: USER_FOLLOW_MODIFY("user-follow_modify")
    suspend fun unfollowArtistUser(

    ) {

    }

    // @DELETE
    // Scope required: PLAYLIST_MODIFY_PUBLIC("playlist-modify-public")
    // Scope required: PLAYLIST_MODIFY_PRIVATE("playlist-modify-private")
    suspend fun unfollowPlaylist(

    ) {

    }
}