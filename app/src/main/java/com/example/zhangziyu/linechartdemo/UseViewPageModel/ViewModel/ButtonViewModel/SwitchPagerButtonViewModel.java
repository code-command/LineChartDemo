package com.example.zhangziyu.linechartdemo.UseViewPageModel.ViewModel.ButtonViewModel;

import android.view.View;

import com.example.zhangziyu.linechartdemo.UseViewPageModel.Model.Bean.SystemInfo;

/**
 * Created by zhangziyu on 2017/6/27.
 */

public class SwitchPagerButtonViewModel implements View.OnClickListener {


    @Override
    public void onClick(View v) {
        SystemInfo systemInfo = SystemInfo.getSystemInfo();
        if (systemInfo.isOpen()) {
            if (systemInfo.isPluseShow()) {
                systemInfo.setPluseShow(false);
            } else {
                systemInfo.setPluseShow(true);
            }
        }
    }
}
