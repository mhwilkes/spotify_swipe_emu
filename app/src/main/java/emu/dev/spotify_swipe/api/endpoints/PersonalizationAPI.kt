package emu.dev.spotify_swipe.api.endpoints

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import emu.dev.spotify_swipe.api.data.Album
import emu.dev.spotify_swipe.api.data.Artist
import emu.dev.spotify_swipe.api.data.Page
import emu.dev.spotify_swipe.api.spotify.SpotifyRequest
import io.ktor.client.request.accept
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.http.ContentType

enum class UserTop(val uri: String) {
    ARTISTS("artists"),
    TRACKS("tracks")
}

class PersonalizationAPI(private val spotifyRequest: SpotifyRequest) {

    // @GET
    // Requires scope: USER_TOP_READ("user-top-read")
    suspend fun getTopArtistTrack(
        type: UserTop,
        limit: Int = 20,
        offset: Int = 0,
        time_range: String? = null
    ): Page<Any> {
       val response = spotifyRequest.client.get<String>(
            spotifyRequest.DEFAULT_ENDPOINT
                .plus("me/top/${type.uri}")
                .plus("?limit=$limit")
                .plus("&offset=$offset")
                .plus(if (!time_range.isNullOrBlank()) "&time_range=$time_range" else "")
        ) {
            accept(ContentType.Application.Json)
            header("Authorization", "Bearer ${spotifyRequest.token.access_token}")
        }
        val typeToken = if (type.uri == "artists") {
            object : TypeToken<Page<Artist>>() {}.type
        } else {
            object : TypeToken<Page<Album>>() {}.type
        }

        return Gson().fromJson(response, typeToken)
    }
}