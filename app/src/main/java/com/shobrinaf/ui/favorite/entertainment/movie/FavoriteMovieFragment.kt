package com.shobrinaf.ui.favorite.entertainment.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.shobrinaf.databinding.FragmentFavoriteMovieBinding
import com.shobrinaf.viewmodel.ViewModelFactory

class FavoriteMovieFragment : Fragment() {
    private lateinit var fragmentFavoriteMovieBinding: FragmentFavoriteMovieBinding
    private lateinit var movieAdapter: FavoriteMovieAdapter
    private lateinit var viewModel: FavoriteMovieViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        fragmentFavoriteMovieBinding = FragmentFavoriteMovieBinding.inflate(layoutInflater, container, false)
        return fragmentFavoriteMovieBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[FavoriteMovieViewModel::class.java]

            movieAdapter = FavoriteMovieAdapter()

            loading(true)

            viewModel.getFavoriteMovies().observe(viewLifecycleOwner, { movies ->
                loading(false)
                movieAdapter.submitList(movies)
            })
            with(fragmentFavoriteMovieBinding.rvFavoriteMovie) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        }
    }

    private fun loading(state: Boolean) {
        if (state) fragmentFavoriteMovieBinding.progressBar.visibility = View.VISIBLE
        else fragmentFavoriteMovieBinding.progressBar.visibility = View.GONE
    }

}