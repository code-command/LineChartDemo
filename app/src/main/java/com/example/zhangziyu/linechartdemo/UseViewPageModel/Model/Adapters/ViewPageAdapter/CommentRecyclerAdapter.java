package com.example.zhangziyu.linechartdemo.UseViewPageModel.Model.Adapters.ViewPageAdapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangziyu on 2017/6/27.
 */

public class CommentRecyclerAdapter<D> extends RecyclerView.Adapter<CommentRecyclerAdapter.ViewHolder>{

    private Context mContext;
    private List<D> list;
    private Map<Class<?>,Pair<Integer,Integer>> map;

    public CommentRecyclerAdapter(Context context, List<D> list, Map<Class<?>, Pair<Integer, Integer>> map) {
        mContext = context;
        this.list = list;
        this.map = map;
    }

    public CommentRecyclerAdapter(Context context, List<D> list,int layoutId,int variableId) {
        mContext = context;
        this.list = list;
        map =new HashMap<>();
        map.put(null,Pair.create(layoutId,variableId));
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(DataBindingUtil.inflate(LayoutInflater.from(mContext),viewType,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        D d= list.get(position);
        Pair<Integer,Integer>pair;
        if(map.size()==1){
            pair= map.get(null);
        }else {
            pair= map.get(d.getClass());
        }
        holder.mBinding.setVariable(pair.second,d);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(map.size()==1){
            return map.get(null).first;
        }else {
            return map.get(list.get(position).getClass()).first;
        }
    }

    public void add(D d){
        add(list.size(),d);
    }

    public void add(int position, D d) {
        if (d == null) {
            return;
        }
        list.add(position,d);
        notifyItemInserted(position);
    }

    public void remove(D d){
        int index= list.indexOf(d);
        remove(index);
    }

    private void remove(int index) {
        list.remove(index);
        notifyItemRemoved(index);
    }
    public void addAll(Collection<? extends D>collection){
        addAll(list.size(),collection);
    }

    private void addAll(int position, Collection<? extends D> collection) {
        if (collection == null) {
            return;
        }
        list.addAll(position,collection);
        notifyItemRangeInserted(position,collection.size());

    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        private ViewDataBinding mBinding;

        public ViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.mBinding=binding;
        }
    }
}
