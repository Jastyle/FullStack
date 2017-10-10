package com.jastyle.fullstack.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.jastyle.fullstack.ui.fragment.NewsListFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * author jastyle
 * description:
 * date 2017/8/31  下午2:35
 */

public class ChannelAdapter extends FragmentStatePagerAdapter {
    private List<NewsListFragment> mFragments;
    private List<String> mChannels;

    public ChannelAdapter(FragmentManager fm, List<NewsListFragment> mFragments, List<String> mChannels) {
        super(fm);
        this.mFragments = mFragments != null ? mFragments:new ArrayList<>();
        this.mChannels = mChannels != null ? mChannels:new ArrayList<>();
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mChannels.get(position);
    }
}
