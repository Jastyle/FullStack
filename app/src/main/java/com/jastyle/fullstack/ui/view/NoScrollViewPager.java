package com.jastyle.fullstack.ui.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * author jastyle
 * description:
 * date 2017/8/31  下午2:45
 */

public class NoScrollViewPager extends ViewPager{
    public NoScrollViewPager(Context context) {
        super(context);
    }

    public NoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /*不拦截*/
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }
    /*不处理*/
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }
}
