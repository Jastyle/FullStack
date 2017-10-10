package com.jastyle.fullstack.ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jastyle.fullstack.R;
import com.jastyle.fullstack.model.entity.feednews.News;
import com.jastyle.fullstack.utils.GlideUtils;
import com.jastyle.fullstack.utils.LogUtils;
import com.jastyle.fullstack.utils.TimeUtils;
import com.jastyle.fullstack.utils.UIUtils;

import java.util.List;

/**
 * author jastyle
 * description:
 * date 2017/9/25  下午4:53
 */

public class NewsAdapter extends BaseMultiItemQuickAdapter<News, BaseViewHolder>{

    private Context mContext;
    private Drawable drawable;
    public NewsAdapter(Context mContext,List<News> data) {
        super(data);
        this.mContext = mContext;
        addItemType(News.TEXT, R.layout.item_text_news);
        addItemType(News.CENTER_ONE_PIC, R.layout.item_center_one_pic);
        addItemType(News.RIGHT_ONE_PIC, R.layout.item_right_one_pic);
        addItemType(News.CENTER_THREE_PIC, R.layout.item_center_three_pic);
        addItemType(News.LAST_REFRESH_POSITION, R.layout.item_last_refresh_position);
    }

    @Override
    protected void convert(BaseViewHolder helper, News item) {
        long refresh_time = item.behot_time;

        if (!item.refresh_record) {
            /*新闻item类型*/
            /*、标题、来源、数量、时间*/
            helper.setText(R.id.news_title, item.title);
            helper.setText(R.id.source_tv, item.source);
            helper.setText(R.id.num_tv, item.comment_count + "");
            helper.setText(R.id.time_tv, TimeUtils.getFormatTime(item.behot_time * 1000));
            helper.setVisible(R.id.tag_tv, true);
            if (!TextUtils.isEmpty(item.tag) && item.tag.equals("ad")) {
                /*广告*/
                helper.setTextColor(R.id.tag_tv, UIUtils.getColor(R.color.news_tag_border_blue));
                helper.setText(R.id.tag_tv, UIUtils.getString(R.string.ad));
                /*广告不显示评论数量*/
                helper.setVisible(R.id.num_tv, false);
            } else {
                /*、新闻*/
                helper.setText(R.id.num_tv, item.comment_count + UIUtils.getString(R.string.comment));
                if (!TextUtils.isEmpty(item.label) && item.label.equals(UIUtils.getString(R.string.top))) {
                    /*置顶新闻*/
                    helper.setTextColor(R.id.tag_tv, UIUtils.getColor(R.color.news_tag_border_red));
                    helper.setText(R.id.tag_tv, item.label);
                } else {
                    helper.setVisible(R.id.tag_tv, false);
                }
            }
        }
        switch (helper.getItemViewType()) {
            case News.TEXT:
                break;
            case News.CENTER_ONE_PIC:
                if (item.has_video) {
                    /*中间视频*/
                    GlideUtils.load(mContext, item.middle_image.url, helper.getView(R.id.video_bg_iv));
                    helper.setText(R.id.video_time_tv, TimeUtils.sec2Formate(item.video_duration));
                    helper.setVisible(R.id.play_video_iv, true);
                }else {
                    /*中间大图组*/
                    GlideUtils.load(mContext, item.image_list.get(0).url, helper.getView(R.id.video_bg_iv));
                    helper.setText(R.id.video_time_tv, item.gallary_image_count+"图");
                    /*懒加载drawable，不用每次生成drawble占用内存*/
                    drawable = getDrawable(R.mipmap.ic_group_pics);
                    ((TextView)helper.getView(R.id.video_time_tv)).setCompoundDrawables(drawable, null, null, null);
                    helper.setVisible(R.id.play_video_iv, false);
                }
                break;
            case  News.RIGHT_ONE_PIC:
                GlideUtils.load(mContext, item.middle_image.url, helper.getView(R.id.right_video_bg_iv));
                if (item.has_video) {
                    /*、右侧视频*/
                    helper.setVisible(R.id.time_bg_ll, true);
                    helper.setText(R.id.video_time_tv, TimeUtils.sec2Formate(item.video_duration));

                }else {
                    /*、右侧图片文章*/
                    helper.setVisible(R.id.time_bg_ll, false);
                }
                break;
            case News.CENTER_THREE_PIC:
                GlideUtils.load(mContext, item.image_list.get(0).url, helper.getView(R.id.img1_iv));
                GlideUtils.load(mContext, item.image_list.get(1).url, helper.getView(R.id.img2_iv));
                GlideUtils.load(mContext, item.image_list.get(2).url, helper.getView(R.id.img3_iv));
                break;
            case News.LAST_REFRESH_POSITION:
                /*上次浏览记录位置*/
                helper.setText(R.id.last_refresh_tv, TimeUtils.getFormatTime(refresh_time*1000)+UIUtils.getString(R.string.last_refresh_tips));
                break;
            default:
                break;
        }
    }


    @Override
    protected int getDefItemViewType(int position) {
        News news = mData.get(position);
        LogUtils.d("position","has_video"+":"+news.has_video+":"+"video_style"+":"+news.video_style);
        /*上次刷新位置*/
        if (news.refresh_record)
            return News.LAST_REFRESH_POSITION;
        if (news.has_video) {

            if (news.video_style == 0) {
                /*右侧视频*/
                return News.RIGHT_ONE_PIC;
            }
            /*居中视频*/
            if (news.video_style == 2) {
                return News.CENTER_ONE_PIC;
            }
        }else {

            if (!news.has_image) {
                /*纯文字*/
                return News.TEXT;
            }

            /*右侧图片*/
            if (null ==news.image_list||news.image_list.size() == 0 ) {
                return News.RIGHT_ONE_PIC;
            }

            /*、中间大图*/
            if (news.image_list.size() == 1) {
                return News.CENTER_ONE_PIC;
            }
            /*中间三图*/
            if (news.image_list.size() == 3) {
                return News.CENTER_THREE_PIC;
            }


        }

        return News.TEXT;
    }


    private Drawable getDrawable(int resID) {
        if (null == drawable) {
            drawable = UIUtils.getResource().getDrawable(resID);
        /*不设置bounds不显示*/
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        }
        return drawable;
    }
}
