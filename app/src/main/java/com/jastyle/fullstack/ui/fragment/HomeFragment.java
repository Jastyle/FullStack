package com.jastyle.fullstack.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jastyle.fullstack.R;
import com.jastyle.fullstack.constants.Constant;
import com.jastyle.fullstack.ui.adapter.ChannelAdapter;
import com.jastyle.fullstack.ui.base.BaseFragment;
import com.jastyle.fullstack.ui.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * author jastyle
 * description:
 * date 2017/8/31  下午1:29
 */

public class HomeFragment extends BaseFragment {
    public static final String TAG = "HomeFragment";
    @Bind(R.id.vp_content)
    ViewPager vpContent;
    @Bind(R.id.logo_tv)
    TextView logoTv;
    private List<String> mSelectedChannels = new ArrayList<>();
    private List<NewsListFragment> mChannelFragments = new ArrayList<>();

    @Override
    public void initView(View rootView) {
        super.initView(rootView);
    }

    @Override
    public void initData() {
        super.initData();
        for (int i = 0; i < 5; i++) {
            mSelectedChannels.add("news   " + i);
        }
        initSelectFragment();

    }

    public void initSelectFragment() {
        for (String mChannel : mSelectedChannels) {
            NewsListFragment newsFragment = new NewsListFragment();
            Bundle bundle = new Bundle();
            bundle.putString(Constant.CHANNEL_CODE, mChannel);
            newsFragment.setArguments(bundle);
            mChannelFragments.add(newsFragment);
        }
    }

    @Override
    public void initLisenter() {
        super.initLisenter();
        ChannelAdapter adapter = new ChannelAdapter(getChildFragmentManager(), mChannelFragments, mSelectedChannels);
        vpContent.setAdapter(adapter);
        vpContent.setOffscreenPageLimit(3);
    }

    /*public void initTextTTF(TextView tv) {
        Typeface mTypeface = Typeface.createFromAsset(mActivity.getAssets(),"iconfont.ttf");
        tv.setTypeface(mTypeface, Typeface.BOLD);
    }*/


    @Override
    protected void onFragmentFirstVisible() {
        super.onFragmentFirstVisible();
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void loadData() {

    }




    @Override
    public void onDestroyView() {
        Log.d(TAG, "onDestroyView");
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        Log.d(TAG, "onCreateView");
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy");
        super.onDestroy();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "onViewCreated");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach");
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.d(TAG, "setUserVisibleHint:"+isVisibleToUser);
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.d(TAG, "onHiddenChanged:"+hidden);
    }

    @Override
    public void onPause() {
        Log.d(TAG, "onPause");
        super.onPause();
    }


    @Override
    public void onResume() {
        Log.d(TAG, "onResume");
        super.onResume();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.d(TAG, "onStart");
        super.onStart();
    }

    @Override
    public void onStop() {
        Log.d(TAG, "onStop");
        super.onStop();
    }

    @Override
    public void onDetach() {
        Log.d(TAG, "onDetach");
        super.onDetach();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }


}
