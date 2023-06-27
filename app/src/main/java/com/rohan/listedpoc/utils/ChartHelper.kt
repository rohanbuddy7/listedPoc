package com.rohan.listedpoc.utils

import android.content.Context
import android.content.res.Resources
import androidx.core.content.ContextCompat
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IAxisValueFormatter
import com.rohan.listedpoc.R


object ChartHelper {

    fun setLineChartData(context: Context, resources: Resources, ): LineDataSet {

        val linevalues = ArrayList<Entry>()
        linevalues.add(Entry(20f, 0.0F))
        linevalues.add(Entry(30f, 3.0F))
        linevalues.add(Entry(40f, 2.0F))
        linevalues.add(Entry(50f, 1.0F))
        linevalues.add(Entry(60f, 8.0F))
        linevalues.add(Entry(70f, 10.0F))
        linevalues.add(Entry(80f, 1.0F))
        linevalues.add(Entry(90f, 2.0F))
        linevalues.add(Entry(100f, 5.0F))
        linevalues.add(Entry(110f, 1.0F))
        linevalues.add(Entry(120f, 20.0F))
        linevalues.add(Entry(130f, 40.0F))

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

private class DayAxisValueFormatter : IAxisValueFormatter {
    override fun getFormattedValue(value: Float, axis: AxisBase): String {
        val day = value.toInt()
        return (day + 1).toString()
    }
}