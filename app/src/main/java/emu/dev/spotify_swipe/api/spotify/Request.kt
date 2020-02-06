package emu.dev.spotify_swipe.api.spotify

import io.ktor.client.HttpClient

data class Request(val client: HttpClient, val authToken: AuthToken) {
}