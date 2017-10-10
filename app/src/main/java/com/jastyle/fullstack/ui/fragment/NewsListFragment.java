package com.jastyle.fullstack.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jastyle.fullstack.R;
import com.jastyle.fullstack.api.ApiConstant;
import com.jastyle.fullstack.api.ApiService;
import com.jastyle.fullstack.constants.Constant;
import com.jastyle.fullstack.model.entity.feednews.News;
import com.jastyle.fullstack.ui.activity.NewsDetailActivity;
import com.jastyle.fullstack.ui.adapter.NewsAdapter;
import com.jastyle.fullstack.ui.base.BaseFragment;
import com.jastyle.fullstack.ui.presenter.NewsListPresenter;
import com.jastyle.fullstack.ui.view.powerfulrecyclerview.PowerfulRecyclerView;
import com.jastyle.fullstack.ui.view.refreshlayout.BGANormalRefreshViewHolder;
import com.jastyle.fullstack.ui.view.refreshlayout.BGARefreshLayout;
import com.jastyle.fullstack.utils.PreUtils;
import com.jastyle.fullstack.utils.UIUtils;
import com.jastyle.fullstack.view.INewsListView;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * author jastyle
 * description:
 * date 2017/8/31  下午1:34
 */

public class NewsListFragment extends BaseFragment<NewsListPresenter> implements INewsListView ,BGARefreshLayout.BGARefreshLayoutDelegate{

    private static final String TAG = "NewsListFragment";

    @Bind(R.id.news_prl)
    PowerfulRecyclerView newsPrl;
    @Bind(R.id.refresh_layout)
    BGARefreshLayout refreshLayout;

    private List<News> newsList = new ArrayList<>();
    private NewsAdapter newsAdapter;
    /*纪录刷新次数*/
    private int refresh_count;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void initView(View rootView) {
        super.initView(rootView);
//        msgTv.setText(getArguments().getString(Constant.CHANNEL_CODE));
        refreshLayout.setDelegate(this);
        Log.d(TAG, getArguments().getString(Constant.CHANNEL_CODE));
        newsPrl.setLayoutManager(new GridLayoutManager(mActivity, 1));
        BGANormalRefreshViewHolder refreshViewHolder = new BGANormalRefreshViewHolder(mActivity, false);
        // 设置下拉刷新
        refreshViewHolder.setRefreshViewBackgroundColorRes(R.color.pull_refresh_bg);//背景色
        refreshViewHolder.setPullDownRefreshText(UIUtils.getString(R.string.refresh_pull_down_text));//下拉的提示文字
        refreshViewHolder.setReleaseRefreshText(UIUtils.getString(R.string.refresh_release_text));//松开的提示文字
        refreshViewHolder.setRefreshingText(UIUtils.getString(R.string.refresh_ing_text));//刷新中的提示文字
        refreshLayout.setRefreshViewHolder(refreshViewHolder);
    }

    @Override
    public void initData() {
        super.initData();
    }

    @Override
    public void initLisenter() {
        super.initLisenter();
        newsAdapter = new NewsAdapter(mActivity, newsList);
        newsPrl.setAdapter(newsAdapter);
        newsAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                News news = newsList.get(position);
                if (news.refresh_record) {
                    if (refreshLayout.getCurrentRefreshStatus() != BGARefreshLayout.RefreshStatus.REFRESHING) {
                        refreshLayout.beginRefreshing();
                        /*点击上次刷新记录位置刷新数据*/
                        newsPrl.scrollToPosition(0);
                        mPresenter.getNewsList("");
                    }
                }else {
                    if (news.has_video) {

                    }else {
                        Intent intent = new Intent(mActivity, NewsDetailActivity.class);
                        String article_url = null;
                        /*非视频类新闻*/
                        /*artical_type=1,一般为广告*/
                        boolean is_news = true;
                        if (news.article_type == 1) {
                            is_news = false;
                            article_url = news.article_url;
                        }else {
                            article_url = ApiService.GET_NEWSDETAIL
//                                .replace(ApiConstant.GROUP_ID,news.group_id+"")
                                    .replace(ApiConstant.ITEM_ID, news.item_id+"");
                        }
                        intent.putExtra(ApiConstant.IS_NEWS, is_news);
                        intent.putExtra(ApiConstant.ARTICLE_URL, article_url);
                        Log.d(TAG, "article_url:"+article_url);
                        mActivity.startActivity(intent);

                    }
                }

            }
        });
    }

    @Override
    protected void onFragmentFirstVisible() {
        super.onFragmentFirstVisible();
    }

    @Override
    protected NewsListPresenter createPresenter() {
        return new NewsListPresenter(this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_list_news;
    }

    @Override
    protected void loadData() {
        mPresenter.getNewsList("");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onGetNewsListSuccess(List<News> mNewsList) {
        int last_position = PreUtils.getInt(ApiConstant.LAST_REFRESH_POSITION, 0);
        refresh_count++;
        /*结束刷新*/
        refreshLayout.endRefreshing();
        /*刷新次数大于三次,删掉上上次浏览记录位置*/
        if (refresh_count>2&&last_position<newsList.size()) {
            newsList.remove(last_position);
        }
        /*从第二次请求起，则要处理置顶重复新闻*/
        if (newsList.size()>0) {
            newsList.remove(0);
        }
        /*从第二次刷新起,添加上次浏览记录位置*/
        if (refresh_count>1){
            News news = new News();
            news.refresh_record = true;
            news.behot_time = PreUtils.getLong(ApiConstant.RECOMMEND_TIME, 0);
            mNewsList.add(mNewsList.size(), news);

        }
         /*本次推荐数量*/
        int size = mNewsList.size();
        /*、从第二次请求起，记录上次浏览记录位置*/
        if (newsList.size()>0) {
            PreUtils.putInt(ApiConstant.LAST_REFRESH_POSITION, size);
        }
        newsList.addAll(0, mNewsList);
        newsAdapter.notifyDataSetChanged();
        Log.d("response", newsList.size() + "");
    }


    @Override
    public void onError(Throwable e) {
        Toast.makeText(mActivity, "请求出错！", Toast.LENGTH_SHORT).show();
        refreshLayout.endRefreshing();
        e.printStackTrace();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {
        /*if (refreshLayout.getCurrentRefreshStatus() == BGARefreshLayout.RefreshStatus.REFRESHING) {
            refreshLayout.endRefreshing();
            return;
        }*/
        mPresenter.getNewsList("");
    }

    @Override
    public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
        return false;
    }
}
