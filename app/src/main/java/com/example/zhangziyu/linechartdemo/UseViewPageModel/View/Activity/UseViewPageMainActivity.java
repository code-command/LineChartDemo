package com.example.zhangziyu.linechartdemo.UseViewPageModel.View.Activity;

import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.zhangziyu.linechartdemo.BR;
import com.example.zhangziyu.linechartdemo.R;
import com.example.zhangziyu.linechartdemo.UseViewPageModel.Model.Adapters.ViewPageAdapter.CommentPagerAdapter;
import com.example.zhangziyu.linechartdemo.UseViewPageModel.Model.Bean.SystemInfo;
import com.example.zhangziyu.linechartdemo.UseViewPageModel.Model.Widget.CustomViewPage;
import com.example.zhangziyu.linechartdemo.UseViewPageModel.View.Fragment.PluseFragment;
import com.example.zhangziyu.linechartdemo.UseViewPageModel.ViewModel.ButtonViewModel.AddButtonViewModel;
import com.example.zhangziyu.linechartdemo.UseViewPageModel.ViewModel.ButtonViewModel.ClearButtonViewModel;
import com.example.zhangziyu.linechartdemo.UseViewPageModel.ViewModel.ButtonViewModel.SwitchButtonViewModel;
import com.example.zhangziyu.linechartdemo.UseViewPageModel.ViewModel.ButtonViewModel.SwitchPagerButtonViewModel;
import com.example.zhangziyu.linechartdemo.databinding.ActivityMainBinding;
import com.example.zhangziyu.linechartdemo.databinding.ActivityUseviewpageMainBinding;

import java.util.ArrayList;
import java.util.List;

public class UseViewPageMainActivity extends AppCompatActivity {

    ActivityUseviewpageMainBinding binding;
    private List<Fragment> fragments;

    ArrayList<Float> dataValues = new ArrayList<>();
    CommentPagerAdapter commentPagerAdapter;

    SystemInfo systemInfo;
    SwitchButtonViewModel switchButtonViewModel;
    AddButtonViewModel addButtonViewModel;
    ClearButtonViewModel clearButtonViewModel;
    SwitchPagerButtonViewModel switchPagerButtonViewModel;

    VpAdapter vpAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initData();
        initViewPager();
        bindingData();
    }

    private void initData() {
        systemInfo = SystemInfo.getSystemInfo();
        switchButtonViewModel = new SwitchButtonViewModel();
        clearButtonViewModel = new ClearButtonViewModel();
        addButtonViewModel = new AddButtonViewModel(dataValues);
        switchPagerButtonViewModel = new SwitchPagerButtonViewModel();
    }

    private void initViewPager() {

        PluseFragment pluseFragment1 = PluseFragment.newInstance(dataValues);
        PluseFragment pluseFragment2 = PluseFragment.newInstance(dataValues);

        fragments = new ArrayList<>(2);
        fragments.add(pluseFragment1);
        fragments.add(pluseFragment2);

        commentPagerAdapter = new CommentPagerAdapter(fragments, R.layout.fragment_useviewpager_pluse, BR.dataValues);

        
        binding.cvpChartPager.setAdapter(commentPagerAdapter);
    }

    private void bindingData() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_useviewpage_main);

        binding.setSystemInfo(systemInfo);
        binding.setSwitchViewModel(switchButtonViewModel);
        binding.setAddViewModel(addButtonViewModel);
        binding.setClearViewModel(clearButtonViewModel);
        binding.setSwitchPagerViewModel(switchPagerButtonViewModel);
        binding.setViewPagerAdapter(commentPagerAdapter);
    }

    private static class VpAdapter extends FragmentPagerAdapter {
        private List<Fragment> data;

        public VpAdapter(FragmentManager fm, List<Fragment> data) {
            super(fm);
            this.data = data;
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Fragment getItem(int position) {
            return data.get(position);
        }
    }
}
