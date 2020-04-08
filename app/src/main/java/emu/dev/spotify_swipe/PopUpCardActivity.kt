package emu.dev.spotify_swipe

import android.content.Intent
import android.graphics.Typeface
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import be.rijckaert.tim.animatedvector.FloatingMusicActionButton
import com.bumptech.glide.Glide
import io.ktor.utils.io.errors.IOException


class PopupCardActivity : AppCompatActivity() {
    // Media player to play song samples.
    private var player = MediaPlayer()

    // Define our views.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popup_card)
        val intent = intent

        val song_name: TextView = findViewById(R.id.song_name)
        val artist_name: TextView = findViewById(R.id.artist_name)
        val album_name: TextView = findViewById(R.id.album_name)
        val is_preview: TextView = findViewById(R.id.is_preview)
        val album_cover: ImageView = findViewById(R.id.album_cover)
        val mFloatingActionButton: FloatingMusicActionButton = findViewById(R.id.pause_play)
        var seekPos = 0

        // Update text views with information related to the track.
        song_name.text = intent.getStringExtra("song_name")
        artist_name.text = intent.getStringExtra("artist_name")
        album_name.text = intent.getStringExtra("album_name")

        // Load the album cover.
        Glide.with(album_cover)
            .load(intent.getStringExtra("album_cover"))
            .into(album_cover)

        mFloatingActionButton.setOnMusicFabClickListener(object :
            FloatingMusicActionButton.OnMusicFabClickListener {
            override fun onClick(view: View) {
                FloatingMusicActionButton.Mode.PLAY_TO_PAUSE
                val callIntent: Intent = Uri.parse(intent.getStringExtra("uri")).let { uri ->
                    Intent(Intent.ACTION_VIEW, uri)
                }
                startActivity(callIntent)
            }
        })

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        FloatingMusicActionButton.Mode.PAUSE_TO_PLAY
    }

    override fun onDestroy() {
        super.onDestroy()
        if (intent!!.getStringExtra("song_url") != null) {
            player.stop()
            player.release()
        }
    }
}