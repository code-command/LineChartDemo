package com.example.zhangziyu.linechartdemo.UseViewPageModel.ViewModel.ButtonViewModel;

import android.view.View;
import android.view.View.OnClickListener;

import com.example.zhangziyu.linechartdemo.UseViewPageModel.Model.Enums.CmdCode;
import com.example.zhangziyu.linechartdemo.UseViewPageModel.Model.Bean.SystemInfo;

/**
 * Created by zhangziyu on 2017/6/26.
 */

public class SwitchButtonViewModel implements OnClickListener {
    @Override
    public void onClick(View v) {
        SystemInfo systemInfo = SystemInfo.getSystemInfo();

        if (systemInfo.isOpen()) {
            systemInfo.setOpen(false);
            systemInfo.setCmdCode(CmdCode.CMD_EMPTY);
        } else {
            systemInfo.setOpen(true);
        }
    }
}
