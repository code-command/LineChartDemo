package com.example.zhangziyu.linechartdemo.UseViewPageModel.Model.Adapters.ViewPageAdapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v4.util.Pools;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by zhangziyu on 2017/6/27.
 */

public class CommentPagerAdapter<D> extends PagerAdapter {
    private List<D> list;
    private int layoutId;
    private int variableId;
    private Pools.Pool<View> pool = new Pools.SimplePool<>(4);
    //自己造一个池，可以提高加载效率，与复用率，
    public CommentPagerAdapter(List<D> list, int layoutId, int variableId) {
        this.list = list;
        this.layoutId = layoutId;
        this.variableId = variableId;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = pool.acquire();
        if (view == null) {
            view = DataBindingUtil.inflate(LayoutInflater.from(container.getContext()), layoutId, container, false).getRoot();
        }
        ViewDataBinding bind = DataBindingUtil.bind(view);
        //bind.setVariable(variableId, list.get(position));
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
        pool.release(view);
    }
}