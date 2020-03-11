package emu.dev.spotify_swipe.api.data

data class Device(
    private val id: String,
    private val is_active: Boolean,
    private val is_private_session: Boolean,
    private val is_restricted: Boolean,
    private val name: String,
    private val type: DeviceType,
    private val volume_percent: Int?
    )

enum class DeviceType{
    Computer,
    Tablet,
    Smartphone,
    Speaker,
    TV,
    AVR,
    STB,
    AudioDongle,
    GameConsole,
    CastVideo,
    CastAudio,
    Automobile,
    Unknown
}