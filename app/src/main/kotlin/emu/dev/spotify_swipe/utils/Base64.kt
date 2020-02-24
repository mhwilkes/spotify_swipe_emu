package emu.dev.spotify_swipe.utils

import io.ktor.utils.io.core.String

private const val BASE64_SET =
    "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"
private val RX_BASE64_CLEANR = "[^=" + BASE64_SET + "]".toRegex()

/**
 * Base64 encode a string.
 */
val String.base64encoded: String
    get() {
        val pad = when (this.length % 3) {
            1 -> "=="
            2 -> "="
            else -> ""
        }

        val raw = this + 0.toChar().toString().repeat(minOf(0, pad.lastIndex))

        return raw.chunkedSequence(3) {
            Triple(
                it[0].toInt(),
                it[1].toInt(),
                it[2].toInt()
            )
        }.map { (frst, scnd, thrd) ->
            (0xFF.and(frst) shl 16) +
                    (0xFF.and(scnd) shl 8) +
                    0xFF.and(thrd)
        }.map { n ->
            sequenceOf(
                (n shr 18) and 0x3F,
                (n shr 12) and 0x3F,
                (n shr 6) and 0x3F,
                n and 0x3F
            )
        }.flatten()
            .map { BASE64_SET[it] }
            .joinToString("")
            .dropLast(pad.length) + pad
    }

