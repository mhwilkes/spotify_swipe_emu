package emu.dev.spotify_swipe.api.endpoints

import emu.dev.spotify_swipe.api.data.AudioAnalysis
import emu.dev.spotify_swipe.api.data.AudioFeature
import emu.dev.spotify_swipe.api.data.Track
import emu.dev.spotify_swipe.api.spotify.SpotifyRequest

class TrackAPI(private val spotifyRequest: SpotifyRequest) {

    private val TRACK_ENDPOINT =
        spotifyRequest.DEFAULT_ENDPOINT
            .plus("/tracks/")

    private val AUDIO_ANALYSIS_ENDPOINT =
        spotifyRequest.DEFAULT_ENDPOINT
            .plus("/audio-analysis/")

    private val AUDIO_FEATURES_ENDPOINT =
        spotifyRequest.DEFAULT_ENDPOINT
            .plus("/audio-features/")

    suspend fun requestTrackAudioAnalysis(

    ): AudioAnalysis {

    }

    suspend fun requestTrackAudioFeature(

    ): AudioFeature {

    }

    suspend fun requestMultipleTrackAudioFeature(

    ): List<AudioFeature> {

    }

    suspend fun requestMultipleTracks(): List<Track> {

    }

    suspend fun requestTrack(): Track {

    }
}