package com.example.zhangziyu.linechartdemo.UseViewPageModel.Model.Adapters.BindingAdapter;

import android.databinding.BindingAdapter;

import com.example.zhangziyu.linechartdemo.UseViewPageModel.Model.Widget.CustomViewPage;

/**
 * Created by zhangziyu on 2017/6/27.
 */

public class ViewPagerBindingAdapter {

    @BindingAdapter( "isShowPluse")
    public static void setViewPager(CustomViewPage customViewPage, boolean showPager) {
        if (showPager) {
            customViewPage.setCurrentItem(0);
        } else {
            customViewPage.setCurrentItem(1);
        }
    }

}
