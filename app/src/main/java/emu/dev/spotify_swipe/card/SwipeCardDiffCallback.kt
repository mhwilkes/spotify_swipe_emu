package emu.dev.spotify_swipe.card

import androidx.recyclerview.widget.DiffUtil

class SwipeCardDiffCallback(
    private val old: List<SwipeCard>,
    private val new: List<SwipeCard>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return old.size
    }

    override fun getNewListSize(): Int {
        return new.size
    }

    override fun areItemsTheSame(oldPosition: Int, newPosition: Int): Boolean {
        return old[oldPosition].song_ID == new[newPosition].song_ID
    }

    override fun areContentsTheSame(oldPosition: Int, newPosition: Int): Boolean {
        return old[oldPosition] == new[newPosition]
    }

}