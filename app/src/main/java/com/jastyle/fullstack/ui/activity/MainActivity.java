package com.jastyle.fullstack.ui.activity;

import android.os.Bundle;

import com.jastyle.fullstack.R;
import com.jastyle.fullstack.ui.view.bottombar.BottomBarLayout;
import com.jastyle.fullstack.ui.view.bottompopuwindow.BottomPopuWindow;
import com.jastyle.fullstack.ui.statusbar.Eyes;
import com.jastyle.fullstack.ui.adapter.MainTabAdapter;
import com.jastyle.fullstack.ui.base.BaseActivity;
import com.jastyle.fullstack.ui.base.BaseFragment;
import com.jastyle.fullstack.ui.base.BasePresenter;
import com.jastyle.fullstack.ui.fragment.MeFragment;
import com.jastyle.fullstack.ui.fragment.HomeFragment;
import com.jastyle.fullstack.ui.fragment.MicroFragment;
import com.jastyle.fullstack.ui.fragment.VideoFragment;
import com.jastyle.fullstack.ui.view.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class MainActivity extends BaseActivity{

    @Bind(R.id.vp_content)
    NoScrollViewPager vpContent;
    @Bind(R.id.bottom_bar)
    BottomBarLayout bottomBar;
    private List<BaseFragment> mFragments;
    private MainTabAdapter mAdapter;
    private BottomPopuWindow bottomPopuWindow = null;
    private int[] mStatusColor = new int[] {
            R.color.status_color_red,
            R.color.status_color_white,
            R.color.status_color_white,
            R.color.status_color_grey
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected void initData() {
        super.initData();
        mFragments = new ArrayList<>();
        mFragments.add(new HomeFragment());
        mFragments.add(new VideoFragment());
        mFragments.add(new MicroFragment());
        mFragments.add(new MeFragment());
    }

    @Override
    protected void initLisenter() {
        super.initLisenter();
        mAdapter = new MainTabAdapter(getSupportFragmentManager(), mFragments);
        vpContent.setAdapter(mAdapter);
        bottomBar.setViewPager(vpContent);
        /*lambada表达式*/
        bottomBar.setOnItemSelectedListener((bottomBarItem, position)->{
            /*底部加号动画弹框*/
            if (position == 2) {
                if (null == bottomPopuWindow) {
                    bottomPopuWindow = new BottomPopuWindow(MainActivity.this);
                }
                if (!bottomPopuWindow.isShowing) {
                    bottomPopuWindow.show();
                }
                return;
            }
            if (position>2) position--;
            setStatusBar(position);
        });

    }
    /*设置状态栏颜色*/
    private void setStatusBar(int position) {
        Eyes.setStatusBarColor(MainActivity.this, getResources().getColor(mStatusColor[position]));
    }

    @Override
    protected boolean isEnableSlide() {
        return false;
    }

    @Override
    public BasePresenter createPreseter() {
        return null;
    }

    @Override
    public int provideContentViewId() {
        return R.layout.activity_main;
    }
}
