package emu.dev.spotify_swipe.utils

private const val BASE64_SET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"
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
        var raw = this
        repeat((1..pad.length).count()) { raw += 0.toChar() }
        return StringBuilder().apply {
            (raw.indices step 3).forEach {
                val n: Int = (0xFF.and(raw[it].toInt()) shl 16) +
                        (0xFF.and(raw[it + 1].toInt()) shl 8) +
                        0xFF.and(raw[it + 2].toInt())
                listOf<Int>(
                    (n shr 18) and 0x3F,
                    (n shr 12) and 0x3F,
                    (n shr 6) and 0x3F,
                    n and 0x3F
                ).forEach { append(BASE64_SET[it]) }
            }
        }.dropLast(pad.length)
            .toString() + pad
    }

/**
 * Decode a Base64 string.
 */
val String.base64decoded: String
    get() {
        if (this.length % 4 != 0) throw IllegalArgumentException("The string \"${this}\" does not comply with BASE64 length requirement.")
        val clean = this.replace(RX_BASE64_CLEANR, "").replace("=", "A")
        val padLen = this.filter { it == '=' }.length
        return StringBuilder().apply {
            (clean.indices step 4).forEach {
                val n: Int = (BASE64_SET.indexOf(clean[it]) shl 18) +
                        (BASE64_SET.indexOf(clean[it + 1]) shl 12) +
                        (BASE64_SET.indexOf(clean[it + 2]) shl 6) +
                        BASE64_SET.indexOf(clean[it + 3])
                listOf<Int>(
                    0xFF.and(n shr 16),
                    0xFF.and(n shr 8),
                    0xFF.and(n)
                ).forEach { append(it.toChar()) }
            }
        }.dropLast(padLen)
            .toString()
    }