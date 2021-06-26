package com.shobrinaf.ui.detail.movie

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
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.shobrinaf.R
import com.shobrinaf.data.source.local.entity.MovieEntity
import com.shobrinaf.databinding.ActivityDetailMovieBinding
import com.shobrinaf.databinding.ContentDetailMovieBinding
import com.shobrinaf.viewmodel.ViewModelFactory
import com.shobrinaf.vo.Status
import kotlin.properties.Delegates

class DetailMovieActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_SHOW = "extra_show"
    }

    private lateinit var detailContentBinding: ContentDetailMovieBinding
    private lateinit var activityDetailMovieBinding: ActivityDetailMovieBinding
    private lateinit var viewModel: DetailMovieViewModel
    private var movieId by Delegates.notNull<Int>()
    private var menu: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityDetailMovieBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailMovieBinding.detailContent
        setContentView(activityDetailMovieBinding.root)
        setSupportActionBar(activityDetailMovieBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailMovieViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            loading(true)
            movieId = extras.getInt(EXTRA_SHOW)
            viewModel.setSelectedMovie(movieId)

            viewModel.getMovie.observe(this, { movie ->
                if (movie != null) {
                    when (movie.status) {
                        Status.LOADING -> loading(true)
                        Status.SUCCESS -> if (movie.data != null) {
                            loading(false)
                            setMovies(movie.data)
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
                var url = "www.themoviedb.org/movie/$movieId/cast"
                if (!url.startsWith("http://")) {
                    url = "http://$url"
                }
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(browserIntent)
            }
            imgShare.setOnClickListener {
                val userData = "Read more at https://www.themoviedb.org/movie/$movieId"
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

    private fun setMovies(movies: MovieEntity) {
        with(detailContentBinding) {
            textTitle.text = movies.title
            textDate.text = movies.releaseTime
            duration.text = movies.duration
            genre.text = movies.genres
            description.text = movies.description
            textDuration.text = resources.getString(R.string.duration)
            textGenre.text = resources.getString(R.string.genre)
            textReleasedate.text = resources.getString(R.string.release_date)

            Glide.with(this@DetailMovieActivity)
                    .load(movies.imagePath)
                    .apply(
                            RequestOptions.placeholderOf(R.drawable.ic_loading)
                                    .error(R.drawable.ic_error)
                    )
                    .into(imagePoster)
        }
    }

    private fun loading(state: Boolean) {
        if (state) activityDetailMovieBinding.progressBar.visibility = View.VISIBLE
        else activityDetailMovieBinding.progressBar.visibility = View.GONE
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        this.menu = menu
        viewModel.getMovie.observe(this, { movie ->
            if (movie != null) {
                when (movie.status) {
                    Status.LOADING -> loading(true)
                    Status.SUCCESS -> if (movie.data != null) {
                        loading(false)
                        val state = movie.data.loved
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