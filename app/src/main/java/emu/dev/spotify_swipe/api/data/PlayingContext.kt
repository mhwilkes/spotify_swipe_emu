package emu.dev.spotify_swipe.api.data

data class PlayingContext(
    private val device: Device,
    private val repeat_state: String,
    private val shuffle_state: Boolean,
    private val context: Context?,
    private val timestamp: Int,
    private val progress_ms: Int,
    private val is_playing: Boolean,
    private val item: Track,
    private val currently_playing_type: String,
    private val actions: Actions
)

data class PlayingCurrently(
    private val context: Context?,
    private val timestamp: Int,
    private val progress_ms: Int,
    private val is_playing: Boolean,
    private val item: Track,
    private val currently_playing_type: String,
    private val actions: Actions

)