package emu.dev.spotify_swipe

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.GestureDetector
import android.view.GestureDetector.SimpleOnGestureListener
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
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
import emu.dev.spotify_swipe.card.SwipeCard
import emu.dev.spotify_swipe.card.SwipeCardDiffCallback
import emu.dev.spotify_swipe.card.SwipeCardStackAdapter
import io.ktor.client.HttpClient
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import kotlinx.coroutines.*


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

    private var manager: CardStackLayoutManager =
        CardStackLayoutManager(this, CardStackListener.DEFAULT)
    private var adapter: SwipeCardStackAdapter =
        SwipeCardStackAdapter()

    private var like: FloatingActionButton = findViewById(R.id.like_button)
    private var dislike: FloatingActionButton = findViewById(R.id.skip_button)
    private var reload: FloatingActionButton = findViewById(R.id.rewind_button)
    private var cardStackView: CardStackView = findViewById(R.id.card_stack_view)

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recommendation)

        setupCardStackView()
        cardStackView!!.setOnTouchListener(OnTouchListener())

        like.setOnClickListener { cardStackView!!.swipe() }

        dislike.setOnClickListener { cardStackView!!.swipe() }

        reload.setOnClickListener { paginate() }


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
        manager = CardStackLayoutManager(applicationContext, CardStackListener.DEFAULT)
        manager.setStackFrom(StackFrom.Top)
        manager.setVisibleCount(3)
        manager.setTranslationInterval(8.0f)
        manager.setScaleInterval(0.95f)
        manager.setSwipeThreshold(0.3f)
        manager.setMaxDegree(20.0f)
        manager.setDirections(Direction.HORIZONTAL)
        manager.setCanScrollHorizontal(true)
        manager.setCanScrollVertical(true)
        manager.setTranslationInterval(8f)

        cardStackView = findViewById(R.id.card_stack_view)
        cardStackView!!.layoutManager = manager
        cardStackView!!.adapter = adapter
    }

    // Fill the card stack.
    private fun paginate() {
        val oldList: List<SwipeCard> = adapter.getCards()
        val newList: List<SwipeCard> = object : ArrayList<SwipeCard>() {
            init {
                addAll(createCards())
            }
        }
        val callback = SwipeCardDiffCallback(oldList, newList)
        val result = DiffUtil.calculateDiff(callback)
        adapter.setCards(newList)
        result.dispatchUpdatesTo(adapter)
    }


    private fun createCards(): List<SwipeCard> {
        val cards: MutableList<SwipeCard> = ArrayList()
        GlobalScope.launch {


            val mAccessToken: Token = SpotifyAPI(client).clientCredentialsRequest()
            val request = SpotifyRequest(client, mAccessToken)

            val recommendations: Recommendation =
                BrowseAPI(request).requestRecommendationFromSeed(
                    seed_artists = null,
                    seed_tracks = null,
                    seed_genres = arrayOf("pop", "hip-hop", "alternative")
                )
            Log.d("Recommendation object", recommendations.toString())

            for (t: TrackSimple in recommendations.tracks!!) {
                Log.d("Card", SwipeCard(TrackAPI(request).requestTrack(t.id)).toString())
                cards.add(SwipeCard(TrackAPI(request).requestTrack(t.id)))
            }


        }

        return cards
    }
}