package com.rohan.listedpoc.utils

import android.content.Context
import android.content.res.Resources
import androidx.core.content.ContextCompat
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineDataSet
import com.rohan.listedpoc.R


object ChartHelper {

    fun setLineChartData(context: Context, resources: Resources, linevalues: ArrayList<Entry> ): LineDataSet {

        val linedataset = LineDataSet(linevalues, "-")
        linedataset.color = resources.getColor(R.color.purple_200)
        linedataset.circleRadius = 10f
        val drawable = ContextCompat.getDrawable(context, R.drawable.gradient_chart)
        linedataset.setDrawFilled(true)
        linedataset.fillDrawable = drawable
        linedataset.setDrawCircles(false)
        linedataset.lineWidth = 3f
        linedataset.color = resources.getColor(R.color.col_0E6FFF)
        linedataset.mode = LineDataSet.Mode.LINEAR;
        linedataset.setDrawValues(false)

        return linedataset
    }

}