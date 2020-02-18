package emu.dev.spotify_swipe.api.spotify

data class SpotifyAuthToken(
    val accessToken: String,
    val refreshToken: String
) {

}