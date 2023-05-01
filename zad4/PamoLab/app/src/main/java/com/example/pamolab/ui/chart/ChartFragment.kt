package com.example.pamolab.ui.chart

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.pamolab.R
import com.example.pamolab.databinding.FragmentChartBinding
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.utils.ColorTemplate

class ChartFragment : Fragment() {
    private var binding: FragmentChartBinding? = null
    private var chartViewModel: ChartViewModel? = null
    private var barchart: BarChart? = null
    private var barData: BarData? = null
    private var barDataSet: BarDataSet? = null
    private var barEntries: ArrayList<*>? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        chartViewModel = ViewModelProvider(requireActivity()).get(ChartViewModel::class.java)
        binding = FragmentChartBinding.inflate(inflater, container, false)
        val root: View = binding!!.root
        barchart = root.findViewById(R.id.barchart)
        data
        barDataSet = BarDataSet(barEntries, "Data Set")
        barData = BarData(barDataSet)
        barchart.setData(barData)
        barDataSet!!.setColors(*ColorTemplate.MATERIAL_COLORS)
        barDataSet!!.valueTextColor = Color.BLUE
        barDataSet!!.valueTextSize = 18f
        return root
    }

    private val data: Unit
        private get() {
            barEntries = ArrayList<Any>()
            barEntries.add(BarEntry(1f, 35f))
            barEntries.add(BarEntry(2f, 33f))
            barEntries.add(BarEntry(3f, 31f))
            barEntries.add(BarEntry(4f, 30f))
            barEntries.add(BarEntry(5f, 30f))
            barEntries.add(BarEntry(6f, 29f))
        }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}