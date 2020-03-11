package emu.dev.spotify_swipe.api.endpoints

import emu.dev.spotify_swipe.api.data.Album
import emu.dev.spotify_swipe.api.data.Page
import emu.dev.spotify_swipe.api.data.SavedAlbum
import emu.dev.spotify_swipe.api.data.SavedTrack
import emu.dev.spotify_swipe.api.spotify.SpotifyRequest

class LibraryAPI(private val spotifyRequest: SpotifyRequest) {

    // @GET
    // Requires scope: USER_LIBRARY_READ("user-library-read")
    suspend fun checkSavedAlbum(
        vararg ids: String
    ): Boolean {

    }

    // @GET
    // Requires scope: USER_LIBRARY_READ("user-library-read")
    suspend fun checkSavedTrack(
        vararg ids: String
    ): Boolean {

    }

    // @GET
    // Requires scope: USER_LIBRARY_READ("user-library-read")
    suspend fun getSavedAlbum(
        limit: Int = 20,
        offset: Int = 0,
        market: String? = null
    ): Page<SavedAlbum> {

    }

    // @GET
    // Requires scope: USER_LIBRARY_READ("user-library-read")
    suspend fun getSavedTrack(
        limit: Int = 20,
        offset: Int = 0,
        market: String? = null
    ): Page<SavedTrack> {

    }

    // @DELETE
    // Requires scope: USER_LIBRARY_MODIFY("user-library-modify")
    suspend fun removeAlbumsForUser(
        vararg ids: String
    ) {

    }

    // @DELETE
    // Requires scope: USER_LIBRARY_MODIFY("user-library-modify")
    suspend fun removeTrackForUser(
        vararg ids: String
    ) {

    }

    // @PUT
    // Requires scope: USER_LIBRARY_MODIFY("user-library-modify")
    suspend fun saveAlbumForUser(
        vararg ids: String
    ) {

    }

    // @PUT
    // Requires scope: USER_LIBRARY_MODIFY("user-library-modify")
    suspend fun saveTrackForUser(
        vararg ids: String
    ) {

    }

}