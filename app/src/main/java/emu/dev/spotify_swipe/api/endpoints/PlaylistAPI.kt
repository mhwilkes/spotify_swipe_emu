package emu.dev.spotify_swipe.api.endpoints

import emu.dev.spotify_swipe.api.data.Image
import emu.dev.spotify_swipe.api.data.Page
import emu.dev.spotify_swipe.api.data.Playlist
import emu.dev.spotify_swipe.api.data.PlaylistSimple
import emu.dev.spotify_swipe.api.spotify.SpotifyRequest

// https://developer.spotify.com/documentation/general/guides/working-with-playlists/

class PlaylistAPI(private val spotifyRequest: SpotifyRequest) {

    // Scope required: PLAYLIST_MODIFY_PUBLIC("playlist-modify-public")
    // Scope required: PLAYLIST_MODIFY_PRIVATE("playlist-modify-private")
    suspend fun addTrackToPlaylist(
        playlist_id: String,
        vararg uris: String? = arrayOf(),
        position: Int? = null
    ) {

    }

    // Scope required: PLAYLIST_MODIFY_PUBLIC("playlist-modify-public")
    // Scope required: PLAYLIST_MODIFY_PRIVATE("playlist-modify-private")
    suspend fun changePlaylistDetails(
        playlist_id: String,
        name: String? = null,
        public: Boolean = false,
        collaborative: Boolean = false,
        description: String? = null
    ) {

    }

    // Scope required: PLAYLIST_MODIFY_PUBLIC("playlist-modify-public")
    // Scope required: PLAYLIST_MODIFY_PRIVATE("playlist-modify-private")
    suspend fun createPlaylist(
        user_id: String,
        name: String? = null,
        public: Boolean = false,
        collaborative: Boolean = false,
        description: String? = null
    ): Playlist {

    }

    // Scope required: PLAYLIST_READ_COLLABORATIVE("playlist-read-collaborative")
    // Requires scope: PLAYLIST_READ_PRIVATE("playlist-read-private")
    suspend fun getCurrentUserPlaylists(
        limit: Int = 20,
        offset: Int = 0
    ): Page<PlaylistSimple> {

    }

    // Scope required: PLAYLIST_READ_COLLABORATIVE("playlist-read-collaborative")
    // Requires scope: PLAYLIST_READ_PRIVATE("playlist-read-private")
    suspend fun getUserPlaylists(
        user_id: String,
        limit: Int = 20,
        offset: Int = 0
    ): Page<PlaylistSimple> {

    }

    suspend fun getPlaylistCoverImage(
        playlist_id: String
    ): Array<Image> {

    }

    suspend fun getPlaylist(
        playlist_id: String,
        vararg fields: String? = arrayOf(),
        market: String? = null
    ): Playlist {

    }

    suspend fun getPlaylistTracks(
        playlist_id: String,
        vararg fields: String? = arrayOf(),
        limit: Int = 100,
        offset: Int = 0,
        market: String? = null
    ) {

    }

    // Scope required: PLAYLIST_MODIFY_PUBLIC("playlist-modify-public")
    // Scope required: PLAYLIST_MODIFY_PRIVATE("playlist-modify-private")
    suspend fun removePlaylistTracks(
        playlist_id: String,
        vararg tracks: String
    ) {

    }

    // Scope required: PLAYLIST_MODIFY_PUBLIC("playlist-modify-public")
    // Scope required: PLAYLIST_MODIFY_PRIVATE("playlist-modify-private")
    suspend fun reorderPlaylistTracks(
        playlist_id: String,
        range_start: Int,
        range_length: Int? = null,
        insert_before: Int? = null,
        snapshot_id: String? = null
    ) {

    }

    // Scope required: PLAYLIST_MODIFY_PUBLIC("playlist-modify-public")
    // Scope required: PLAYLIST_MODIFY_PRIVATE("playlist-modify-private")
    suspend fun replacePlaylistTracks(
        playlist_id: String,
        vararg uris: String? = arrayOf()
    ) {

    }


    // Requires scope: UGC_IMAGE_UPLOAD("ugc-image-upload")
    // Scope required: PLAYLIST_MODIFY_PUBLIC("playlist-modify-public")
    // Scope required: PLAYLIST_MODIFY_PRIVATE("playlist-modify-private")
    suspend fun uploadCustomPlaylistCoverImage(
        playlist_id: String,
        base_64_image: String
    ) {

    }
}