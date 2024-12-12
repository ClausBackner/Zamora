package com.example.centodonzamora

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.zamora.R
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate


class Grafica : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var pieChart: PieChart

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grafica)

        pieChart = findViewById(R.id.pie_chart)


        val list: ArrayList<PieEntry> = ArrayList()

        list.add(PieEntry(100f, "100"))
        list.add(PieEntry(101f, "101"))
        list.add(PieEntry(102f, "102"))
        list.add(PieEntry(103f, "103"))
        list.add(PieEntry(104f, "104"))

        val pieDataSet = PieDataSet(list, "List")

        pieDataSet.setColors(ColorTemplate.MATERIAL_COLORS, 255)
        pieDataSet.valueTextColor = Color.GREEN
        pieDataSet.valueTextSize = 15f

        val pieData = PieData(pieDataSet)

        pieChart.data = pieData

        pieChart.description.text = "Pie Chart"

        pieChart.centerText = "List"

        pieChart.animateY(2000)


    }
}