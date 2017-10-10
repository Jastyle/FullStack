package com.jastyle.fullstack.ui.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jastyle.fullstack.R;
import com.jastyle.fullstack.ui.activity.MainActivity;
import com.jastyle.fullstack.ui.view.SlidingLayout;

import org.greenrobot.eventbus.EventBus;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import butterknife.ButterKnife;

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {
    protected static final String TAG = BaseActivity.class.getSimpleName();
    protected T mBasePresenter;
    private static long lastPressHomeTime;
    protected static Activity mCurrentActivity;
    public static List<Activity> mActivityList = new LinkedList<>();/*对Activity进行管理*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*Activity添加到集合中*/
        synchronized (mActivityList) {
            mActivityList.add(this);
        }

        if (isEnableSlide()) {
            SlidingLayout rootView = new SlidingLayout(this);
            rootView.bindActivity(this);
        }
        mBasePresenter = createPreseter();
        setContentView(provideContentViewId());
        ButterKnife.bind(this);
        initView();
        initData();
        initLisenter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mCurrentActivity = this;
    }

    @Override
    protected void onPause() {
        super.onPause();
        mCurrentActivity = null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        synchronized (mActivityList) {
            mActivityList.remove(this);
        }
        /*解除View层绑定*/
        if (null != mBasePresenter) {
            mBasePresenter.detachView();
            mBasePresenter = null;
        }
        ButterKnife.unbind(this);
    }

    /*连续点击统一退出应用*/
    @Override
    public void onBackPressed() {
        if (mCurrentActivity instanceof MainActivity) {
            if (System.currentTimeMillis()-lastPressHomeTime>2000){
                lastPressHomeTime = System.currentTimeMillis();
                return;
            }
        }
        super.onBackPressed();
    }

    /*销毁退出应用*/
    public static void exitApp() {
        ListIterator<Activity> iterator = mActivityList.listIterator();
        while (iterator.hasNext()) {
            Activity mActivity = iterator.next();
            mActivity.finish();
        }
    }

    /*初始化view*/
    protected void initView() {

    }
    /*初始化数据*/
    protected void initData() {

    }

    /*初始化接口监听*/
    protected void initLisenter() {

    }
    /*是否开启侧滑关闭页面*/
    protected boolean isEnableSlide() {
        return true;
    }

    public static Activity getmCurrentActivity() {
        return mCurrentActivity;
    }

    public abstract T createPreseter();

    /*布局id,由子类实现*/
    public abstract int provideContentViewId();


    public boolean isEventBusRegister(Object subscribe) {
        return EventBus.getDefault().isRegistered(subscribe);
    }

    /*注册EventBus*/
    public void registerEventBus(Object subscribe) {
        if (!isEventBusRegister(subscribe)) {
            EventBus.getDefault().register(subscribe);
        }
    }

    /*取消注册*/
    public void unRegisterEventBus(Object subscribe) {
        if (isEventBusRegister(subscribe)) {
            EventBus.getDefault().unregister(subscribe);
        }
    }
}
