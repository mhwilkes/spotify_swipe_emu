package emu.dev.spotify_swipe.api.endpoints

import emu.dev.spotify_swipe.api.data.Device
import emu.dev.spotify_swipe.api.data.PlayingCurrently
import emu.dev.spotify_swipe.api.spotify.SpotifyRequest
import java.util.*

class PlayerAPI(private val spotifyRequest: SpotifyRequest) {


    // TODO might need streaming scope for playback. Spotify says its only for web playback sdk though

    // @POST
    suspend fun addToPlaybackQueue(
        uri: String,
        device_id: String? = null
    ) {

    }

    // @GET
    // Requires scope: USER_READ_PLAYBACK_STATE("user-read-playback-state")
    suspend fun getAvailableDevices(): Device {

    }

    // @GET
    // Requires scope: USER_READ_PLAYBACK_STATE("user-read-playback-state")
    suspend fun getInformationOnPlayback(
        market: String? = null
    ) {

    }

    // @GET
    // Requires scope: USER_READ_CURRENTLY_PLAYING("user-read-currently-playing")
    // Requires scope: USER_READ_RECENTLY_PLAYED("user-read-recently-played")
    suspend fun getCurrentUserRecentlyPlayed(
        limit: Int = 20,
        after: Int? = null,
        before: Int? = null
    ) {

    }

    // @GET
    // Requires scope: USER_READ_PLAYBACK_STATE("user-read-playback-state")
    suspend fun getCurrentUserCurrentPlaying(
        market: String? = null
    ): PlayingCurrently {

    }

    // @PUT
    // Requires scope: USER_MODIFY_PLAYBACK_STATE("user-modify-playback-state")
    suspend fun pausePlayback(
        device_id: String? = null
    ) {

    }

    // @PUT
    // Requires scope: USER_MODIFY_PLAYBACK_STATE("user-modify-playback-state")
    suspend fun seekPosition(
        position_ms: Int,
        device_id: String? = null
    ) {

    }

    // @PUT
    // Requires scope: USER_MODIFY_PLAYBACK_STATE("user-modify-playback-state")
    suspend fun setRepeat(
        state: String,
        device_id: String? = null
    ) {

    }

    // @PUT
    // Requires scope: USER_MODIFY_PLAYBACK_STATE("user-modify-playback-state")
    suspend fun setVolume(
        volume_percent: Int,
        device_id: String? = null
    ) {

    }


    // @POST
    // Requires scope: USER_MODIFY_PLAYBACK_STATE("user-modify-playback-state")
    suspend fun skipToNext(
        device_id: String? = null
    ) {

    }

    // @POST
    // Requires scope: USER_MODIFY_PLAYBACK_STATE("user-modify-playback-state")
    suspend fun skipToPrevious(
        device_id: String? = null
    ) {

    }

    // @PUT
    // Requires scope: USER_MODIFY_PLAYBACK_STATE("user-modify-playback-state")
    suspend fun startResumePlayback(
        device_id: String? = null,
        context_uri: String? = null,
        vararg uris: String?,
        offset: Any?,
        position_ms: Int?
    ) {

    }

    // @PUT
    // Requires scope: USER_MODIFY_PLAYBACK_STATE("user-modify-playback-state")
    suspend fun toggleShuffle(
        state: Boolean,
        device_id: String? = null
    ) {

    }

    // @PUT
    // Requires scope: USER_MODIFY_PLAYBACK_STATE("user-modify-playback-state")
    suspend fun transferPlayback(
        vararg device_ids: String,
        play: Boolean
    ) {

    }

}