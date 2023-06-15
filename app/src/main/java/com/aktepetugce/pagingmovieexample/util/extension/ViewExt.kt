package com.aktepetugce.pagingmovieexample.util.extension

import android.view.View
import androidx.core.view.isVisible

fun View.showProgress() {
    this.isVisible = true
}

fun View.hide() {
    this.isVisible = false
}
