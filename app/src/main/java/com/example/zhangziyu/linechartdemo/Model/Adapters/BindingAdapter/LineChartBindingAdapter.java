package com.example.zhangziyu.linechartdemo.Model.Adapters.BindingAdapter;

import android.databinding.BindingAdapter;
import android.graphics.Color;
import android.widget.Toast;

import com.example.zhangziyu.linechartdemo.Model.Enums.CmdCode;
import com.example.zhangziyu.linechartdemo.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

/**
 * Created by zhangziyu on 2017/6/26.
 */

public class LineChartBindingAdapter {

    @BindingAdapter({"isOpen", "cmdCode"})
    public static void setLineChart(LineChart lineChart, boolean open, CmdCode cmdCode) {
        showToast(lineChart, open, cmdCode);
        if (!open && cmdCode==CmdCode.CMD_END) {
            initLineChart(lineChart);
            return;
        }
        if (!open && cmdCode==CmdCode.CMD_EMPTY) {
            closeChart(lineChart);
            return;
        }
        if (open && cmdCode==CmdCode.CMD_ADD) {
            addEntry(lineChart);
            return;
        }
        if (open && (cmdCode==CmdCode.CMD_CLEAR || cmdCode==CmdCode.CMD_EMPTY || cmdCode==CmdCode.CMD_END)) {
            clearEntry(lineChart);
            return;
        }
    }

    private static void initLineChart(LineChart lineChart) {
        lineChart.getDescription().setEnabled(false);

        lineChart.setNoDataText("未开始接收");// 折线图没有数据时的描述

        lineChart.setDrawGridBackground(true);
        lineChart.setGridBackgroundColor(0xe0000000);//设置背景禁止位于颜色

        lineChart.setPinchZoom(false);// 如果设置为true,x和y轴可以同时用两手指伸缩,如果false,y轴可以分别按比例缩小的

        lineChart.setTouchEnabled(true); // 设置是否可以触摸
        lineChart.setDragEnabled(true);// 是否可以拖拽
        lineChart.setScaleEnabled(true);// 是否可以缩放

//        lineChart.setEnabled(false);
        lineChart.getLegend().setEnabled(false);

        lineChart.invalidate();
    }

    private static void addEntry(LineChart lineChart) {
        LineData data = lineChart.getData();
        if (data == null) {
            lineChart.setData(new LineData());
            data = lineChart.getData();
        }

        ILineDataSet set = data.getDataSetByIndex(0);
        if (set == null) {
            set = createSet();
            data.addDataSet(set);
        }

        for (int i=0; i<10; i++) {
            int randomDataSetIndex = (int)(Math.random() * data.getDataSetCount());
            float yValue = (float) (Math.random() * 10) + 50f;

            data.addEntry(new Entry(data.getDataSetByIndex(randomDataSetIndex).getEntryCount(), yValue), randomDataSetIndex);
            data.notifyDataChanged();
        }


        lineChart.notifyDataSetChanged();
        lineChart.setVisibleXRangeMinimum(10);
        lineChart.setVisibleXRangeMaximum(60);

//        if (data.getEntryCount()<60 || data.getEntryCount()%50 == 0) {
        lineChart.moveViewTo(data.getEntryCount() - 7, 50f, YAxis.AxisDependency.LEFT);
//        }
    }

    private static void clearEntry(LineChart lineChart) {
        lineChart.setData(new LineData());
        lineChart.invalidate();
    }

    private static void closeChart(LineChart lineChart) {
        lineChart.clear();
    }

    private static LineDataSet createSet() {
        LineDataSet set = new LineDataSet(null, null);
        set.setLineWidth(2f);

        set.setDrawCircles(false);
        set.setColor(Color.WHITE);

        set.setAxisDependency(YAxis.AxisDependency.LEFT);

        return set;
    }

    private static void showToast(LineChart lineChart, boolean open, CmdCode cmdCode) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("open== ");
        stringBuilder.append(open? lineChart.getResources().getString(R.string.close) : lineChart.getResources().getString(R.string.open));
        stringBuilder.append("\t CmdCode== ");
        stringBuilder.append(cmdCode.toString());
        Toast.makeText(lineChart.getContext(), stringBuilder.toString(), Toast.LENGTH_SHORT).show();
    }
}
