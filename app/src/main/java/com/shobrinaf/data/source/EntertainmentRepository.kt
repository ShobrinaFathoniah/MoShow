package com.shobrinaf.data.source

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.shobrinaf.data.source.local.LocalDataSource
import com.shobrinaf.data.source.local.entity.MovieEntity
import com.shobrinaf.data.source.local.entity.TvShowEntity
import com.shobrinaf.data.source.remote.ApiResponse
import com.shobrinaf.data.source.remote.RemoteDataSource
import com.shobrinaf.data.source.remote.response.MovieResponse
import com.shobrinaf.data.source.remote.response.TvShowResponse
import com.shobrinaf.utils.AppExecutors
import com.shobrinaf.vo.Resource

class EntertainmentRepository private constructor(
        private val remoteDataSource: RemoteDataSource,
        private val localDataSource: LocalDataSource,
        private val appExecutors: AppExecutors
) : EntertainmentDataSource {

    companion object {
        @Volatile
        private var instance: EntertainmentRepository? = null

        fun getInstance(remoteData: RemoteDataSource, localData: LocalDataSource, appExecutors: AppExecutors): EntertainmentRepository =
                instance ?: synchronized(this) {
                    instance
                            ?: EntertainmentRepository(remoteData, localData, appExecutors).apply { instance = this }
                }
    }

    override fun getAllMovies(): LiveData<Resource<List<MovieEntity>>> {
        return object : NetworkBoundResource<List<MovieEntity>, List<MovieResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<List<MovieEntity>> =
                    localDataSource.getAllMovie()

            override fun shouldFetch(data: List<MovieEntity>?): Boolean =
                    data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                    remoteDataSource.getAllMovies()

            public override fun saveCallResult(data: List<MovieResponse>) {
                val movieList = ArrayList<MovieEntity>()
                for (response in data) {
                    val movies = MovieEntity(
                            response.movieId,
                            response.title,
                            response.releaseTime,
                            response.genres,
                            response.duration,
                            response.description,
                            response.imagePath,
                            false
                    )
                    movieList.add(movies)
                }
                localDataSource.insertMovie(movieList)
            }
        }.asLiveData()
    }

    override fun getAllTvShows(): LiveData<Resource<List<TvShowEntity>>> {
        return object : NetworkBoundResource<List<TvShowEntity>, List<TvShowResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<List<TvShowEntity>> =
                    localDataSource.getAllTvShow()

            override fun shouldFetch(data: List<TvShowEntity>?): Boolean =
                    data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<TvShowResponse>>> =
                    remoteDataSource.getAllTvShows()

            public override fun saveCallResult(data: List<TvShowResponse>) {
                val tvShowlist = ArrayList<TvShowEntity>()
                for (response in data) {
                    val tvShow = TvShowEntity(
                            response.tvShowId,
                            response.title,
                            response.genres,
                            response.episodes,
                            response.duration,
                            response.description,
                            response.imagePath,
                            false
                    )
                    tvShowlist.add(tvShow)
                }

                localDataSource.insertTvShow(tvShowlist)
            }
        }.asLiveData()
    }

    override fun getMovieWithId(movieId: Int): LiveData<Resource<MovieEntity>> {
        return object : NetworkBoundResource<MovieEntity, List<MovieResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<MovieEntity> =
                    localDataSource.getMovieById(movieId)

            override fun shouldFetch(data: MovieEntity?): Boolean =
                    data == null

            public override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                    remoteDataSource.getAllMovies()

            public override fun saveCallResult(data: List<MovieResponse>) {
                lateinit var movie: MovieEntity
                for (response in data) {
                    if (response.movieId == movieId) {
                        movie = MovieEntity(
                                response.movieId,
                                response.title,
                                response.releaseTime,
                                response.genres,
                                response.duration,
                                response.description,
                                response.imagePath,
                                false
                        )
                    }
                }
                localDataSource.insertMovie(listOf(movie))
            }
        }.asLiveData()
    }

    override fun getTvShowWithId(tvShowId: Int): LiveData<Resource<TvShowEntity>> {
        return object : NetworkBoundResource<TvShowEntity, List<TvShowResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<TvShowEntity> =
                    localDataSource.getTvShowById(tvShowId)

            override fun shouldFetch(data: TvShowEntity?): Boolean =
                    data == null

            public override fun createCall(): LiveData<ApiResponse<List<TvShowResponse>>> =
                    remoteDataSource.getAllTvShows()

            public override fun saveCallResult(data: List<TvShowResponse>) {
                lateinit var tvShow: TvShowEntity
                for (response in data) {
                    if (response.tvShowId == tvShowId) {
                        tvShow = TvShowEntity(
                                response.tvShowId,
                                response.title,
                                response.genres,
                                response.episodes,
                                response.duration,
                                response.description,
                                response.imagePath,
                                false
                        )
                    }
                }
                localDataSource.insertTvShow(listOf(tvShow))
            }
        }.asLiveData()
    }

    override fun getFavoritedMovie(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
                .setEnablePlaceholders(true)
                .setInitialLoadSizeHint(4)
                .setPageSize(4)
                .build()
        val data: DataSource.Factory<Int, MovieEntity> = localDataSource.getFavoritedMovie()
        return LivePagedListBuilder(data, config).build()
    }

    override fun getFavoritedTvShow(): LiveData<PagedList<TvShowEntity>> {
        val config = PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setInitialLoadSizeHint(4)
                .setPageSize(4)
                .build()
        val data: DataSource.Factory<Int, TvShowEntity> = localDataSource.getFavoritedTvShow()
        return LivePagedListBuilder(data, config).build()
    }

    override fun setFavoritedMovie(movie: MovieEntity, state: Boolean) {
        appExecutors.diskIO().execute {
            localDataSource.updateMovie(movie, state)
        }
    }

    override fun setFavoritedTvShow(tvShow: TvShowEntity, state: Boolean) {
        appExecutors.diskIO().execute {
            localDataSource.updateTvShow(tvShow, state)
        }
    }
}