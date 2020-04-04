package emu.dev.spotify_swipe.api.endpoints

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import emu.dev.spotify_swipe.api.data.*
import emu.dev.spotify_swipe.api.spotify.SpotifyRequest
import io.ktor.client.request.*
import io.ktor.http.ContentType

class PlayerAPI(private val spotifyRequest: SpotifyRequest) {

    // @BETA CHANGES BY SPOTIFY MAY HAPPEN

    // TODO might need streaming scope for playback. Spotify says its only for web playback sdk though

    val PLAYER_ENDPOINT = spotifyRequest.DEFAULT_ENDPOINT
        .plus("me/player")

    // @POST
    suspend fun addToPlaybackQueue(
        uri: String,
        device_id: String? = null
    ) {
        val response =
            spotifyRequest.client.post<String>(
                PLAYER_ENDPOINT
                    .plus("/queue")
                    .plus("?uri=$uri")
                    .plus(if (!device_id.isNullOrBlank()) "&device_id=$device_id" else "")
            ) {
                accept(ContentType.Application.Json)
                header("Authorization", "Bearer ${spotifyRequest.token.access_token}")
            }
    }

    // @GET
    // Requires scope: USER_READ_PLAYBACK_STATE("user-read-playback-state")
    suspend fun getAvailableDevices(): List<Device> {
        val response =
            spotifyRequest.client.get<String>(
                PLAYER_ENDPOINT
                    .plus("/devices")
            ) {
                accept(ContentType.Application.Json)
                header("Authorization", "Bearer ${spotifyRequest.token.access_token}")
            }

        return Gson().fromJson(response, Devices::class.java).asList()
    }

    // @GET
    // Requires scope: USER_READ_PLAYBACK_STATE("user-read-playback-state")
    suspend fun getInformationOnPlayback(
        market: String? = null
    ): PlayingContext {
        val typeToken = object : TypeToken<PlayingContext>() {}.type
        val response =
            spotifyRequest.client.get<String>(
                PLAYER_ENDPOINT
                    .plus(if (market != null) "?market=$market" else "")
            ) {
                accept(ContentType.Application.Json)
                header("Authorization", "Bearer ${spotifyRequest.token.access_token}")
            }
        return Gson().fromJson(response, typeToken)
    }

    // @GET
    // Requires scope: USER_READ_CURRENTLY_PLAYING("user-read-currently-playing")
    // Requires scope: USER_READ_RECENTLY_PLAYED("user-read-recently-played")
    suspend fun getCurrentUserRecentlyPlayed(
        limit: Int = 20,
        after: Int? = null,
        before: Int? = null
    ): Page<PlayHistory> {
        val typeToken = object : TypeToken<Page<PlayHistory>>() {}.type
        val response =
            spotifyRequest.client.get<String>(
                PLAYER_ENDPOINT
                    .plus("/recently-played")
                    .plus("?limit=$limit")
                    .plus(if (after != null) "&after=$after" else "")
                    .plus(if (before != null) "&before=$before" else "")
            ) {
                accept(ContentType.Application.Json)
                header("Authorization", "Bearer ${spotifyRequest.token.access_token}")
            }
        return Gson().fromJson(response, typeToken)
    }

    // @GET
    // Requires scope: USER_READ_PLAYBACK_STATE("user-read-playback-state")
    suspend fun getCurrentUserCurrentPlaying(
        market: String? = null
    ): PlayingCurrently {
        val typeToken = object : TypeToken<Page<PlayHistory>>() {}.type
        val response =
            spotifyRequest.client.get<String>(
                PLAYER_ENDPOINT
                    .plus("/currently-playing")
                    .plus(if (market != null) "&market=$market" else "")
            ) {
                accept(ContentType.Application.Json)
                header("Authorization", "Bearer ${spotifyRequest.token.access_token}")
            }
        return Gson().fromJson(response, typeToken)
    }

    // @PUT
    // Requires scope: USER_MODIFY_PLAYBACK_STATE("user-modify-playback-state")
    suspend fun pausePlayback(
        device_id: String? = null
    ) {
        val response =
            spotifyRequest.client.put<String>(
                PLAYER_ENDPOINT
                    .plus("/pause")
            ) {
                accept(ContentType.Application.Json)
                header("Authorization", "Bearer ${spotifyRequest.token.access_token}")
            }
    }

    // @PUT
    // Requires scope: USER_MODIFY_PLAYBACK_STATE("user-modify-playback-state")
    suspend fun seekPosition(
        position_ms: Int,
        device_id: String? = null
    ) {
        val response =
            spotifyRequest.client.put<String>(
                PLAYER_ENDPOINT
                    .plus("/seek")
                    .plus("?position_ms=$position_ms")
                    .plus(if (device_id != null) "&device_id=$device_id" else "")
            ) {
                accept(ContentType.Application.Json)
                header("Authorization", "Bearer ${spotifyRequest.token.access_token}")
            }
    }

    // @PUT
    // Requires scope: USER_MODIFY_PLAYBACK_STATE("user-modify-playback-state")
    suspend fun setRepeat(
        state: RepeatState,
        device_id: String? = null
    ) {
        spotifyRequest.client.put<String>(
            PLAYER_ENDPOINT
                .plus("/repeat")
                .plus("?state=${state.uri}")
                .plus(if (device_id != null) "&device_id=$device_id" else "")
        ) {
            accept(ContentType.Application.Json)
            header("Authorization", "Bearer ${spotifyRequest.token.access_token}")
        }
    }

    // @PUT
    // Requires scope: USER_MODIFY_PLAYBACK_STATE("user-modify-playback-state")
    suspend fun setVolume(
        volume_percent: Int,
        device_id: String? = null
    ) {
        spotifyRequest.client.put<String>(
            PLAYER_ENDPOINT
                .plus("/volume")
                .plus("?volume_percent=$volume_percent")
                .plus(if (device_id != null) "&device_id=$device_id" else "")
        ) {
            accept(ContentType.Application.Json)
            header("Authorization", "Bearer ${spotifyRequest.token.access_token}")
        }
    }


    // @POST
    // Requires scope: USER_MODIFY_PLAYBACK_STATE("user-modify-playback-state")
    suspend fun skipToNext(
        device_id: String? = null
    ) {
        spotifyRequest.client.put<String>(
            PLAYER_ENDPOINT
                .plus("/next")
                .plus(if (device_id != null) "&device_id=$device_id" else "")
        ) {
            accept(ContentType.Application.Json)
            header("Authorization", "Bearer ${spotifyRequest.token.access_token}")
        }
    }

    // @POST
    // Requires scope: USER_MODIFY_PLAYBACK_STATE("user-modify-playback-state")
    suspend fun skipToPrevious(
        device_id: String? = null
    ) {
        spotifyRequest.client.put<String>(
            PLAYER_ENDPOINT
                .plus("/previous")
                .plus(if (device_id != null) "&device_id=$device_id" else "")
        ) {
            accept(ContentType.Application.Json)
            header("Authorization", "Bearer ${spotifyRequest.token.access_token}")
        }
    }

    // TODO implement more complicated context options
    // @PUT
    // Requires scope: USER_MODIFY_PLAYBACK_STATE("user-modify-playback-state")
    suspend fun startResumePlayback(
        device_id: String? = null,
        context_uri: String? = null,
        vararg uris: String? = arrayOf(),
        offset: Any? = Any(),
        position_ms: Int? = 0
    ) {
        spotifyRequest.client.put<String>(
            PLAYER_ENDPOINT
                .plus("/play")
                .plus("?position_ms=$position_ms")
                .plus(if (device_id != null) "&device_id=$device_id" else "")
        ) {
            accept(ContentType.Application.Json)
            header("Authorization", "Bearer ${spotifyRequest.token.access_token}")
        }
    }

    // @PUT
    // Requires scope: USER_MODIFY_PLAYBACK_STATE("user-modify-playback-state")
    suspend fun toggleShuffle(
        state: Boolean,
        device_id: String? = null
    ) {
        spotifyRequest.client.put<String>(
            PLAYER_ENDPOINT
                .plus("/shuffle")
                .plus("?state=$state")
                .plus(if (device_id != null) "&device_id=$device_id" else "")
        ) {
            accept(ContentType.Application.Json)
            header("Authorization", "Bearer ${spotifyRequest.token.access_token}")
        }
    }

    // TODO implement
    // @PUT
    // Requires scope: USER_MODIFY_PLAYBACK_STATE("user-modify-playback-state")
    suspend fun transferPlayback(
        vararg device_ids: String,
        play: Boolean
    ) {
        spotifyRequest.client.put<String>(
            PLAYER_ENDPOINT
        ) {
            accept(ContentType.Application.Json)
            header("Authorization", "Bearer ${spotifyRequest.token.access_token}")

        }
    }

}