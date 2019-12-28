package com.example.kotlinapplication.ui.page.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinapplication.R
import com.example.kotlinapplication.data.model.MovieItem

class ListMovieAdapter(
    val listener: ItemListener
) :
    RecyclerView.Adapter<MovieViewHolder>() {

    private val items = arrayListOf<MovieItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_movie_list,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(items[position], listener)
    }

    fun addAllItems(ListItems: List<MovieItem>) {
        items.clear()
        items.addAll(ListItems)
        notifyDataSetChanged()
    }

    interface ItemListener {
        fun onMovieItemClick(movieItems: MovieItem)
    }


}