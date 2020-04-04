package emu.dev.spotify_swipe

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.GestureDetector
import android.view.GestureDetector.SimpleOnGestureListener
import android.view.MotionEvent
import android.view.View
import android.view.animation.LinearInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DiffUtil
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.yuyakaido.android.cardstackview.*
import emu.dev.spotify_swipe.api.data.Recommendation
import emu.dev.spotify_swipe.api.data.Track
import emu.dev.spotify_swipe.api.data.TrackSimple
import emu.dev.spotify_swipe.api.endpoints.BrowseAPI
import emu.dev.spotify_swipe.api.endpoints.TrackAPI
import emu.dev.spotify_swipe.api.spotify.SpotifyAPI
import emu.dev.spotify_swipe.api.spotify.SpotifyRequest
import emu.dev.spotify_swipe.api.spotify.Token
import emu.dev.spotify_swipe.card.*
import io.ktor.client.HttpClient
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


class RecommendationActivity : AppCompatActivity() {

    val client = HttpClient {
        install(JsonFeature) {
            serializer = GsonSerializer {
                serializeNulls()
                disableHtmlEscaping()
                setPrettyPrinting()
            }
        }
    }

    private val cardStackView by lazy { findViewById<CardStackView>(R.id.card_stack_view) }
    private val manager by lazy { CardStackLayoutManager(this, CardStackListener.DEFAULT) }

    private val adapter by lazy { SwipeCardStackAdapter() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recommendation)

        val like: FloatingActionButton = findViewById(R.id.like_button)
        val dislike: FloatingActionButton = findViewById(R.id.skip_button)
        val reload: FloatingActionButton = findViewById(R.id.rewind_button)

        setupCardStackView()

        cardStackView.setOnTouchListener(OnTouchListener())

        like.setOnClickListener { cardStackView.swipe() }

        dislike.setOnClickListener { cardStackView.swipe() }

        reload.setOnClickListener { paginate() }


    }

    private val gestureDetector = GestureDetector(
        baseContext,
        object : SimpleOnGestureListener() {
            override fun onSingleTapConfirmed(e: MotionEvent): Boolean {
                val intent = Intent(applicationContext, PopupCardActivity::class.java)
                val card: SwipeCard = adapter.getAtPosition(manager.topPosition)
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


    // Define all things needed for API interaction.


    private fun OnTouchListener(): View.OnTouchListener {
        return View.OnTouchListener { _, event ->
            gestureDetector.onTouchEvent(event)
        }
    }

    fun onCardDragging(direction: Direction, ratio: Float) {
        Log.d(
            "CardStackView",
            "onCardDragging: d = " + direction.name.toString() + ", r = " + ratio
        )
    }

    fun onCardSwiped(direction: Direction) {
        Log.d(
            "CardStackView",
            "onCardSwiped: p = " + manager.topPosition + ", d = " + direction
        )
        val card: SwipeCard = adapter.getAtPosition(manager.topPosition - 1) // Get the swiped card.

        if (manager.topPosition == adapter.itemCount) { // Get more cards if needed.
            paginate()
        }
    }

    fun onCardRewound() {
        Log.d("CardStackView", "onCardRewound: " + manager.topPosition)
    }

    fun onCardCanceled() {
        Log.d("CardStackView", "onCardCanceled:" + manager.topPosition)
    }

    private fun setupCardStackView() {
        initialize()
    }

    // Initialize the cards.
    private fun initialize() {
        manager.setStackFrom(StackFrom.None)
        manager.setVisibleCount(3)
        manager.setTranslationInterval(8.0f)
        manager.setScaleInterval(0.95f)
        manager.setSwipeThreshold(0.3f)
        manager.setMaxDegree(20.0f)
        manager.setDirections(listOf(Direction.Left, Direction.Right, Direction.Top))
        manager.setCanScrollHorizontal(true)
        manager.setCanScrollVertical(true)
        manager.setSwipeableMethod(SwipeableMethod.AutomaticAndManual)
        manager.setOverlayInterpolator(LinearInterpolator())
        cardStackView.layoutManager = manager
        adapter.setCards(createCards())
        cardStackView.adapter = adapter
        cardStackView.itemAnimator.apply {
            if (this is DefaultItemAnimator) {
                supportsChangeAnimations = false
            }
        }
    }

    // Fill the card stack.
    private fun paginate() {
        val old = adapter.getCards()
        val new: List<SwipeCard> = old.plus(createCards())
        val callback = SwipeCardDiffCallback(old, new)
        val result = DiffUtil.calculateDiff(callback)
        adapter.setCards(new)
        result.dispatchUpdatesTo(adapter)
    }


    private fun createCards(): List<SwipeCard> = runBlocking {
        val cards: MutableList<SwipeCard> = ArrayList()


        val mAccessToken: Token = SpotifyAPI(client).clientCredentialsRequest()
        val request = SpotifyRequest(client, mAccessToken)

        val recommendations: Recommendation =
            BrowseAPI(request).requestRecommendationFromSeed(
                limit = 5,
                seed_artists = null,
                seed_tracks = null,
                seed_genres = arrayOf("pop", "hip-hop", "alternative")
            )

        val tracks: List<TrackSimple> = recommendations.tracks


        val trackIds: List<String> = tracks.map { x -> x.id }

        println(trackIds)

        val trackFull: List<Track> =
            TrackAPI(request).requestMultipleTracks(trackIds)


        println(trackFull)

        for (t in trackFull)
            cards.add(SwipeCard(t))


        return@runBlocking cards
    }
}