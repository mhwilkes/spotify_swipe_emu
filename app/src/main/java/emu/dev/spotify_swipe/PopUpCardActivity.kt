package emu.dev.spotify_swipe

import android.graphics.Typeface
import android.media.MediaPlayer
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
    private val player = MediaPlayer()

    // Define our views.
    private val song_name: TextView = findViewById(R.id.song_name)
    private val artist_name: TextView = findViewById(R.id.artist_name)
    private val album_name: TextView = findViewById(R.id.album_name)
    private val is_preview: TextView = findViewById(R.id.is_preview)
    private var album_cover: ImageView = findViewById(R.id.album_cover)
    private val mFloatingActionButton: FloatingMusicActionButton = findViewById(R.id.pause_play)
    private var seekPos = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popup_card)
        val intent = intent

        // Update text views with information related to the track.
        song_name.text = intent.getStringExtra("song_name")
        artist_name.text = intent.getStringExtra("artist_name")
        album_name.text = intent.getStringExtra("album_name")

        // Load the album cover.
        Glide.with(album_cover)
            .load(intent.getStringExtra("album_cover"))
            .into(album_cover)


        // Music player stuff.
        try {
            if (intent.getStringExtra("preview_url") != null) {
                player.setDataSource(intent.getStringExtra("preview_url"))
                player.prepareAsync()
                player.setVolume(.7f, .7f)
                player.setOnPreparedListener { player.start() }
            } else {
                is_preview.setTypeface(Typeface.DEFAULT_BOLD)
                is_preview.text = "No preview available!"
                mFloatingActionButton.setOnMusicFabClickListener(object :
                    FloatingMusicActionButton.OnMusicFabClickListener {
                    override fun onClick(view: View) {
                        if (player.isPlaying) {
                            player.pause()
                            seekPos = player.currentPosition
                            mFloatingActionButton.changeMode(FloatingMusicActionButton.Mode.PAUSE_TO_PLAY)
                        } else {
                            player.start()
                            player.seekTo(seekPos)
                            mFloatingActionButton.changeMode(FloatingMusicActionButton.Mode.PLAY_TO_PAUSE)
                        }
                    }

                })

            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (intent!!.getStringExtra("song_url") != null) {
            player.stop()
            player.release()
        }
    }
}