package com.yourapp.developer.expensivemanager.Fragment;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.yourapp.developer.expensivemanager.Database.AdddbModel;
import com.yourapp.developer.expensivemanager.R;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static com.yourapp.developer.expensivemanager.Utilities.BaseFragment.db;

public class ChatLendBorrowFragment extends Fragment {

    protected HorizontalBarChart mChart;
    List<AdddbModel> model = new ArrayList<AdddbModel>();
    XAxis xl;
    private int value;
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mChart = (HorizontalBarChart) view.findViewById(R.id.chart1);
        mChart.setDrawValueAboveBar(true);
        mChart.getDescription().setEnabled(false);
        mChart.setMaxVisibleValueCount(60);

        mChart.setFitBars(true);
        mChart.animateY(2500);

        xl = mChart.getXAxis();
        xl.setPosition(XAxis.XAxisPosition.BOTTOM);
        xl.setDrawAxisLine(true);
        xl.setDrawGridLines(false);
        xl.setGranularity(1f);

        // Set the value formatter


        YAxis yl = mChart.getAxisLeft();
        yl.setDrawAxisLine(true);
        yl.setDrawGridLines(true);
        yl.setAxisMinimum(0f); // this replaces setStartAtZero(true)

        YAxis yr = mChart.getAxisRight();
        yr.setDrawAxisLine(true);
        yr.setDrawGridLines(false);
        yr.setAxisMinimum(0f); // this replaces setStartAtZero(true)


        new DatabaseAsync().execute();
    }

    private void setdata() {
         List<BarEntry> entries = new ArrayList<>();
        List<String> weekdays = new ArrayList<>();
        for (int i = 0; i < model.size(); i++) {
             weekdays.add(model.get(i).getTowhom());
            Log.d("x value", model.get(i).getTowhom());
            entries.add(new BarEntry(i, Integer.parseInt(model.get(i).getExpense())));
            if (model.get(i).getFormat().equals("Lend")) {
                value += Integer.parseInt(model.get(i).getExpense());
            }
            else {
                value -= Integer.parseInt(model.get(i).getExpense());
            }
        }

//Xvalue
        xl.setValueFormatter(new IndexAxisValueFormatter(weekdays));

        BarDataSet set = new BarDataSet(entries, "Your Expensive: "+ value);
        BarData data = new BarData(set);
        data.setBarWidth(0.9f); // set custom bar width

        try {
            mChart.setData(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //mChart.setFitBars(true); // make the x-axis fit exactly all bars
        mChart.invalidate(); // refresh
    }




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_chat, container, false);
    }

    private class DatabaseAsync extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            setdata();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            model = db.epensiveDAO().getAll();
            return null;
        }
    }


}
