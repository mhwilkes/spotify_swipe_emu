package emu.dev.spotify_swipe.api.endpoints

import emu.dev.spotify_swipe.api.spotify.SpotifyRequest

class PlayerAPI(private val spotifyRequest: SpotifyRequest) {


    // TODO might need streaming scope for playback. Spotify says its only for web playback sdk though

    suspend fun addToPlaybackQueue(

    ) {

    }

    // Requires scope: USER_READ_PLAYBACK_STATE("user-read-playback-state")
    suspend fun getAvailableDevices(

    ) {

    }

    // Requires scope: USER_READ_PLAYBACK_STATE("user-read-playback-state")
    suspend fun getInformationOnPlayback(

    ) {

    }

    // Requires scope: USER_READ_CURRENTLY_PLAYING("user-read-currently-playing")
    // Requires scope: USER_READ_RECENTLY_PLAYED("user-read-recently-played")
    suspend fun getCurrentUserRecentlyPlayed(

    ) {

    }

    // Requires scope: USER_READ_PLAYBACK_STATE("user-read-playback-state")
    suspend fun getCurrentUserCurrentPlaying(

    ) {

    }


    // Requires scope: USER_MODIFY_PLAYBACK_STATE("user-modify-playback-state")
    suspend fun pausePlayback(
    ) {

    }

    // Requires scope: USER_MODIFY_PLAYBACK_STATE("user-modify-playback-state")
    suspend fun seekPosition(

    ) {

    }

    // Requires scope: USER_MODIFY_PLAYBACK_STATE("user-modify-playback-state")
    suspend fun setRepeat(

    ) {

    }

    // Requires scope: USER_MODIFY_PLAYBACK_STATE("user-modify-playback-state")
    suspend fun setVolume(

    ) {

    }

    // Requires scope: USER_MODIFY_PLAYBACK_STATE("user-modify-playback-state")
    suspend fun skipToNext(

    ) {

    }

    // Requires scope: USER_MODIFY_PLAYBACK_STATE("user-modify-playback-state")
    suspend fun skipToPrevious(

    ) {

    }

    // Requires scope: USER_MODIFY_PLAYBACK_STATE("user-modify-playback-state")
    suspend fun startResumePlayback(

    ) {

    }

    // Requires scope: USER_MODIFY_PLAYBACK_STATE("user-modify-playback-state")
    suspend fun toggleShuffle(

    ) {

    }

    // Requires scope: USER_MODIFY_PLAYBACK_STATE("user-modify-playback-state")
    suspend fun transferPlayback(

    ) {

    }

}