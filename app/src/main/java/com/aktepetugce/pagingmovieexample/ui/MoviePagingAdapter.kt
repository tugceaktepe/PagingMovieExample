package com.aktepetugce.pagingmovieexample.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.aktepetugce.pagingmovieexample.R
import com.aktepetugce.pagingmovieexample.data.model.Movie
import com.aktepetugce.pagingmovieexample.databinding.ItemMovieLayoutBinding
import com.aktepetugce.pagingmovieexample.util.FormatUtil
import com.bumptech.glide.Glide

class MoviePagingAdapter : PagingDataAdapter<Movie, MoviePagingAdapter.MovieViewHolder>(MovieDiffUtilCallback()) {
    class MovieViewHolder(private val binding: ItemMovieLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie){
            val context = binding.root.context
            binding.name.text = movie.title
            binding.popularity.text =
                context.getString(R.string.popularity, FormatUtil.formatTwoDecimalPlace(movie.popularity ?: 0.0))
            Glide.with(binding.root.context).load("https://image.tmdb.org/t/p/w300"+movie.posterUrl).into(binding.image)
        }
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)
        if (movie != null) {
            holder.bind(movie)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ItemMovieLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    class MovieDiffUtilCallback : DiffUtil.ItemCallback<Movie>(){
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.title == newItem.title
        }
        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }
    }

}