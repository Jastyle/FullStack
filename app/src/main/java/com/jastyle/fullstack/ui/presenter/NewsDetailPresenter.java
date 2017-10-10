package com.jastyle.fullstack.ui.presenter;

import com.jastyle.fullstack.model.entity.NewsDetail.NewsDetail;
import com.jastyle.fullstack.ui.base.BasePresenter;
import com.jastyle.fullstack.view.INewsDetailView;

import rx.Subscriber;

/**
 * author jastyle
 * description:
 * date 2017/9/30  下午4:29
 */

public class NewsDetailPresenter extends BasePresenter<INewsDetailView>{

    public NewsDetailPresenter(INewsDetailView mView) {
        super(mView);
    }
    public void getNewsDetail(String url) {
        addSubscription(mApiService.getNewsDetail(url), new Subscriber<NewsDetail>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                mView.onError(e);
            }

            @Override
            public void onNext(NewsDetail response) {
                if (response.isSuccess()) {
                    mView.onGetNewsDetailSuccess(response);
                }
            }
        });
    }
}
