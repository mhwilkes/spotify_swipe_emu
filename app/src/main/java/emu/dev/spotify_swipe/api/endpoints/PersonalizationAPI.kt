package emu.dev.spotify_swipe.api.endpoints

import emu.dev.spotify_swipe.api.spotify.SpotifyRequest

class PersonalizationAPI(private val spotifyRequest: SpotifyRequest) {

    // @GET
    // Requires scope: USER_TOP_READ("user-top-read")
    suspend fun getTopArtistTrack(
        limit: Int = 20,
        offset: Int = 0,
        time_range: String? = null
    ) {

    }

}