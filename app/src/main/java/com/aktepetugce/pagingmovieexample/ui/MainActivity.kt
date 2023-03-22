package com.aktepetugce.pagingmovieexample.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.paging.LoadState
import androidx.recyclerview.widget.DividerItemDecoration
import com.aktepetugce.pagingmovieexample.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MovieViewModel by viewModels()

    private val movieAdapter = MoviePagingAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
            recyclerViewMovies.apply {
                adapter = movieAdapter.withLoadStateFooter(
                    footer = MovieLoadStateAdapter { movieAdapter.retry() }
                )
                val decoration =
                    DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL)
                addItemDecoration(decoration)
            }
            refreshLayout.setOnRefreshListener {
                movieAdapter.refresh()
                refreshLayout.isRefreshing = false
            }
        }
        subscribeObservers()
    }

    private fun subscribeObservers() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.getAllMovies().collectLatest {
                    movieAdapter.submitData(it)
                }
                movieAdapter.loadStateFlow.collectLatest { loadState ->
                    with(binding) {
                        recyclerViewMovies.isVisible =
                            loadState.source.refresh is LoadState.NotLoading
                        refreshLayout.isEnabled = loadState.source.refresh is LoadState.NotLoading
                    }
                }
            }
        }
    }


}