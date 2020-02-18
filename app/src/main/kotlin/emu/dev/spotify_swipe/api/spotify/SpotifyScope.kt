package emu.dev.spotify_swipe.api.spotify

/**
 * Scopes required for SpotifyAPI
 */
enum class SpotifyScope(val uri: String) {

    /*
    ---------- Images ----------
     */

    /**
     * Write access to user-provided images.
     *
     * **Visible to Users** Upload images to Spotify on your behalf.
     *
     * [Upload a Custom Playlist Cover Image](https://developer.spotify.com/documentation/web-api/reference/playlists/upload-custom-playlist-cover/)
     */
    UGC_IMAGE_UPLOAD("ugc-image-upload"),

    /*
    ---------- Spotify Connect ----------
     */

    /**
     * Read access to a user’s player state.
     *
     * **Visible to Users** Read your currently playing track and Spotify Connect devices information.
     *
     * [Get a User's Available Devices](https://developer.spotify.com/documentation/web-api/reference/player/get-a-users-available-devices/)
     * [Get Information About The User's Current Playback](https://developer.spotify.com/documentation/web-api/reference/player/get-information-about-the-users-current-playback/)
     * [Get the User's Currently Playing Track](https://developer.spotify.com/documentation/web-api/reference/player/get-the-users-currently-playing-track/)
     */
    USER_READ_PLAYBACK_STATE("user-read-playback-state"),

    /**
     * Write access to a user’s playback state
     *
     * **Visible to Users** Control playback on your Spotify clients and Spotify Connect devices.
     *
     * [Pause a User's Playback](https://developer.spotify.com/documentation/web-api/reference/player/pause-a-users-playback/)
     * [Seek To Position In Currently Playing Track](https://developer.spotify.com/documentation/web-api/reference/player/seek-to-position-in-currently-playing-track/)
     * [Set Repeat Mode On User’s Playback](https://developer.spotify.com/documentation/web-api/reference/player/set-repeat-mode-on-users-playback/)
     * [Set Volume For User's Playback](https://developer.spotify.com/documentation/web-api/reference/player/set-volume-for-users-playback/)
     * [Skip User’s Playback To Next Track](https://developer.spotify.com/documentation/web-api/reference/player/skip-users-playback-to-next-track/)
     * [Skip User’s Playback To Previous Track](https://developer.spotify.com/documentation/web-api/reference/player/skip-users-playback-to-previous-track/)
     * [Start/Resume a User's Playback](https://developer.spotify.com/documentation/web-api/reference/player/start-a-users-playback/)
     * [Toggle Shuffle For User’s Playback](https://developer.spotify.com/documentation/web-api/reference/player/toggle-shuffle-for-users-playback/)
     * [Transfer a User's Playback](https://developer.spotify.com/documentation/web-api/reference/player/transfer-a-users-playback/)
     */
    USER_MODIFY_PLAYBACK_STATE("user-modify-playback-state"),

    /**
     * Read access to a user’s currently playing track
     *
     * **Visible to Users** Read your currently playing track
     *
     * [Read your currently playing track](https://developer.spotify.com/documentation/web-api/reference/player/get-the-users-currently-playing-track/)
     */
    USER_READ_CURRENTLY_PLAYING("user-read-currently-playing"),

    /*
   ---------- Playback ----------
    */

    /**
     * Control playback of a Spotify track. This scope is currently available to the Web Playback SDK.
     * The user must have a Spotify Premium account.
     *
     * **Visible to Users** Play music and control playback on your other devices.
     *
     * [Play music and control playback on your other devices.](https://developer.spotify.com/documentation/web-playback-sdk/)
     */
    STREAMING("streaming"),

    /**
     * Remote control playback of Spotify. This scope is currently available to Spotify iOS and Android SDKs.
     *
     * **Visible to Users** Communicate with the Spotify app on your device.
     *
     * [iOS SDK](https://developer.spotify.com/documentation/ios/)
     * [Android SDK](https://developer.spotify.com/documentation/android/)
     */
    APP_REMOTE_CONTROL("app-remote-control"),

    /*
   ---------- Users ----------
    */

    /**
     * Read access to user’s email address.
     *
     * **Visible to Users** Get your real email address.
     *
     * [Get your real email address.](https://developer.spotify.com/documentation/web-api/reference/users-profile/get-current-users-profile/)
     */
    USER_READ_EMAIL("user-read-email"),

    /**
     * Read access to user’s subscription details (type of user account).
     *
     * **Visible to Users** Access your subscription details.
     *
     * [Search for an Item](https://developer.spotify.com/documentation/web-api/reference/search/search/)
     * [Get Current User's Profile](https://developer.spotify.com/documentation/web-api/reference/users-profile/get-current-users-profile/)
     */
    USER_READ_PRIVATE("user-read-private"),

    /*
   ---------- Playlist ----------
    */

    /**
     * Include collaborative playlists when requesting a user's playlists.
     *
     * **Visible to Users** Access your collaborative playlists.
     *
     * [Get a List of Current User's Playlists](https://developer.spotify.com/documentation/web-api/reference/playlists/get-a-list-of-current-users-playlists/)
     * [Get a List of a User's Playlists](https://developer.spotify.com/documentation/web-api/reference/playlists/get-list-users-playlists/)
     */
    PLAYLIST_READ_COLLABORATIVE("playlist-read-collaborative"),

    /**
     * Write access to a user's public playlists.
     *
     * **Visible to Users** Manage your public playlists.
     *
     * [Follow a Playlist](https://developer.spotify.com/documentation/web-api/reference/follow/follow-playlist/)
     * [Unfollow a Playlist](https://developer.spotify.com/documentation/web-api/reference/follow/unfollow-playlist/)
     * [Add Tracks to a Playlist](https://developer.spotify.com/documentation/web-api/reference/playlists/add-tracks-to-playlist/)
     * [Change a Playlist's Details]Change a Playlist's Details](https://developer.spotify.com/documentation/web-api/reference/playlists/change-playlist-details/)
     * [Create a Playlist](https://developer.spotify.com/documentation/web-api/reference/playlists/create-playlist/)
     * [Remove Tracks from a Playlist](https://developer.spotify.com/documentation/web-api/reference/playlists/remove-tracks-playlist/)
     * [Reorder a Playlist's Tracks](https://developer.spotify.com/documentation/web-api/reference/playlists/reorder-playlists-tracks/)
     * [Replace a Playlist's Tracks](https://developer.spotify.com/documentation/web-api/reference/playlists/replace-playlists-tracks/)
     * [Upload a Custom Playlist Cover Image](https://developer.spotify.com/documentation/web-api/reference/playlists/upload-custom-playlist-cover/)
     */
    PLAYLIST_MODIFY_PUBLIC("playlist-modify-public"),

    /**
     * Read access to user's private playlists.
     *
     * **Visible to Users** Access your private playlists.
     *
     * [Check if Users Follow a Playlist](https://developer.spotify.com/documentation/web-api/reference/follow/check-user-following-playlist/)
     * [Get a List of Current User's Playlists](https://developer.spotify.com/documentation/web-api/reference/playlists/get-a-list-of-current-users-playlists/)
     * [Get a List of a User's Playlists](https://developer.spotify.com/documentation/web-api/reference/playlists/get-list-users-playlists/)
     */
    PLAYLIST_READ_PRIVATE("playlist-read-private"),

    /**
     * Write access to a user's private playlists.
     *
     * **Visible to Users** Manage your private playlists.
     *
     * [Follow a Playlist](https://developer.spotify.com/documentation/web-api/reference/follow/follow-playlist/)
     * [Unfollow a Playlist](https://developer.spotify.com/documentation/web-api/reference/follow/unfollow-playlist/)
     * [Add Tracks to a Playlist](https://developer.spotify.com/documentation/web-api/reference/playlists/add-tracks-to-playlist/)
     * [Change a Playlist's Details](https://developer.spotify.com/documentation/web-api/reference/playlists/change-playlist-details/)
     * [Create a Playlist](https://developer.spotify.com/documentation/web-api/reference/playlists/create-playlist/)
     * [Remove Tracks from a Playlist](https://developer.spotify.com/documentation/web-api/reference/playlists/remove-tracks-playlist/)
     * [Reorder a Playlist's Tracks](https://developer.spotify.com/documentation/web-api/reference/playlists/reorder-playlists-tracks/)
     * [Replace a Playlist's Tracks](https://developer.spotify.com/documentation/web-api/reference/playlists/replace-playlists-tracks/)
     * [Upload a Custom Playlist Cover Image](https://developer.spotify.com/documentation/web-api/reference/playlists/upload-custom-playlist-cover/)
     */
    PLAYLIST_MODIFY_PRIVATE("playlist-modify-private"),

    /*
   ---------- Library ----------
    */

    /**
     * Write/delete access to a user's "Your Music" library.
     *
     * **Visible to Users** Manage your saved tracks and albums.
     *
     * [](https://developer.spotify.com/documentation/web-api/reference/library/remove-albums-user/)
     * [](https://developer.spotify.com/documentation/web-api/reference/library/remove-tracks-user/)
     * [](https://developer.spotify.com/documentation/web-api/reference/library/save-albums-user/)
     * [](https://developer.spotify.com/documentation/web-api/reference/library/save-tracks-user/)
     */
    USER_LIBRARY_MODIFY("user-library-modify"),

    /**
     *  Read access to a user's "Your Music" library.
     *
     * **Visible to Users** Access your saved tracks and albums
     *
     * [Check User's Saved Albums](https://developer.spotify.com/documentation/web-api/reference/library/check-users-saved-albums/)
     * [Check User's Saved Tracks](https://developer.spotify.com/documentation/web-api/reference/library/check-users-saved-tracks/)
     * [Get Current User's Saved Albums](https://developer.spotify.com/documentation/web-api/reference/library/get-users-saved-albums/)
     * [Get a User's Saved Tracks](https://developer.spotify.com/documentation/web-api/reference/library/get-users-saved-tracks/)
     */
    USER_LIBRARY_READ("user-library-read"),

    /*
   ---------- Listening History ----------
    */

    /**
     * Read access to a user's top artists and tracks.
     *
     * **Visible to Users** Read your top artists and tracks.
     *
     * [Get a User's Top Artists and Tracks](https://developer.spotify.com/documentation/web-api/reference/personalization/get-users-top-artists-and-tracks/)
     */
    USER_TOP_READ("user-top-read"),

    /**
     * Read access to a user’s recently played tracks.
     *
     * **Visible to Users** Access your recently played items.
     *
     * [Get Current User's Recently Played Tracks](https://developer.spotify.com/documentation/web-api/reference/player/get-recently-played/)
     */
    USER_READ_RECENTLY_PLAYED("user-read-recently-played"),

    /*
   ---------- Follow ----------
    */

    /**
     * Read access to the list of artists and other users that the user follows.
     *
     * **Visible to Users** Access your followers and who you are following.
     *
     * [Check if Current User Follows Artists or Users](https://developer.spotify.com/documentation/web-api/reference/follow/check-current-user-follows/)
     * [Get User's Followed Artists](https://developer.spotify.com/documentation/web-api/reference/follow/get-followed/)
     */
    USER_FOLLOW_READ("user-follow-read"),

    /**
     * Write/delete access to the list of artists and other users that the user follows.
     *
     * **Visible to Users** Manage who you are following.
     *
     * [Follow Artists or Users](https://developer.spotify.com/documentation/web-api/reference/follow/follow-artists-users/)
     * [Unfollow Artists or Users](https://developer.spotify.com/documentation/web-api/reference/follow/unfollow-artists-users/)
     */
    USER_FOLLOW_MODIFY("user-follow_modify")
}