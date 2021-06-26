package com.shobrinaf.data.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.shobrinaf.data.source.local.entity.MovieEntity
import com.shobrinaf.data.source.local.entity.TvShowEntity
import com.shobrinaf.vo.Resource

interface EntertainmentDataSource {

    fun getAllMovies(): LiveData<Resource<List<MovieEntity>>>
    fun getAllTvShows(): LiveData<Resource<List<TvShowEntity>>>
    fun getMovieWithId(movieId: Int): LiveData<Resource<MovieEntity>>
    fun getTvShowWithId(tvShowId: Int): LiveData<Resource<TvShowEntity>>
    fun getFavoritedMovie(): LiveData<PagedList<MovieEntity>>
    fun getFavoritedTvShow(): LiveData<PagedList<TvShowEntity>>
    fun setFavoritedMovie(movie: MovieEntity, state: Boolean)
    fun setFavoritedTvShow(tvShow: TvShowEntity, state: Boolean)
}