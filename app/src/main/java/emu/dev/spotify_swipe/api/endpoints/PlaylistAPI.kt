package emu.dev.spotify_swipe.api.endpoints

import emu.dev.spotify_swipe.api.spotify.SpotifyRequest

// https://developer.spotify.com/documentation/general/guides/working-with-playlists/

class PlaylistAPI(private val spotifyRequest: SpotifyRequest) {

    // Scope required: PLAYLIST_MODIFY_PUBLIC("playlist-modify-public")
    // Scope required: PLAYLIST_MODIFY_PRIVATE("playlist-modify-private")
    suspend fun addTrackToPlaylist(

    ) {

    }

    // Scope required: PLAYLIST_MODIFY_PUBLIC("playlist-modify-public")
    // Scope required: PLAYLIST_MODIFY_PRIVATE("playlist-modify-private")
    suspend fun changePlaylistDetails(

    ) {

    }

    // Scope required: PLAYLIST_MODIFY_PUBLIC("playlist-modify-public")
    // Scope required: PLAYLIST_MODIFY_PRIVATE("playlist-modify-private")
    suspend fun createPlaylist(

    ) {

    }

    // Scope required: PLAYLIST_READ_COLLABORATIVE("playlist-read-collaborative")
    // Requires scope: PLAYLIST_READ_PRIVATE("playlist-read-private")
    suspend fun getCurrentUserPlaylists(

    ) {

    }

    // Scope required: PLAYLIST_READ_COLLABORATIVE("playlist-read-collaborative")
    // Requires scope: PLAYLIST_READ_PRIVATE("playlist-read-private")
    suspend fun getUserPlaylists(

    ) {

    }

    suspend fun getPlaylistCoverImage(

    ) {

    }

    suspend fun getPlaylist(

    ) {

    }

    suspend fun getPlaylistTracks(

    ) {

    }

    // Scope required: PLAYLIST_MODIFY_PUBLIC("playlist-modify-public")
    // Scope required: PLAYLIST_MODIFY_PRIVATE("playlist-modify-private")
    suspend fun removePlaylistTracks(

    ) {

    }
    // Scope required: PLAYLIST_MODIFY_PUBLIC("playlist-modify-public")
    // Scope required: PLAYLIST_MODIFY_PRIVATE("playlist-modify-private")
    suspend fun reorderPlaylistTracks(

    ) {

    }

    // Scope required: PLAYLIST_MODIFY_PUBLIC("playlist-modify-public")
    // Scope required: PLAYLIST_MODIFY_PRIVATE("playlist-modify-private")
    suspend fun replacePlaylistTracks(

    ) {

    }


    // Requires scope: UGC_IMAGE_UPLOAD("ugc-image-upload")
    // Scope required: PLAYLIST_MODIFY_PUBLIC("playlist-modify-public")
    // Scope required: PLAYLIST_MODIFY_PRIVATE("playlist-modify-private")
    suspend fun uploadCustomPlaylistCoverImage(

    ) {

    }
}