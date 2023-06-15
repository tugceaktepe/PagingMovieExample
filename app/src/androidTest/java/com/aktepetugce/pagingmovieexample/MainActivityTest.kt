package com.aktepetugce.pagingmovieexample

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.aktepetugce.pagingmovieexample.di.UrlModule
import com.aktepetugce.pagingmovieexample.ui.MainActivity
import com.aktepetugce.pagingmovieexample.util.Constants
import com.aktepetugce.pagingmovieexample.util.MockWebServerDispatcher
import com.jakewharton.espresso.OkHttp3IdlingResource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject
import javax.inject.Singleton

@UninstallModules(
    UrlModule::class
)
@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    private val mockWebServer = MockWebServer()

    @Inject
    lateinit var okHttp: OkHttpClient

    private lateinit var okHttp3IdlingResource: OkHttp3IdlingResource

    @Before
    fun setup() {
        hiltRule.inject()
        okHttp3IdlingResource = OkHttp3IdlingResource.create("okhttp", okHttp)
        IdlingRegistry.getInstance().register(okHttp3IdlingResource)
        mockWebServer.start(8080)
    }


    @Test
    fun screenIsReady() {
        mockWebServer.dispatcher = MockWebServerDispatcher().RequestDispatcher()
        val scenario = launchActivity<MainActivity>()
        onView(withId(R.id.recyclerViewMovies)).check { view, noViewFoundException ->
            if (noViewFoundException != null) {
                throw noViewFoundException
            }
            val recyclerView = view as RecyclerView
            assertEquals(21, recyclerView.adapter?.itemCount)
        }
        scenario.close()
    }

    @Test
    fun showErrorWhenMovieLoadFailed() {
        mockWebServer.dispatcher = MockWebServerDispatcher().ErrorDispatcher()
        val scenario = launchActivity<MainActivity>()
        onView(withText(Constants.ERROR_MESSAGE)).check(matches(isDisplayed()))
        scenario.close()
    }

    @Module
    @InstallIn(SingletonComponent::class)
    class FakeBaseUrlModule {

        @Provides
        @Singleton
        fun provideUrl(): String = "http://127.0.0.1:8080/"
    }

    @After
    fun teardown() {
        mockWebServer.shutdown()
        IdlingRegistry.getInstance().unregister(okHttp3IdlingResource)
    }


}