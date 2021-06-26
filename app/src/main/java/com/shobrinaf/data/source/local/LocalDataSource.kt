package com.shobrinaf.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.shobrinaf.data.source.local.entity.MovieEntity
import com.shobrinaf.data.source.local.entity.TvShowEntity
import com.shobrinaf.data.source.local.room.EntertainmentDao

class LocalDataSource private constructor(private val mEntertainmentDao: EntertainmentDao) {

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(entertainmentDao: EntertainmentDao): LocalDataSource =
                INSTANCE ?: LocalDataSource(entertainmentDao).apply {
                    INSTANCE = this
                }
    }

    fun getAllMovie(): LiveData<List<MovieEntity>> = mEntertainmentDao.getAllMovie()

    fun getFavoritedMovie(): DataSource.Factory<Int, MovieEntity> = mEntertainmentDao.getFavoritedMovie()

    fun getMovieById(movieId: Int): LiveData<MovieEntity> =
            mEntertainmentDao.getMovieById(movieId)

    fun insertMovie(courses: List<MovieEntity>) = mEntertainmentDao.insertMovie(courses)

    fun updateMovie(movie: MovieEntity, newState: Boolean) {
        movie.loved = newState
        mEntertainmentDao.updateMovie(movie)
    }

    fun getAllTvShow(): LiveData<List<TvShowEntity>> = mEntertainmentDao.getAllTvShow()

    fun getFavoritedTvShow(): DataSource.Factory<Int, TvShowEntity> = mEntertainmentDao.getFavoritedTvShow()

    fun getTvShowById(tvShowId: Int): LiveData<TvShowEntity> = mEntertainmentDao.getTvShowById(tvShowId)

    fun insertTvShow(tvShows: List<TvShowEntity>) = mEntertainmentDao.insertTvShow(tvShows)

    fun updateTvShow(tvShow: TvShowEntity, newState: Boolean) {
        tvShow.loved = newState
        mEntertainmentDao.updateTvShow(tvShow)
    }
}