package com.jastyle.fullstack.view;

import com.jastyle.fullstack.model.entity.NewsDetail.NewsDetail;

/**
 * author jastyle
 * description:
 * date 2017/9/30  下午4:35
 */

public interface INewsDetailView {
    void onGetNewsDetailSuccess(NewsDetail newsDetail);
    void onError(Throwable e);
}
