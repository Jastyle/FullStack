package com.jastyle.fullstack.ui.base;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.nukc.stateview.StateView;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseFragment<T extends BasePresenter> extends LazyLoadFragment {
//    protected static final String TAG = BaseFragment.class.getSimpleName();
    protected T mPresenter;
    protected View rootView;
    protected StateView mStateView;//用于显示加载中、网络异常，空布局、内容布局
    protected Activity mActivity;

    @Override
    public void setTag(String TAG) {
        super.setTag(BaseFragment.class.getSimpleName());
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (null == rootView) {
            rootView = inflater.inflate(provideContentViewId(), container, false);
            ButterKnife.bind(this, rootView);
            if (null == mStateView) {
                mStateView = StateView.inject(rootView);
                /*mStateView.setLoadingResource(R.layout.page_loading);
                mStateView.setRetryResource(R.layout.page_net_error);*/
            }
            initView(rootView);
            initData();
            initLisenter();
        }else {
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (null != parent) {
                parent.removeView(rootView);
            }
        }
        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
    }

    /*初始化view*/
    public void initView(View rootView) {

    }
    /*初始化数据*/
    public void initData() {

    }
    /*初始化接口监听*/
    public void initLisenter() {

    }

    /*StateView根布局，默认整个界面，需要变换可重写*/
    public View getStateViewRoot() {
        return rootView;
    }

    /*第一次可见时加载数据*/
    @Override
    protected void onFragmentFirstVisible() {
        super.onFragmentFirstVisible();
        loadData();
    }

    /*用于创建Presenter以及是否使用MVP模式*/
    protected abstract T createPresenter();

    /*布局文件id*/
    protected abstract int provideContentViewId();

    protected abstract void loadData();

    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
        if (null != mPresenter) {
            mPresenter.detachView();
            mPresenter = null;
        }
        rootView = null;
    }

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
