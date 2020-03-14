package emu.dev.spotify_swipe.api.endpoints

import emu.dev.spotify_swipe.api.spotify.SpotifyRequest
import io.ktor.client.request.accept
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.http.ContentType

class PersonalizationAPI(private val spotifyRequest: SpotifyRequest) {

    // @GET
    // Requires scope: USER_TOP_READ("user-top-read")
    suspend fun getTopArtistTrack(
        limit: Int = 20,
        offset: Int = 0,
        time_range: String? = null
    ) {
        spotifyRequest.client.get<String>(
            spotifyRequest.DEFAULT_ENDPOINT
                .plus("limit=$limit")
                .plus("&offset=$offset")
                .plus(if (!time_range.isNullOrBlank()) "&time_range=$time_range" else "")
        ) {
            accept(ContentType.Application.Json)
            header("Authorization", "Bearer ${spotifyRequest.token.access_token}")
        }
    }

}