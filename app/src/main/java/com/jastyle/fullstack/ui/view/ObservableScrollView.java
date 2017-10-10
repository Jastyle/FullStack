package com.jastyle.fullstack.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ScrollView;

import com.jastyle.fullstack.ui.view.model.ScrollViewListener;

/**
 * author jastyle
 * description:
 * date 2017/10/9  下午5:49
 */

public class ObservableScrollView extends ScrollView {
    public ScrollViewListener listener;
    public ObservableScrollView(Context context) {
        super(context);
    }

    public ObservableScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ObservableScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
            if (oldt>t) {
                if (null != listener) {
                    listener.onScrollChanged(-1, t);//下滑
                }
            }else if (oldt<t) {
                if (null != listener) {
                    listener.onScrollChanged(1, t);//上滑
                }
            }


    }

    public void setListener(ScrollViewListener listener) {
        this.listener = listener;
    }
}
