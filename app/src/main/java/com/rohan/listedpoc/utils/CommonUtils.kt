package com.rohan.listedpoc.utils

import java.util.Calendar

object CommonUtils {
    fun getWish(): String {
        val calendar: Calendar = Calendar.getInstance()
        val hour: Int = calendar.get(Calendar.HOUR_OF_DAY)
        val wish: String = if (hour in 0..11) {
            "Good Morning"
        } else if (hour in 12..17) {
            "Good Afternoon"
        } else {
            "Good Evening"
        }
        return wish
    }
}