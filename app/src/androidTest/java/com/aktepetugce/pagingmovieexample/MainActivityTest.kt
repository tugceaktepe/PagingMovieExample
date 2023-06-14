package com.aktepetugce.pagingmovieexample

import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.aktepetugce.pagingmovieexample.ui.MainActivity
import com.aktepetugce.pagingmovieexample.util.testing.TestIdlingResource
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @Before
    fun setUp(){
        IdlingRegistry.getInstance().register(TestIdlingResource.countingIdlingResource)
    }

    @Test
    fun screenIsReady(){
        val scenario = launchActivity<MainActivity>()

        Espresso.onView(withId(R.id.recyclerViewMovies))
            .check(ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))

        scenario.close()
    }

    @After
    fun tearDown(){
        IdlingRegistry.getInstance().unregister(TestIdlingResource.countingIdlingResource)
    }
}