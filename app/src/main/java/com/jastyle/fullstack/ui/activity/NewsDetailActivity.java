package com.jastyle.fullstack.ui.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jastyle.fullstack.R;
import com.jastyle.fullstack.api.ApiConstant;
import com.jastyle.fullstack.model.entity.NewsDetail.NewsDetail;
import com.jastyle.fullstack.ui.base.BaseActivity;
import com.jastyle.fullstack.ui.presenter.NewsDetailPresenter;
import com.jastyle.fullstack.ui.view.ObservableScrollView;
import com.jastyle.fullstack.ui.view.Utils;
import com.jastyle.fullstack.ui.view.model.ScrollViewListener;
import com.jastyle.fullstack.utils.GlideUtils;
import com.jastyle.fullstack.view.INewsDetailView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewsDetailActivity extends BaseActivity<NewsDetailPresenter> implements INewsDetailView, ScrollViewListener {

    private static final String TAG = "NewsDetailActivity";

    @Bind(R.id.back_iv)
    ImageView backIv;
    @Bind(R.id.avater_iv)
    ImageView avaterIv;
    @Bind(R.id.source_tv)
    TextView sourceTv;
    @Bind(R.id.attention_btn)
    TextView attentionBtn;
    @Bind(R.id.more_iv)
    ImageView moreIv;
    @Bind(R.id.content_wv)
    WebView contentWv;
    @Bind(R.id.title_tv)
    TextView titleTv;
    @Bind(R.id.header_avater_iv)
    ImageView headerAvaterIv;
    @Bind(R.id.header_source_tv)
    TextView headerSourceTv;
    @Bind(R.id.header_ll)
    LinearLayout headerLl;
    @Bind(R.id.common_title_ll)
    LinearLayout commonTitleLl;

    boolean is_news = false;
    @Bind(R.id.header_attention_btn)
    TextView headerAttentionBtn;
    @Bind(R.id.scrollView)
    ObservableScrollView scrollView;
    @Bind(R.id.source_ll)
    LinearLayout sourceLl;

    private int height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        ButterKnife.bind(this);
    }


    @Override
    public NewsDetailPresenter createPreseter() {
        return new NewsDetailPresenter(this);
    }

    @Override
    public int provideContentViewId() {
        return R.layout.activity_news_detail;
    }

    @Override
    protected void initView() {
        super.initView();
        contentWv.getSettings().setJavaScriptEnabled(true);
//        contentWv.addJavascriptInterface();
//        scrollView.setListener(this);

    }

    @Override
    protected void initData() {
        super.initData();
        is_news = getIntent().getBooleanExtra(ApiConstant.IS_NEWS, false);
        String article_url = getIntent().getStringExtra(ApiConstant.ARTICLE_URL);
        Log.d(TAG, "article_url::" + article_url);
        if (is_news) {
            mBasePresenter.getNewsDetail(article_url);
        } else {
            contentWv.loadUrl(article_url);
        }

    }


    @Override
    public void onScrollChanged(int direction, int y) {
        if (direction == 1) {//上滑
            if (y > height) {
                sourceLl.setVisibility(View.VISIBLE);
                attentionBtn.setVisibility(View.VISIBLE);
                moreIv.setVisibility(View.VISIBLE);
            }

        }else if (direction == -1) {//下滑
            if (y<=height) {
                sourceLl.setVisibility(View.GONE);
                attentionBtn.setVisibility(View.GONE);
                moreIv.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public void onGetNewsDetailSuccess(NewsDetail newsDetail) {
        Log.d(TAG, "content:" + newsDetail.getData().getContent());
        String htmlPart1 = "<!DOCTYPE HTML html>\n" +
                "<head><meta charset=\"utf-8\"/>\n" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, minimum-scale=1.0, user-scalable=no\"/>\n" +
                "</head>\n" +
                "<body>\n" +
                "<style> \n" +
                "img{width:100%!important;height:auto!important}\n" +
                " </style>";
        String htmlPart2 = "</body></html>" + "<script>document.body.style.lineHeight = 1.5< /script> \n< /html>";
        contentWv.loadDataWithBaseURL(null, htmlPart1 + newsDetail.getData().getContent() + htmlPart2, "text/html", "UTF-8", null);
        if (is_news) {
            GlideUtils.loadRound(NewsDetailActivity.this, newsDetail.getData().getMedia_user().getAvatar_url(), avaterIv);
            GlideUtils.loadRound(NewsDetailActivity.this, newsDetail.getData().getMedia_user().getAvatar_url(), headerAvaterIv);
            sourceTv.setText(newsDetail.getData().getMedia_user().getScreen_name());
            headerSourceTv.setText(newsDetail.getData().getMedia_user().getScreen_name());
            titleTv.setText(newsDetail.getData().getTitle());

        } else {
            sourceTv.setVisibility(View.GONE);
            attentionBtn.setVisibility(View.GONE);
            moreIv.setVisibility(View.GONE);
            avaterIv.setVisibility(View.GONE);
        }
        height = Utils.getViewHeight(headerLl);
        scrollView.setListener(this);
        Log.d(TAG, "height:"+height);
    }

    @Override
    public void onError(Throwable e) {
        Toast.makeText(this, "请求出错！", Toast.LENGTH_SHORT).show();
    }

}
