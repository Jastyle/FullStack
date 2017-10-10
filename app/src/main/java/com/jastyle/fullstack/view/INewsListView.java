package com.jastyle.fullstack.view;

import com.jastyle.fullstack.model.entity.feednews.News;

import java.util.List;

/**
 * author jastyle
 * description:
 * date 2017/9/19  下午4:54
 */

public interface INewsListView {
    void onGetNewsListSuccess(List<News> newsList);
    void onError(Throwable e);
}
