package com.jastyle.fullstack.model.entity.feednews;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * author jastyle
 * description:
 * date 2017/9/25  下午4:58
 */

public class News implements MultiItemEntity{
    /*纯文字*/
    public static final int TEXT = 1;
    /*中间大图，广告、视频、图片组*/
    public static final int CENTER_ONE_PIC = 2;
    /*广告、文章*/
    public static final int CENTER_THREE_PIC =3;
    /*广告、文章、视频*/
    public static final int RIGHT_ONE_PIC = 4;
    /*微头条*/
    public static final int TINY_TOUTIAO = 5;
    /*上次刷新的位置*/
    public static final int LAST_REFRESH_POSITION = 6;
    public static final int DEFAULT_TYPE = -1;

    /**
     * log_pb : {"impr_id":"20170925175111010008017103536372"}
     * read_count : 12121
     * media_name : 时尚服装资讯
     * ban_comment : 0
     * abstract : 这两天，宝宝可谓是让人“大快朵颐”，从马蓉出轨到宋喆被抓，再到新闻爆出“马蓉称跟宝宝还有感情”，接着是马蓉向宝宝求情，然后又是马蓉可能面临3年的牢狱，成了马蓉他妈向宝宝求情。前两天，宋喆被抓的案件爆出后，大家直呼大快人心。
     * image_list : [{"url":"http://p3.pstatp.com/list/300x196/3c60000207921d875bf2.webp","width":638,"url_list":[{"url":"http://p3.pstatp.com/list/300x196/3c60000207921d875bf2.webp"},{"url":"http://pb9.pstatp.com/list/300x196/3c60000207921d875bf2.webp"},{"url":"http://pb1.pstatp.com/list/300x196/3c60000207921d875bf2.webp"}],"uri":"list/3c60000207921d875bf2","height":358},{"url":"http://p1.pstatp.com/list/300x196/3c610001fdc5d0852fe8.webp","width":800,"url_list":[{"url":"http://p1.pstatp.com/list/300x196/3c610001fdc5d0852fe8.webp"},{"url":"http://pb3.pstatp.com/list/300x196/3c610001fdc5d0852fe8.webp"},{"url":"http://pb9.pstatp.com/list/300x196/3c610001fdc5d0852fe8.webp"}],"uri":"list/3c610001fdc5d0852fe8","height":450},{"url":"http://p3.pstatp.com/list/300x196/3c6000020872d0bb68f5.webp","width":751,"url_list":[{"url":"http://p3.pstatp.com/list/300x196/3c6000020872d0bb68f5.webp"},{"url":"http://pb9.pstatp.com/list/300x196/3c6000020872d0bb68f5.webp"},{"url":"http://pb1.pstatp.com/list/300x196/3c6000020872d0bb68f5.webp"}],"uri":"list/3c6000020872d0bb68f5","height":422}]
     * ugc_recommend : {"reason":"","activity":""}
     * article_type : 0
     * tag : news_entertainment
     * forward_info : {"forward_count":0}
     * has_m3u8_video : 0
     * keywords : 王宝强,马蓉,宋喆,蒙冤受屈,爸爸去哪儿
     * rid : 20170925175111010008017103536372
     * show_portrait_article : false
     * user_verified : 0
     * aggr_type : 1
     * cell_type : 0
     * article_sub_type : 0
     * bury_count : 0
     * title : 宋喆落网，马蓉发旧照求原谅，王宝强：我要查一下当年的车祸！
     * ignore_web_transform : 1
     * source_icon_style : 1
     * tip : 0
     * hot : 0
     * share_url : http://m.toutiao.com/a6469561657713492494/?iid=15274237562&app=news_article
     * has_mp4_video : 0
     * source : 时尚服装资讯
     * comment_count : 7
     * article_url : http://toutiao.com/group/6469561657713492494/
     * filter_words : [{"id":"8:0","name":"看过了","is_selected":false},{"id":"9:1","name":"内容太水","is_selected":false},{"id":"5:1496615797","name":"拉黑作者:时尚服装资讯","is_selected":false},{"id":"3:264323920","name":"不想看:婚外情","is_selected":false},{"id":"6:17616","name":"不想看:王宝强","is_selected":false}]
     * share_count : 9
     * publish_time : 1506312205
     * action_list : [{"action":1,"extra":{},"desc":""},{"action":3,"extra":{},"desc":""},{"action":7,"extra":{},"desc":""},{"action":9,"extra":{},"desc":""}]
     * gallary_image_count : 6
     * cell_layout_style : 1
     * tag_id : 6469561657713493000
     * video_style : 0
     * verified_content :
     * display_url : http://toutiao.com/group/6469561657713492494/
     * large_image_list : []
     * media_info : {"user_id":55154615084,"verified_content":"","avatar_url":"http://p1.pstatp.com/large/382c000c60b1bccc8322","media_id":1577163605118990,"name":"时尚服装资讯","recommend_type":0,"follow":false,"recommend_reason":"","is_star_user":false,"user_verified":false}
     * item_id : 6469561657713493000
     * is_subject : false
     * show_portrait : false
     * repin_count : 28
     * cell_flag : 11
     * user_info : {"verified_content":"","avatar_url":"http://p1.pstatp.com/large/382c000c60b1bccc8322","user_id":55154615084,"name":"时尚服装资讯","follower_count":0,"follow":false,"user_auth_info":"","user_verified":false,"description":"在这里你能找到你的气质和美丽！"}
     * source_open_url : sslocal://profile?uid=55154615084
     * level : 0
     * like_count : 1
     * digg_count : 1
     * behot_time : 1506331011
     * cursor : 1506331011999
     * url : http://toutiao.com/group/6469561657713492494/
     * preload_web : 1
     * user_repin : 0
     * has_image : true
     * item_version : 0
     * has_video : false
     * group_id : 6469561657713493000
     * middle_image : {"url":"http://p3.pstatp.com/list/300x196/3c60000207921d875bf2.webp","width":638,"url_list":[{"url":"http://p3.pstatp.com/list/300x196/3c60000207921d875bf2.webp"},{"url":"http://pb9.pstatp.com/list/300x196/3c60000207921d875bf2.webp"},{"url":"http://pb1.pstatp.com/list/300x196/3c60000207921d875bf2.webp"}],"uri":"list/3c60000207921d875bf2","height":358}
     */

    public LogPbBean log_pb;
    public int read_count;
    public String media_name;
    public int ban_comment;
    @SerializedName("abstract")
    public String abstractX;
//    public UgcRecommendBean ugc_recommend;
    public int article_type;
    public String tag;
    public ForwardInfoBean forward_info;
    public int has_m3u8_video;
    public String keywords;
    public String label;
    public String rid;
    public boolean show_portrait_article;
    public int user_verified;
    public int aggr_type;
    public int cell_type;
    public int article_sub_type;
    public int bury_count;
    public String title;
    public int ignore_web_transform;
    public int source_icon_style;
    public int tip;
    public int hot;
    public String share_url;
    public int has_mp4_video;
    public String source;
    public int comment_count;
    public String article_url;
    public int share_count;
    public int publish_time;
    public int gallary_image_count;
    public int cell_layout_style;
    public long tag_id;
    public int video_style;
    public String verified_content;
    public String display_url;
    public MediaInfoBean media_info;
    public long item_id;
    public boolean is_subject;
    public boolean show_portrait;
    public int repin_count;
    public int cell_flag;
    public UserInfoBean user_info;
    public String source_open_url;
    public int level;
    public int like_count;
    public int digg_count;
    public long behot_time;
    public long cursor;
    public String url;
    public int preload_web;
    public int user_repin;
    public boolean has_image;
    public boolean refresh_record;
    public int item_version;
    public boolean has_video;
    public int video_duration;
    public long group_id;
    public MiddleImageBean middle_image;
    public List<ImageListBean> image_list;
    public List<FilterWordsBean> filter_words;
    public List<ActionListBean> action_list;
    public List<LargeImageListBean> large_image_list;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    @Override
    public int getItemType() {
        return 0;
    }
}
