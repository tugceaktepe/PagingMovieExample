package com.aktepetugce.pagingmovieexample.util.extension

import android.view.View
import androidx.core.view.isVisible
import com.aktepetugce.pagingmovieexample.util.testing.TestIdlingResource

fun View.showProgress() {
    TestIdlingResource.increment()
    this.isVisible = true
}

fun View.hide() {
    TestIdlingResource.decrement()
    this.isVisible = false
}
