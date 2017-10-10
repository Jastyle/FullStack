package com.jastyle.fullstack.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * author jastyle
 * description:
 * date 2017/8/30  下午2:49
 */

public class LazyLoadFragment extends Fragment {
    public static String TAG = LazyLoadFragment.class.getSimpleName();
    private boolean isFirstEnter = true;
    private boolean isReuseView = true;
    private boolean isFragmentVisible = false;
    private View rootView;//根视图

    public void setTag(String TAG) {
        LazyLoadFragment.TAG = TAG;
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (null == rootView) {
            return;
        }
        /*fragment首次显示*/
        if (isVisibleToUser&&isFirstEnter) {
            onFragmentFirstVisible();
            isFirstEnter = false;
        }
        /*fragment可见状态发生改变*/
        onFragmentVisibleChange(isVisibleToUser);
        isFragmentVisible = isVisibleToUser;
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    /*view初始化完后回调*/
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        //如果setUserVisibleHint()在rootView创建前调用时，那么
        //就等到rootView创建完后才回调onFragmentVisibleChange(true)
        //保证onFragmentVisibleChange()的回调发生在rootView创建完成之后，以便支持ui操作
        if (null == rootView) {
            rootView = view;
            if (getUserVisibleHint()) {
                if (isFirstEnter) {
                    onFragmentFirstVisible();
                    isFirstEnter = false;
                }
                onFragmentVisibleChange(true);
                isFragmentVisible = true;
            }
        }
        super.onViewCreated(isReuseView?rootView:view, savedInstanceState);
    }

    /*fragment首次可见回调*/
    protected void onFragmentFirstVisible() {

    }

    /*fragment重新可见回调*/
    protected void onFragmentVisibleChange(boolean isVisible) {

    }

    public boolean isFragmentVisible() {
        return isFragmentVisible;
    }

    /**
     * 设置是否使用 view 的复用，默认开启
     * view 的复用是指，ViewPager 在销毁和重建 Fragment 时会不断调用 onCreateView() -> onDestroyView()
     * 之间的生命函数，这样可能会出现重复创建 view 的情况，导致界面上显示多个相同的 Fragment
     * view 的复用其实就是指保存第一次创建的 view，后面再 onCreateView() 时直接返回第一次创建的 view
     *
     * @param
     */
    protected void reuseView(boolean isReuseView) {
        this.isReuseView = isReuseView;
    }

    /**重置变量*/
    protected void resetVariable() {
        isFirstEnter = true;
        isReuseView = true;
        isFragmentVisible= false;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        resetVariable();
    }
}
