package emu.dev.spotify_swipe.api.endpoints

import emu.dev.spotify_swipe.api.data.UserPrivate
import emu.dev.spotify_swipe.api.data.UserPublic
import emu.dev.spotify_swipe.api.spotify.SpotifyRequest

class UserAPI(private val spotifyRequest: SpotifyRequest) {

    // @GET
    // Scope implement: USER_READ_EMAIL("user-read-email")
    // When scope is provided, User object returns email with account
    // Scope required: USER_READ_PRIVATE("user-read-private")
    suspend fun getCurrentProfile(): UserPrivate {

    }

    // @GET
    suspend fun getProfile(
        user_id: String
    ): UserPublic {

    }
}