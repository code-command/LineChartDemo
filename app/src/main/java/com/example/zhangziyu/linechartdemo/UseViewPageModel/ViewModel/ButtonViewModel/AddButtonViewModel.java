package com.example.zhangziyu.linechartdemo.UseViewPageModel.ViewModel.ButtonViewModel;

import android.view.View;
import android.view.View.OnClickListener;

import com.example.zhangziyu.linechartdemo.Model.Enums.CmdCode;
import com.example.zhangziyu.linechartdemo.UseViewPageModel.Model.Bean.SystemInfo;

import java.util.ArrayList;

/**
 * Created by zhangziyu on 2017/6/26.
 */

public class AddButtonViewModel implements OnClickListener {

    private ArrayList<Float> dataValues;

    public AddButtonViewModel(ArrayList<Float> dataValues) {
        this.dataValues = dataValues;
    }

    @Override
    public void onClick(View v) {

        SystemInfo systemInfo = SystemInfo.getSystemInfo();
        if (systemInfo.isOpen()) {

            dataValues.clear();

            for (int i=0; i<10; i++) {
                dataValues.add((float) (Math.random() * 10) + 50f);
            }

            systemInfo.setCmdCode(CmdCode.CMD_ADD);
        }
    }
}
