package com.jastyle.fullstack.app;

import android.support.v7.appcompat.BuildConfig;

import com.jastyle.fullstack.app.base.BaseApp;
import com.socks.library.KLog;

/**
 * author jastyle
 * description:
 * date 2017/8/29  下午2:02
 */

public class RealApp extends BaseApp{
    @Override
    public void onCreate() {
        super.onCreate();
        KLog.init(BuildConfig.DEBUG);//初始化KLog
    }
}
