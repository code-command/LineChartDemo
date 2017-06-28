package com.example.zhangziyu.linechartdemo.SingleLineChart.View.Activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.zhangziyu.linechartdemo.SingleLineChart.Model.Bean.SystemInfo;
import com.example.zhangziyu.linechartdemo.R;
import com.example.zhangziyu.linechartdemo.SingleLineChart.ViewModel.ButtonViewModel.AddButtonViewModel;
import com.example.zhangziyu.linechartdemo.SingleLineChart.ViewModel.ButtonViewModel.ClearButtonViewModel;
import com.example.zhangziyu.linechartdemo.SingleLineChart.ViewModel.ButtonViewModel.SwitchButtonViewModel;
import com.example.zhangziyu.linechartdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    SystemInfo systemInfo;
    SwitchButtonViewModel switchButtonViewModel;
    AddButtonViewModel addButtonViewModel;
    ClearButtonViewModel clearButtonViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initData();
        bindingData();
    }

    private void initData() {
        systemInfo = SystemInfo.getSystemInfo();
        switchButtonViewModel = new SwitchButtonViewModel();
        addButtonViewModel = new AddButtonViewModel();
        clearButtonViewModel = new ClearButtonViewModel();
    }

    private void bindingData() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setSystemInfo(systemInfo);
        binding.setSwitchViewModel(switchButtonViewModel);
        binding.setAddViewModel(addButtonViewModel);
        binding.setClearViewModel(clearButtonViewModel);
    }
}
