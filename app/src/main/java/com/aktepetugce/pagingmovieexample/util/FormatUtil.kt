package com.aktepetugce.pagingmovieexample.util

import java.math.RoundingMode
import java.text.DecimalFormat

object FormatUtil {
    fun formatTwoDecimalPlace(value: Double): String {
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.DOWN
        return df.format(value)
    }
}