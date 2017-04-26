package com.mikee.galleryviewpager;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by shaoronggang on 2017/3/7.
 */

public class GallleryAdapter extends FragmentStatePagerAdapter {
    int count = 3;// 默认10
    Context mContext;
    private List<Item> items;

    public GallleryAdapter(FragmentManager fm, Context context,List<Item> list) {
        super(fm);
        this.mContext = context;
        this.items = list;
    }

    @Override
    public Fragment getItem(int position) {
        return ItemFragment.create(items.get(position).getName(),items.get(position).getNation(),"来自瑞士的设计与精确性",items.get(position).getImg(),position);
    }

    /**
     * 数量设置为最大
     *
     * @return
     */
    @Override
    public int getCount() {
        return items.size();
    }

    /**
     * 真实数量
     *
     * @return
     */
    public int getRealCount() {
        return this.count;
    }

    OnItemClickListener mOnItemClickListener;

    /**
     * 添加点击事件的点击回调
     * @param mOnItemClickListener
     */
    public void setmOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public interface OnItemClickListener {
        void onClick(int position);
    }
}
