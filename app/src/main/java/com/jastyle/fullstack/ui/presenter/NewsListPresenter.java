package com.jastyle.fullstack.ui.presenter;

import android.util.Log;

import com.google.gson.Gson;
import com.jastyle.fullstack.api.ApiConstant;
import com.jastyle.fullstack.model.entity.feednews.News;
import com.jastyle.fullstack.model.entity.feednews.NewsData;
import com.jastyle.fullstack.model.response.NewsResponse;
import com.jastyle.fullstack.ui.base.BasePresenter;
import com.jastyle.fullstack.utils.PreUtils;
import com.jastyle.fullstack.view.INewsListView;
import com.socks.library.KLog;
import com.socks.library.KLogUtil;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;

/**
 * author jastyle
 * description:
 * date 2017/9/19  下午5:02
 */

public class NewsListPresenter extends BasePresenter<INewsListView> {

    private long lastTime;

    public NewsListPresenter(INewsListView view) {
        super(view);
    }

    public void getNewsList(String channelCode) {
        /*上次刷新时间*/
        lastTime = PreUtils.getLong(ApiConstant.RECOMMEND_TIME,0);
        addSubscription(mApiService.getNewsList(channelCode, lastTime, System.currentTimeMillis()/1000), new Subscriber<NewsResponse>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                mView.onError(e);
            }

            @Override
            public void onNext(NewsResponse response) {
                if (null != response.message&&response.message.equals("success")) {
                    /*刷新时间*/
                    PreUtils.putLong(ApiConstant.RECOMMEND_TIME,System.currentTimeMillis()/1000);
                    Log.d("response", response.toString());
                    List<NewsData> data = response.data;
                    List<News> newsList = new ArrayList<>();
                    for (NewsData newsData:data) {
                        News news = new Gson().fromJson(newsData.getContent(), News.class);
                        newsList.add(news);
                    }
                    mView.onGetNewsListSuccess(newsList);
                }
            }
        });
    }
}
