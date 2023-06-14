package com.aktepetugce.pagingmovieexample.util.testing

import com.aktepetugce.pagingmovieexample.BuildConfig

object TestIdlingResource {

    private const val RESOURCE = "GLOBAL"

    @JvmField
    val countingIdlingResource =
        SimpleCountingIdlingResource(RESOURCE)

    fun increment() {
        if (BuildConfig.DEBUG) {
            countingIdlingResource.increment()
        }
    }

    fun decrement() {
        if (BuildConfig.DEBUG) {
            if (!countingIdlingResource.isIdleNow) {
                countingIdlingResource.decrement()
            }
        }
    }
}
