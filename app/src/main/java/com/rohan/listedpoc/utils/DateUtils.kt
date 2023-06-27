package com.rohan.listedpoc.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Locale


object DateUtils {
    fun convertDateFormat(dateString: String?): String {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
        val outputFormat = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault())
        return try {
            val date = inputFormat.parse(dateString)
            outputFormat.format(date)
        } catch (e: ParseException) {
            e.printStackTrace()
            ""
        }
    }
}
