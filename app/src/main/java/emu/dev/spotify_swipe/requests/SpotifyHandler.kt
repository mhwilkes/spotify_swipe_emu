package emu.dev.spotify_swipe.requests

import io.*
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

class SpotifyHandler {
    suspend fun parralelRequests() = coroutineScope<Unit> {
        val client = HttpClient()

        // Start two requests asynchronously.
        val firstRequest = async { client.get<ByteArray>("https://127.0.0.1:8080/a") }
        val secondRequest = async { client.get<ByteArray>("https://127.0.0.1:8080/b") }

        // Get the request contents without blocking threads, but suspending the function until both
        // requests are done.
        val bytes1 = firstRequest.await() // Suspension point.
        val bytes2 = secondRequest.await() // Suspension point.

        client.close()
    }
}