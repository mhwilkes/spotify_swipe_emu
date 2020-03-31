package emu.dev.spotify_swipe

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.GestureDetector
import android.view.GestureDetector.SimpleOnGestureListener
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import com.yuyakaido.android.cardstackview.CardStackLayoutManager
import com.yuyakaido.android.cardstackview.CardStackView
import emu.dev.spotify_swipe.api.spotify.Token
import emu.dev.spotify_swipe.card.CardStackAdapter
import emu.dev.spotify_swipe.card.SwipeCard


class RecommendationActivity : AppCompatActivity() {
    private val manager: CardStackLayoutManager
    private val adapter: CardStackAdapter
    val gestureDetector = GestureDetector(
        baseContext,
        object : SimpleOnGestureListener() {
            override fun onSingleTapConfirmed(e: MotionEvent): Boolean {
                val intent = Intent(applicationContext, PopupCardActivity::class.java)
                val card: SwipeCard = adapter.getAtPosition(manager?.getTopPosition())
                intent.putExtra("song_name", card.song_name)
                intent.putExtra("artist_name", card.song_artists[0].name)
                intent.putExtra("album_name", card.albumSimple.name)
                intent.putExtra("preview_url", card.song_preview_url)
                intent.putExtra("song_url", card.song_url)
                intent.putExtra("album_cover", card.image_url)
                startActivity(intent)
                return true
            }
        })

    private val cardStackView: CardStackView? = null

    // Define all things needed for API interaction.
    private val mAccessToken: Token = intent.getStringExtra("responsecode")
    private val recommendations: Recommendations? = null
    private val sharedPreferences: SharedPreferences? = null
    private val trackBufferSize = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}