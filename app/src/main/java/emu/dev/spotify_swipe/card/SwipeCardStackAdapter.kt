package emu.dev.spotify_swipe.card

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import emu.dev.spotify_swipe.R

class SwipeCardStackAdapter(
    private var cards: List<SwipeCard> = emptyList()
) : RecyclerView.Adapter<SwipeCardStackAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.item_card, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val card = cards[position]
        holder.text.text = card.song_name
        holder.description.text = card.song_artists[0].name
        Glide.with(holder.image)
            .load(card.image_url)
            .into(holder.image)

    }

    fun getAtPosition(position: Int): SwipeCard {
        return cards[position]
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val text: TextView = view.findViewById(R.id.item_name)
        var description: TextView = view.findViewById(R.id.item_city)
        var image: ImageView = view.findViewById(R.id.item_image)
    }

    fun isEmpty(): Boolean {
        return cards.isEmpty()
    }

    fun setCards(cards: List<SwipeCard>) {
        this.cards = cards
    }

    fun getCards(): List<SwipeCard> {
        return cards
    }

    override fun getItemCount(): Int {
        return cards.size
    }

}