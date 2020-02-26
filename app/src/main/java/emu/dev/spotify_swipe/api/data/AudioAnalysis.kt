package emu.dev.spotify_swipe.api.data

data class AudioAnalysis(
    val bars: List<TimeInterval>,
    val beats: List<TimeInterval>,
    val sections: List<Section>,
    val segments: List<Segment>,
    val tatums: List<TimeInterval>
)

data class TimeInterval(
    val start: Float,
    val duration: Float,
    val confidence: Float
)

data class Section(
    val start: Float,
    val duration: Float,
    val confidence: Float,
    val loudness: Float,
    val tempo: Float,
    val tempo_confidence: Float,
    val key: Int,
    val key_confidence: Float,
    val mode: Int,
    val mode_confidence: Float,
    val time_signature: Int,
    val time_signature_confidence: Float
)

data class Segment(
    val start: Float,
    val duration: Float,
    val confidence: Float,
    val loudness_start: Float,
    val loudness_max: Float,
    val loudness_max_time: Float,
    val loudness_end: Float,
    val pitches: List<Float>,
    val timbre: List<Float>
)