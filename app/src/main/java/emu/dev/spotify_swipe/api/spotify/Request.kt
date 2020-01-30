package emu.dev.spotify_swipe.api.spotify

import io.ktor.client.HttpClient

abstract class Request<T> {
    abstract val client: HttpClient
    abstract val token: AuthToken
}