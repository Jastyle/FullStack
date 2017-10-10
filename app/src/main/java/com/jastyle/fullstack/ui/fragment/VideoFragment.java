package com.jastyle.fullstack.ui.fragment;

import android.view.View;

import com.jastyle.fullstack.R;
import com.jastyle.fullstack.ui.base.BaseFragment;
import com.jastyle.fullstack.ui.base.BasePresenter;

/**
 * author jastyle
 * description:
 * date 2017/8/31  下午10:43
 */

public class VideoFragment extends BaseFragment {

    @Override
    public void initView(View rootView) {
        super.initView(rootView);
    }

    @Override
    public void initData() {
        super.initData();
    }

    @Override
    public void initLisenter() {
        super.initLisenter();
    }

    @Override
    public View getStateViewRoot() {
        return super.getStateViewRoot();
    }

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
        return R.layout.fragment_video;
    }

    @Override
    protected void loadData() {

    }
}
