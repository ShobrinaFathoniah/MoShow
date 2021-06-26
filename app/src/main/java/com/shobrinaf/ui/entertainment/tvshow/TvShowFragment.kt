package com.shobrinaf.ui.entertainment.tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.shobrinaf.R
import com.shobrinaf.databinding.FragmentTvShowBinding
import com.shobrinaf.viewmodel.ViewModelFactory
import com.shobrinaf.vo.Status

class TvShowFragment : Fragment() {
    private lateinit var fragmentTvShowBinding: FragmentTvShowBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        fragmentTvShowBinding = FragmentTvShowBinding.inflate(layoutInflater, container, false)
        return fragmentTvShowBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[TvShowViewModel::class.java]

            val tvShowAdapter = TvShowAdapter()

            loading(true)
            viewModel.getTvShows().observe(viewLifecycleOwner, { tvshow ->
                if (tvshow != null) {
                    when (tvshow.status) {
                        Status.LOADING -> loading(true)
                        Status.SUCCESS -> {
                            loading(false)
                            tvShowAdapter.setTvShows(tvshow.data)
                            tvShowAdapter.notifyDataSetChanged()
                        }
                        Status.ERROR -> {
                            loading(false)
                            Toast.makeText(
                                    context,
                                    getString(R.string.error_msg),
                                    Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            })

            with(fragmentTvShowBinding.rvTvShow) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvShowAdapter
            }
        }
    }


    private fun loading(state: Boolean) {
        if (state) fragmentTvShowBinding.progressBar.visibility = View.VISIBLE
        else fragmentTvShowBinding.progressBar.visibility = View.GONE
    }
}