package com.shobrinaf.data.source.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieResponse(
        var movieId: Int,
        var title: String,
        var releaseTime: String,
        var genres: String,
        var duration: String,
        var description: String,
        var imagePath: String,
        var loved: Boolean
) : Parcelable