package com.example.zhangziyu.linechartdemo.ViewModel.ButtonViewModel;

import android.view.View;
import android.view.View.OnClickListener;

import com.example.zhangziyu.linechartdemo.Model.Bean.SystemInfo;
import com.example.zhangziyu.linechartdemo.Model.Enums.CmdCode;

/**
 * Created by zhangziyu on 2017/6/26.
 */

public class AddButtonViewModel implements OnClickListener {

    @Override
    public void onClick(View v) {

        SystemInfo systemInfo = SystemInfo.getSystemInfo();
        if (systemInfo.isOpen()) {
            systemInfo.setCmdCode(CmdCode.CMD_ADD);
        }
    }
}
