package com.shobrinaf.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.shobrinaf.data.source.local.entity.MovieEntity
import com.shobrinaf.data.source.local.entity.TvShowEntity

@Dao
interface EntertainmentDao {

    @Query("SELECT * FROM movieEntities")
    fun getAllMovie(): LiveData<List<MovieEntity>>

    @Query("SELECT * FROM movieEntities where loved = 1")
    fun getFavoritedMovie(): DataSource.Factory<Int, MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movies: List<MovieEntity>)

    @Update
    fun updateMovie(course: MovieEntity)

    @Query("SELECT * FROM movieEntities WHERE movieId = :movieId")
    fun getMovieById(movieId: Int): LiveData<MovieEntity>

    @Query("SELECT * FROM tvshowEntities")
    fun getAllTvShow(): LiveData<List<TvShowEntity>>

    @Query("SELECT * FROM tvshowEntities where loved = 1")
    fun getFavoritedTvShow(): DataSource.Factory<Int, TvShowEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShow(tvShows: List<TvShowEntity>)

    @Update
    fun updateTvShow(tvShow: TvShowEntity)

    @Query("SELECT * FROM tvshowEntities WHERE tvShowId = :tvShowId")
    fun getTvShowById(tvShowId: Int): LiveData<TvShowEntity>
}