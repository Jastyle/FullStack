package com.jastyle.fullstack.api;

import com.jastyle.fullstack.model.entity.NewsDetail.NewsDetail;
import com.jastyle.fullstack.model.entity.response.ResultResponse;
import com.jastyle.fullstack.model.response.NewsResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;

/**
 * author jastyle
 * description:
 * date 2017/8/29  上午12:30
 */

public interface ApiService {
    String GET_ARTICLE_LIST = "api/news/feed/v62/?refer=1&count=20&loc_mode=4&device_id=34960436458&iid=13136511752";
    String GET_NEWSDETAIL = "http://m.toutiao.com/i_id/info/";
    /**
     * 获取新闻列表
     *
     * @param category 频道
     * @return
     */
    @GET(GET_ARTICLE_LIST)
    Observable<NewsResponse> getNewsList(@Query("category") String category, @Query("min_behot_time") long lastTime, @Query("last_refresh_sub_entrance_interval") long currentTime);

    @GET
    Observable<NewsDetail> getNewsDetail(@Url String url);

}
