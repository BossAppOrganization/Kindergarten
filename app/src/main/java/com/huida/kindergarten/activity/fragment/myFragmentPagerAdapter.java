package com.huida.kindergarten.activity.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by 赵发
 * 2017/7/4.
 */

public class myFragmentPagerAdapter extends FragmentPagerAdapter {

    private FragmentManager fragmetnmanager;

    private List<BaseFragment> listfragment;

    public myFragmentPagerAdapter(FragmentManager fm, List<BaseFragment> list) {
        super(fm);
        this.fragmetnmanager=fm;
        this.listfragment=list;
    }

    @Override
    public Fragment getItem(int position) {
        return listfragment.get(position);
    }

    @Override
    public int getCount() {
        return listfragment.size();
    }
}
