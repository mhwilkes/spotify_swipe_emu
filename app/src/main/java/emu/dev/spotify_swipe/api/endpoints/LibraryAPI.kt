package emu.dev.spotify_swipe.api.endpoints

import emu.dev.spotify_swipe.api.spotify.SpotifyRequest

class LibraryAPI(private val spotifyRequest: SpotifyRequest) {

    // Requires scope: USER_LIBRARY_READ("user-library-read")
    suspend fun checkSavedAlbum(

    ): Boolean {

    }

    // Requires scope: USER_LIBRARY_READ("user-library-read")
    suspend fun checkSavedTrack(

    ): Boolean {

    }

    // Requires scope: USER_LIBRARY_READ("user-library-read")
    suspend fun getSavedAlbum(

    ) {

    }

    // Requires scope: USER_LIBRARY_READ("user-library-read")
    suspend fun getSavedTrack(

    ) {

    }

    // Requires scope: USER_LIBRARY_MODIFY("user-library-modify")
    suspend fun removeAlbumsForUser(

    ) {

    }

    // Requires scope: USER_LIBRARY_MODIFY("user-library-modify")
    suspend fun removeTrackForUser(

    ) {

    }

    // Requires scope: USER_LIBRARY_MODIFY("user-library-modify")
    suspend fun saveAlbumForUser(

    ) {

    }

    // Requires scope: USER_LIBRARY_MODIFY("user-library-modify")
    suspend fun saveTrackForUser(

    ) {

    }

}