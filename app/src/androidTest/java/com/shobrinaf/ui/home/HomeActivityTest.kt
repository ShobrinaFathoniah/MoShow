package com.shobrinaf.ui.home

import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import android.net.Uri
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.pressBack
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.Intents.intending
import androidx.test.espresso.intent.matcher.IntentMatchers.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.shobrinaf.R
import com.shobrinaf.utils.DataDummy
import com.shobrinaf.utils.EspressoIdlingResource
import org.hamcrest.Matcher
import org.hamcrest.Matchers.*
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeActivityTest {

    private val dummyMovie = DataDummy.generateDummyMovies()
    private val dummyTvShow = DataDummy.generateDummyTvShows()
    private val tvShowId = dummyTvShow[0].tvShowId
    private val movieId = dummyMovie[0].movieId
    private val intentUrlWebTv: Uri = Uri.parse("http://www.themoviedb.org/tv/$tvShowId/cast")
    private val intentUrlWebMovie: Uri = Uri.parse("http://www.themoviedb.org/movie/$movieId/cast")
    private val shareDataMovie: String = "Read more at https://www.themoviedb.org/movie/$movieId"
    private val shareDataTv: String = "I Recommend you to watch this! Read more about it at https://www.themoviedb.org/tv/$tvShowId"

    private fun chooser(matcher: Matcher<Intent>): Matcher<Intent>? {
        return allOf(
                hasAction(Intent.ACTION_CHOOSER),
                hasExtra(`is`(Intent.EXTRA_INTENT), matcher))
    }

    private val intentShareMovie = allOf(
            hasAction(Intent.ACTION_SEND),
            hasExtra(Intent.EXTRA_TEXT, shareDataMovie),
            hasType("text/plain")
    )

    private val intentShareTvShow = allOf(
            hasAction(Intent.ACTION_SEND),
            hasExtra(Intent.EXTRA_TEXT, shareDataTv),
            hasType("text/plain")
    )

    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Before
    fun setUp() {
        Intents.init()
        intending(not(isInternal())).respondWith(Instrumentation.ActivityResult(Activity.RESULT_OK, null))
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @Test
    fun loadMovies() {
        onView(withText("Movies"))
                .perform(click())
        onView(withId(R.id.rv_movie))
                .check(matches(isDisplayed()))
                .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    @Test
    fun loadDetailMovie() {
        onView(withText("Movies"))
                .perform(click())
        onView(withId(R.id.rv_movie))
                .check(matches(isDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.text_title))
                .check(matches(isDisplayed()))
                .check(matches(withText(dummyMovie[0].title)))
        onView(withId(R.id.text_date))
                .check(matches(isDisplayed()))
                .check(matches(withText(dummyMovie[0].releaseTime)))
        onView(withId(R.id.duration))
                .check(matches(isDisplayed()))
                .check(matches(withText(dummyMovie[0].duration)))
        onView(withId(R.id.genre))
                .check(matches(isDisplayed()))
                .check(matches(withText(dummyMovie[0].genres)))
        onView(withId(R.id.description))
                .check(matches(isDisplayed()))
                .check(matches(withText(dummyMovie[0].description)))
        onView(withId(R.id.image_poster))
                .check(matches(isDisplayed()))
        onView(withId(R.id.button_cast))
                .check(matches(isDisplayed()))
                .perform(click())
        intended(allOf(
                hasAction(Intent.ACTION_VIEW),
                hasData(intentUrlWebMovie)
        ))
    }

    @Test
    fun loadTvShows() {
        onView(withText("TV Shows"))
                .perform(click())
        onView(withId(R.id.rv_tv_show))
                .check(matches(isDisplayed()))
                .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShow.size))
    }

    @Test
    fun loadDetailTvSHow() {
        onView(withText("TV Shows"))
                .perform(click())
        onView(withId(R.id.rv_tv_show))
                .check(matches(isDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.text_title))
                .check(matches(isDisplayed()))
                .check(matches(withText(dummyTvShow[0].title)))
        onView(withId(R.id.episode))
                .check(matches(isDisplayed()))
                .check(matches(withText(dummyTvShow[0].episodes)))
        onView(withId(R.id.duration))
                .check(matches(isDisplayed()))
                .check(matches(withText(dummyTvShow[0].duration)))
        onView(withId(R.id.genre))
                .check(matches(isDisplayed()))
                .check(matches(withText(dummyTvShow[0].genres)))
        onView(withId(R.id.description))
                .check(matches(isDisplayed()))
                .check(matches(withText(dummyTvShow[0].description)))
        onView(withId(R.id.image_poster))
                .check(matches(isDisplayed()))
        onView(withId(R.id.button_cast))
                .check(matches(isDisplayed()))
                .perform(click())
        intended(allOf(
                hasAction(Intent.ACTION_VIEW),
                hasData(intentUrlWebTv)
        ))
    }

    @Test
    fun shareMovie() {
        onView(withText("Movies"))
                .perform(click())
        onView(withId(R.id.rv_movie))
                .check(matches(isDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.text_title))
                .check(matches(isDisplayed()))
                .check(matches(withText(dummyMovie[0].title)))
        onView(withId(R.id.img_share))
                .check(matches(isDisplayed()))
                .perform(click())
        intended(chooser(intentShareMovie))
    }

    @Test
    fun shareTvShow() {
        onView(withText("TV Shows"))
                .perform(click())
        onView(withId(R.id.rv_tv_show))
                .check(matches(isDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.text_title))
                .check(matches(isDisplayed()))
                .check(matches(withText(dummyTvShow[0].title)))
        onView(withId(R.id.img_share))
                .check(matches(isDisplayed()))
                .perform(click())
        intended(chooser(intentShareTvShow))
    }

    @Test
    fun loadFavoritedMovie() {
        onView(withText("Movies"))
                .perform(click())
        onView(withId(R.id.rv_movie))
                .check(matches(isDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.text_title))
                .check(matches(isDisplayed()))
                .check(matches(withText(dummyMovie[0].title)))
        onView(withId(R.id.favorite))
                .perform(click())
        onView(isRoot())
                .perform(pressBack())
        onView(withId(R.id.favorite_activity))
                .perform(click())
        onView(withText("Favorite Movie"))
                .perform(click())
        onView(withId(R.id.rv_favorite_movie))
                .check(matches(isDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.text_title))
                .check(matches(isDisplayed()))
                .check(matches(withText(dummyMovie[0].title)))
        onView(withId(R.id.favorite))
                .perform(click())
        onView(isRoot()).perform(pressBack())
        onView(withId(R.id.rv_favorite_movie))
                .check(matches(isDisplayed()))
    }

    @Test
    fun loadFavoritedTvShow() {
        onView(withText("TV Shows"))
                .perform(click())
        onView(withId(R.id.rv_tv_show))
                .check(matches(isDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.text_title))
                .check(matches(isDisplayed()))
                .check(matches(withText(dummyTvShow[0].title)))
        onView(withId(R.id.favorite))
                .perform(click())
        onView(isRoot())
                .perform(pressBack())
        onView(withId(R.id.favorite_activity))
                .perform(click())
        onView(withText("Favorite Tv Show"))
                .perform(click())
        onView(withId(R.id.rv_favorite_tv_show))
                .check(matches(isDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.text_title))
                .check(matches(isDisplayed()))
                .check(matches(withText(dummyTvShow[0].title)))
        onView(withId(R.id.favorite))
                .perform(click())
        onView(isRoot()).perform(pressBack())
        onView(withId(R.id.rv_favorite_tv_show))
                .check(matches(isDisplayed()))
    }

    @After
    fun release() {
        Intents.release()
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }
}