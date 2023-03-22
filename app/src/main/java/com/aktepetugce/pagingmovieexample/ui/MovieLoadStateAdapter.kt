package com.aktepetugce.pagingmovieexample.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aktepetugce.pagingmovieexample.databinding.LoadStateLayoutBinding

class MovieLoadStateAdapter(
    private val retry: () -> Unit
) : LoadStateAdapter<MovieLoadStateAdapter.LoadStateViewHolder>() {

    override fun onBindViewHolder(holder: LoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState, retry)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadStateViewHolder {
        val binding =
            LoadStateLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LoadStateViewHolder(
            binding
        )
    }

    class LoadStateViewHolder(private val binding: LoadStateLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(loadState: LoadState, retry: () -> Unit){
            with(binding) {
                if (loadState is LoadState.Error) {
                    textViewMessage.text = loadState.error.localizedMessage
                }
                progressBar.isVisible = loadState is LoadState.Loading
                textViewMessage.isVisible = loadState !is LoadState.Loading
                buttonRetry.isVisible = loadState !is LoadState.Loading

                buttonRetry.setOnClickListener {
                    retry.invoke()
                }
            }
        }
    }
}