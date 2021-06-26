package com.shobrinaf.ui.favorite

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.shobrinaf.R
import com.shobrinaf.ui.favorite.entertainment.movie.FavoriteMovieFragment
import com.shobrinaf.ui.favorite.entertainment.tvshow.FavoriteTvShowFragment

class SectionsPagerAdapter(private val mContext: Context, fm: FragmentManager) :
        FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.favorite_movie, R.string.favorite_tv_show)
    }

    override fun getItem(position: Int): Fragment =
            when (position) {
                0 -> FavoriteMovieFragment()
                1 -> FavoriteTvShowFragment()
                else -> Fragment()
            }

    override fun getPageTitle(position: Int): CharSequence =
            mContext.resources.getString(TAB_TITLES[position])

    override fun getCount(): Int = TAB_TITLES.size

}