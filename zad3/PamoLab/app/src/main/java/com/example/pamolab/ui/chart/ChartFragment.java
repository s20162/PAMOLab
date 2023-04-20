package com.example.pamolab.ui.chart;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.pamolab.R;
import com.example.pamolab.databinding.FragmentChartBinding;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class ChartFragment extends Fragment {

    private FragmentChartBinding binding;
    private ChartViewModel chartViewModel;

    private BarChart barchart;
    private BarData barData;
    private BarDataSet barDataSet;
    private ArrayList barEntries;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        chartViewModel = new ViewModelProvider(requireActivity()).get(ChartViewModel.class);
        binding = FragmentChartBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        barchart = root.findViewById(R.id.barchart);
        getData();
        barDataSet = new BarDataSet(barEntries, "Data Set");
        barData = new BarData(barDataSet);

        barchart.setData(barData);
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextColor(Color.BLUE);
        barDataSet.setValueTextSize(18f);

        return root;
    }
    private void getData(){
        barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(1f, 35));
        barEntries.add(new BarEntry(2f, 33));
        barEntries.add(new BarEntry(3f, 31));
        barEntries.add(new BarEntry(4f, 30));
        barEntries.add(new BarEntry(5f, 30));
        barEntries.add(new BarEntry(6f, 29));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
