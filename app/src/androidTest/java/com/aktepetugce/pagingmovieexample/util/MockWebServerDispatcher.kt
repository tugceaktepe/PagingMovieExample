package com.aktepetugce.pagingmovieexample.util

import com.aktepetugce.pagingmovieexample.util.ApiConstants.API_KEY
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest
import java.util.concurrent.TimeUnit

class MockWebServerDispatcher {

    internal inner class RequestDispatcher : Dispatcher() {
        override fun dispatch(request: RecordedRequest): MockResponse {
            return when (request.path) {
                "/movie/top_rated?api_key=${API_KEY}&language=en-US&page=1" ->
                    MockResponse().setResponseCode(200)
                        .setBody(FileReader.readStringFromFile("movies_response.json"))
                        .throttleBody(1024, 200L, TimeUnit.MILLISECONDS)
                else -> MockResponse().setResponseCode(400)
            }
        }
    }

    internal inner class ErrorDispatcher : Dispatcher() {
        override fun dispatch(request: RecordedRequest): MockResponse {
            return MockResponse().setResponseCode(400)
                .setBody(Constants.ERROR_MESSAGE)
        }
    }
}