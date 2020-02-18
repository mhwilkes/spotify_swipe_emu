package emu.dev.spotify_swipe.api.spotify

import io.ktor.client.HttpClient

data class SpotifyRequest(val client: HttpClient, val spotifyAuthToken: SpotifyAuthToken) {
}