package com.alexandersakva.featuresonglistlastfm.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alexandersakva.featuresongapi.Song
import com.alexandersakva.featuresonglistlastfm.R
import kotlinx.android.synthetic.main.lastfm_song_item.view.*


class SongsRecyclerAdapter : RecyclerView.Adapter<SongsRecyclerAdapter.SongHolder>() {

    var items: List<Song> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.lastfm_song_item, parent, false)
        return SongHolder(
            v
        )
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: SongHolder, position: Int) {
        holder.setData(items[position])
    }

    class SongHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvTitle = itemView.tvTitle
        private val tvArtist = itemView.tvArtist

        fun setData(song: Song) {
            tvTitle.text = song.title
            tvArtist.text = song.artist
        }
    }
}