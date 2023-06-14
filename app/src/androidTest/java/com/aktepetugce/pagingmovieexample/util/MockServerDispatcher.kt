package com.aktepetugce.pagingmovieexample.util

import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest

class MockServerDispatcher {

    internal inner class RequestDispatcher : Dispatcher() {
        override fun dispatch(request: RecordedRequest): MockResponse {
            return when (request.path) {
                "/movie/top_rated?api_key=2981fc9f4336b2f6afea27e949566428&language=en-US&page=1" ->
                    MockResponse().setResponseCode(200)
                        .setBody(FileReader.readStringFromFile("movies_response.json"))
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