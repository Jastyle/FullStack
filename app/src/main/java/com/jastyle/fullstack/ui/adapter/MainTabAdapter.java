package com.jastyle.fullstack.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.jastyle.fullstack.ui.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * author jastyle
 * description:
 * date 2017/8/31  下午3:12
 */

public class MainTabAdapter extends FragmentStatePagerAdapter {
    private List<BaseFragment> mFragment;

    public MainTabAdapter(FragmentManager fm, List<BaseFragment> mFragment) {
        super(fm);
        this.mFragment = mFragment != null ? mFragment:new ArrayList<>();
    }

    @Override
    public Fragment getItem(int position) {
        return mFragment.get(position);
    }

    @Override
    public int getCount() {
        return mFragment.size();
    }
}
