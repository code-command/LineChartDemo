package com.example.zhangziyu.linechartdemo.UseViewPageModel.View.Fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhangziyu.linechartdemo.R;
import com.example.zhangziyu.linechartdemo.UseViewPageModel.Model.Bean.SystemInfo;
import com.example.zhangziyu.linechartdemo.databinding.FragmentUseviewpagerPluseBinding;

import java.util.ArrayList;

/**
 * Created by zhangziyu on 2017/6/27.
 */

public class PluseFragment extends Fragment {
    public static final String DATAVALUES = "datavaluse";

    private FragmentUseviewpagerPluseBinding binding;
    private SystemInfo systemInfo;
    private ArrayList dataValuse;

    public static PluseFragment newInstance(ArrayList dataValuse) {
        PluseFragment pluseFragment = new PluseFragment();

        Bundle bundle = new Bundle();
        bundle.putCharSequenceArrayList(DATAVALUES, dataValuse);

        pluseFragment.setArguments(bundle);

        return pluseFragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        systemInfo = SystemInfo.getSystemInfo();
        Bundle bundle = getArguments();
        if (bundle != null) {
            dataValuse = bundle.getCharSequenceArrayList(DATAVALUES);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.fragment_useviewpager_pluse, null);

        bindingData(view);

        return view;
    }

    private void bindingData(View view) {
        binding = DataBindingUtil.bind(view);
        binding.setSystemInfo(systemInfo);
        binding.setDataValues(dataValuse);
    }
}
