package emu.dev.spotify_swipe.api.endpoints

import com.google.gson.Gson
import emu.dev.spotify_swipe.api.data.*
import emu.dev.spotify_swipe.api.spotify.SpotifyRequest
import io.ktor.client.request.accept
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.http.ContentType

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
        id: String
    ): AudioAnalysis {
        val response =
            spotifyRequest.client.get<String>(
                AUDIO_ANALYSIS_ENDPOINT
                    .plus(id)
            ) {
                accept(ContentType.Application.Json)
                header("Authorization", "Bearer ${spotifyRequest.token.access_token}")
            }

        return Gson().fromJson(response, AudioAnalysis::class.java)
    }

    suspend fun requestTrackAudioFeature(
        id: String
    ): AudioFeature {
        val response =
            spotifyRequest.client.get<String>(
                AUDIO_FEATURES_ENDPOINT
                    .plus(id)
            ) {
                accept(ContentType.Application.Json)
                header("Authorization", "Bearer ${spotifyRequest.token.access_token}")
            }

        return Gson().fromJson(response, AudioFeature::class.java)
    }

    suspend fun requestMultipleTrackAudioFeature(
        vararg ids: String
    ): List<AudioFeature> {
        val response =
            spotifyRequest.client.get<String>(
                AUDIO_FEATURES_ENDPOINT
                    .plus("?ids=")
                    .plus(ids.joinToString(limit = 100, separator = "%2C"))
            ) {
                accept(ContentType.Application.Json)
                header("Authorization", "Bearer ${spotifyRequest.token.access_token}")
            }

        return Gson().fromJson(response, AudioFeatures::class.java).asList()
    }

    suspend fun requestMultipleTracks(
        vararg ids: String,
        market: String? = null
    ): List<Track> {
        val response =
            spotifyRequest.client.get<String>(
                TRACK_ENDPOINT
                    .plus("?ids=")
                    .plus(ids.joinToString(limit = 20, separator = "%2C"))
                    .plus(if (market != null) "&market=$market" else "")
            ) {
                accept(ContentType.Application.Json)
                header("Authorization", "Bearer ${spotifyRequest.token.access_token}")
            }

        return Gson().fromJson(response, Tracks::class.java).asList()
    }

    suspend fun requestTrack(
        id: String,
        market: String? = null
    ): Track {
        val response =
            spotifyRequest.client.get<String>(
                TRACK_ENDPOINT
                    .plus(id)
            ) {
                accept(ContentType.Application.Json)
                header("Authorization", "Bearer ${spotifyRequest.token.access_token}")
            }

        return Gson().fromJson(response, Track::class.java)
    }
}