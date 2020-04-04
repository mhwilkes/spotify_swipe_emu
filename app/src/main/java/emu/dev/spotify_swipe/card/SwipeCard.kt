package emu.dev.spotify_swipe.card

import emu.dev.spotify_swipe.api.data.AlbumSimple
import emu.dev.spotify_swipe.api.data.ArtistSimple
import emu.dev.spotify_swipe.api.data.Image
import emu.dev.spotify_swipe.api.data.Track


class SwipeCard(track: Track) {

    val card_track: Track
    val song_name: String
    val song_artists: List<ArtistSimple>
    val song_cover: List<Image>
    var image_url: String
    val song_preview_url: String
    val song_ID: String
    val song_url: String
    val albumSimple: AlbumSimple

    /**
     * Takes Track Object and sets essential Data for Card Object
     *
     * @param track Track for Card
     */
    init {
        song_name = track.name
        song_artists = track.artists
        song_cover = track.album.images
        image_url = song_cover[0].url
        song_url = track.href
        card_track = track
        song_preview_url = track.preview_url
        song_ID = track.id
        albumSimple = track.album
    }
}