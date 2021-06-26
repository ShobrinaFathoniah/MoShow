package com.shobrinaf.utils

import android.content.Context
import com.shobrinaf.data.source.remote.response.MovieResponse
import com.shobrinaf.data.source.remote.response.TvShowResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {

    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadMovie(): List<MovieResponse> {
        val list = ArrayList<MovieResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("MovieResponse.json").toString())
            val listArray = responseObject.getJSONArray("movies")
            for (i in 0 until listArray.length()) {
                val movie = listArray.getJSONObject(i)

                val movieId = movie.getInt("movieId")
                val title = movie.getString("title")
                val description = movie.getString("description")
                val releaseTime = movie.getString("releaseTime")
                val genres = movie.getString("genres")
                val duration = movie.getString("duration")
                val imagePath = movie.getString("imagePath")
                val favorited = movie.getBoolean("favorited")

                val movieResponse = MovieResponse(
                        movieId,
                        title,
                        releaseTime,
                        genres,
                        duration,
                        description,
                        imagePath,
                        favorited
                )
                list.add(movieResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }

    fun loadTvShow(): List<TvShowResponse> {
        val list = ArrayList<TvShowResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("TvShowResponse.json").toString())
            val listArray = responseObject.getJSONArray("shows")
            for (i in 0 until listArray.length()) {
                val tvShow = listArray.getJSONObject(i)

                val tvShowId = tvShow.getInt("tvShowId")
                val title = tvShow.getString("title")
                val description = tvShow.getString("description")
                val episodes = tvShow.getString("episode")
                val genres = tvShow.getString("genres")
                val duration = tvShow.getString("duration")
                val imagePath = tvShow.getString("imagePath")
                val favorited = tvShow.getBoolean("favorited")

                val tvShowResponse = TvShowResponse(
                        tvShowId,
                        title,
                        genres,
                        episodes,
                        duration,
                        description,
                        imagePath,
                        favorited
                )
                list.add(tvShowResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }
}