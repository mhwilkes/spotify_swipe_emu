package emu.dev.spotify_swipe.utils

import com.google.gson.internal.bind.util.ISO8601Utils
import java.util.*

class Timestamp(private val timestamp: Date) {
    val encode8601: String
        get() {
            return ISO8601Utils.format(timestamp)
        }
}