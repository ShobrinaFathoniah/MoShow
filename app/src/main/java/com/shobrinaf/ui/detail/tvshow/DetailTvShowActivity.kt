package com.shobrinaf.ui.detail.tvshow

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.shobrinaf.R
import com.shobrinaf.data.source.local.entity.TvShowEntity
import com.shobrinaf.databinding.ActivityDetailTvShowBinding
import com.shobrinaf.databinding.ContentDetailTvShowBinding
import com.shobrinaf.viewmodel.ViewModelFactory
import com.shobrinaf.vo.Status
import kotlin.properties.Delegates

class DetailTvShowActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_SHOW = "extra_show"
    }

    private lateinit var detailContentBinding: ContentDetailTvShowBinding
    private lateinit var activityDetailTvShowBinding: ActivityDetailTvShowBinding
    private lateinit var viewModel: DetailTvShowViewModel
    private var tvShowId by Delegates.notNull<Int>()
    private var menu: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityDetailTvShowBinding = ActivityDetailTvShowBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailTvShowBinding.detailContent
        setContentView(activityDetailTvShowBinding.root)
        setSupportActionBar(activityDetailTvShowBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailTvShowViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            loading(true)
            tvShowId = extras.getInt(EXTRA_SHOW)
            viewModel.setSelectedtvShow(tvShowId)
            viewModel.getTvShow.observe(this, { tvShow ->
                if (tvShow != null) {
                    when (tvShow.status) {
                        Status.LOADING -> loading(true)
                        Status.SUCCESS -> if (tvShow.data != null) {
                            loading(false)
                            setTvShow(tvShow.data)
                        }
                        Status.ERROR -> {
                            loading(false)
                            Toast.makeText(this, getString(R.string.error_msg), Toast.LENGTH_SHORT).show()
                        }
                    }
                }

            })
        }

        with(detailContentBinding) {
            buttonCast.setOnClickListener {
                var url = "www.themoviedb.org/tv/$tvShowId/cast"
                if (!url.startsWith("http://")) {
                    url = "http://$url"
                }
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(browserIntent)
            }
            imgShare.setOnClickListener {
                val userData =
                        "I Recommend you to watch this! Read more about it at https://www.themoviedb.org/tv/$tvShowId"
                val sendData: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, userData)
                    type = "text/plain"
                }
                val shareData = Intent.createChooser(sendData, null)
                startActivity(shareData)
            }
        }
    }

    private fun setTvShow(tvshows: TvShowEntity) {
        with(detailContentBinding) {
            textTitle.text = tvshows.title
            duration.text = tvshows.duration
            genre.text = tvshows.genres
            episode.text = tvshows.episodes
            description.text = tvshows.description
            textDuration.text = resources.getString(R.string.duration)
            textGenre.text = resources.getString(R.string.genre)
            textEpisode.text = resources.getString(R.string.episode)

            com.bumptech.glide.Glide.with(this@DetailTvShowActivity)
                    .load(tvshows.imagePath)
                    .apply(
                            com.bumptech.glide.request.RequestOptions.placeholderOf(R.drawable.ic_loading)
                                    .error(R.drawable.ic_error)
                    )
                    .into(imagePoster)
        }
    }

    private fun loading(state: Boolean) {
        if (state) activityDetailTvShowBinding.progressBar.visibility = View.VISIBLE
        else activityDetailTvShowBinding.progressBar.visibility = View.GONE
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        this.menu = menu
        viewModel.getTvShow.observe(this, { tvShow ->
            if (tvShow != null) {
                when (tvShow.status) {
                    Status.LOADING -> loading(true)
                    Status.SUCCESS -> if (tvShow.data != null) {
                        loading(false)
                        val state = tvShow.data.loved
                        setBookmarkState(state)
                    }
                    Status.ERROR -> {
                        loading(false)
                        Toast.makeText(this, getString(R.string.error_msg), Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.favorite) {
            viewModel.setFavorited()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setBookmarkState(state: Boolean) {
        if (menu == null) return
        val menuItem = menu?.findItem(R.id.favorite)
        if (state) {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite_24)
        } else {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorite_border)
        }
    }
}