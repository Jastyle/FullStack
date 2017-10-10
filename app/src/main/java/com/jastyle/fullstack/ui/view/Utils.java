package com.jastyle.fullstack.ui.view;

import android.view.View;

/**
 * author jastyle
 * description:
 * date 2017/10/10  上午11:20
 */

public class Utils {

    public static int getViewHeight(final View mView) {
        int w = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        mView.measure(w, h);
        return mView.getMeasuredHeight();
    }

}
