package emu.dev.spotify_swipe.api.endpoints

import emu.dev.spotify_swipe.api.spotify.SpotifyRequest

class SearchAPI(private val spotifyRequest: SpotifyRequest){

    // Scope required: USER_READ_PRIVATE("user-read-private")
    suspend fun search(
        vararg q: String,
        type: Array<String>,
        market: String? = null,
        limit: Int = 20,
        offset: Int = 0,
        include_external: String
    ) {

    }
}