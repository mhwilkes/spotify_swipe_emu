package emu.dev.spotify_swipe

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.spotify.sdk.android.auth.AuthorizationClient
import com.spotify.sdk.android.auth.AuthorizationRequest
import com.spotify.sdk.android.auth.AuthorizationRequest.Builder
import com.spotify.sdk.android.auth.AuthorizationResponse
import com.spotify.sdk.android.auth.LoginActivity.REQUEST_CODE
import emu.dev.spotify_swipe.api.spotify.SpotifyScope
/*
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()

        val button = findViewById<Button>(R.id.login)
        val text = findViewById<TextView>(R.id.info)
        button.visibility = View.INVISIBLE

        val pm = packageManager
        val isSpotifyInstalled = try {
            pm.getPackageInfo("com.spotify.music", 0)
            true
        } catch (err: PackageManager.NameNotFoundException) {
            Log.e(err.message, "Spotify Not Installed")
            false
        }

        if (!isSpotifyInstalled) {
            text.text = "This app requires Spotify to be installed on your device"
            button.text = "Download Spotify"
            button.visibility = View.VISIBLE
            button.setOnClickListener(this::onDownloadClick)
        } else {
            text.text = "This app requires you to log into Spotify"
            button.text = "Login Now"
            button.visibility = View.VISIBLE
            button.setOnClickListener(this::onLoginClick)
        }
    }

    private fun onLoginClick(view: View) {
        val REQUEST_CODE = 1138
        val REDIRECT_URI = "spotify-swipe-app-212985://callback"

        val builder = Builder(
            "3a36e58be96b4c4ab8829fb5702d05a5",
            AuthorizationResponse.Type.CODE,
            REDIRECT_URI
        )
        builder.setScopes(arrayOf(SpotifyScope.APP_REMOTE_CONTROL.uri))
        builder.setShowDialog(true)
        val request: AuthorizationRequest = builder.build()
        AuthorizationClient.clearCookies(this)
        AuthorizationClient.openLoginActivity(this, REQUEST_CODE, request)
    }

    private fun onDownloadClick(view: View) {
        AuthorizationClient.openDownloadSpotifyActivity(this)
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        intent: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, intent)

        // Check if result comes from the correct activity
        if (requestCode == REQUEST_CODE) {
            val response: AuthorizationResponse =
                AuthorizationClient.getResponse(resultCode, intent)

            when (response.type) {
                AuthorizationResponse.Type.CODE -> {
                    Log.i("Response Code: ", response.code)
                    intent?.putExtra("responsecode", response.code)
                    val new_intent = Intent(this, TutorialActivity::class.java)
                    startActivity(new_intent)
                }
                AuthorizationResponse.Type.ERROR -> {
                    Log.e("Response Error: ", response.error)
                }
                else -> Log.e("Auth Bound", "Auth did not respond as expected")
            }
        }
    }

}
*/