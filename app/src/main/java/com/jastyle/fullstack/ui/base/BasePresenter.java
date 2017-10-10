package com.jastyle.fullstack.ui.base;

import com.jastyle.fullstack.api.ApiRetrofit;
import com.jastyle.fullstack.api.ApiService;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * author jastyle
 * description:
 * date 2017/8/29  下午6:01
 */

public class BasePresenter<V> {
    protected ApiService mApiService = ApiRetrofit.getInstance().getmApiService();
    protected V mView;
    private CompositeSubscription mCompositeSubscription;

    public BasePresenter(V mView) {
        attachView(mView);
    }

    public void attachView(V mView) {
        this.mView = mView;
    }
    public void detachView() {
        this.mView = null;
    }

    public void addSubscription(Observable observable, Subscriber subscriber) {
        if (null == mCompositeSubscription) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber));

    }

    //RXjava取消注册，以避免内存泄露
    public void onUnsubscribe() {
        if (null != mCompositeSubscription&&mCompositeSubscription.hasSubscriptions()) {
            mCompositeSubscription.unsubscribe();
        }
    }

}
