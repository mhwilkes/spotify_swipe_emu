package emu.dev.spotify_swipe.api.card

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import emu.dev.spotify_swipe.R

class CardStackAdapter(
    private var cards: List<Card> = emptyList()
) : RecyclerView.Adapter<CardStackAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.item_card, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val card = cards[position]
        holder.text.text = "${card.id}. ${card.description}"
        holder.description.text = card.description
        Glide.with(holder.image)
            .load(card.imageURL)
            .into(holder.image)
        holder.itemView.setOnClickListener { v ->
            Toast.makeText(v.context, card.text, Toast.LENGTH_SHORT).show()
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val text: TextView = view.findViewById(R.id.item_name)
        var description: TextView = view.findViewById(R.id.item_city)
        var image: ImageView = view.findViewById(R.id.item_image)
    }

    fun setCards(cards: List<Card>) {
        this.cards = cards
    }

    fun getCards(): List<Card> {
        return cards
    }

    override fun getItemCount(): Int {
        return cards.size
    }

}