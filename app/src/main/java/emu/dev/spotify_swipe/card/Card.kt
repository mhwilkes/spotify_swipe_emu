package emu.dev.spotify_swipe.card

data class Card(
    val id: Long = counter++,
    val text: String,
    val imageURL: String,
    val description: String
) {
    companion object {
        private var counter = 0L
    }
}