package com.shobrinaf.ui.favorite.entertainment.tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.shobrinaf.databinding.FragmentFavoriteTvShowBinding
import com.shobrinaf.viewmodel.ViewModelFactory


class FavoriteTvShowFragment : Fragment() {

    private lateinit var fragmentFavoriteTvShowBinding: FragmentFavoriteTvShowBinding
    private lateinit var tvShowAdapter: FavoriteTvShowAdapter
    private lateinit var viewModel: FavoriteTvShowViewModel


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        fragmentFavoriteTvShowBinding = FragmentFavoriteTvShowBinding.inflate(layoutInflater, container, false)
        return fragmentFavoriteTvShowBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[FavoriteTvShowViewModel::class.java]

            tvShowAdapter = FavoriteTvShowAdapter()

            loading(true)
            viewModel.getFavoriteTvShows().observe(viewLifecycleOwner, { tvshow ->
                if (tvshow != null) {
                    loading(false)
                    tvShowAdapter.submitList(tvshow)
                }
            })

            with(fragmentFavoriteTvShowBinding.rvFavoriteTvShow) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvShowAdapter
            }
        }
    }

    private fun loading(state: Boolean) {
        if (state) fragmentFavoriteTvShowBinding.progressBar.visibility = View.VISIBLE
        else fragmentFavoriteTvShowBinding.progressBar.visibility = View.GONE
    }
}