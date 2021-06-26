package com.shobrinaf.data.source.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TvShowResponse(
        var tvShowId: Int,
        var title: String,
        var genres: String,
        var episodes: String,
        var duration: String,
        var description: String,
        var imagePath: String,
        var loved: Boolean
) : Parcelable