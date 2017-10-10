package com.jastyle.fullstack.model.entity.NewsDetail;

import com.google.gson.Gson;

import java.io.Serializable;

/**
 * author jastyle
 * description:
 * date 2017/9/30  下午4:38
 */

public class NewsDetail implements Serializable{


    /**
     * _ck : {}
     * data : {"detail_source":"发现世界","media_user":{"avatar_url":"http://p1.pstatp.com/thumb/411000674c8942528d2","no_display_pgc_icon":false,"id":"6347463786","screen_name":"发现世界"},"publish_time":1493009672,"title":"肌肉萎缩到只剩骨头的他，拍下真实照片，证明外表不是一切","url":"http://toutiao.com/group/6412425045356347650/","is_original":false,"is_pgc_article":true,"content":"<p>\n\n<p><img src=\"http://p1.pstatp.com/large/1c6900016738df96eb18\" img_width=\"673\" img_height=\"430\" inline=\"0\" alt=\"肌肉萎缩到只剩骨头的他，拍下真实照片，证明外表不是一切\" onerror=\"javascript:errorimg.call(this);\"><\/p><p>托斯坦，一位挪威励志演讲家、旅行家。他的体重跟一个孩子差不多，严重的脊髓性肌肉萎缩症让他只剩下骨头。<\/p>\n\n<p><img src=\"http://p1.pstatp.com/large/1c6b00015f097515e944\" img_width=\"673\" img_height=\"398\" inline=\"0\" alt=\"肌肉萎缩到只剩骨头的他，拍下真实照片，证明外表不是一切\" onerror=\"javascript:errorimg.call(this);\"><\/p><p>他不能走路，永远躺着。不过他喜欢笑，勇敢面对生活，还在欧洲各地演讲，激励无数人。<\/p>\n\n<p><img src=\"http://p3.pstatp.com/large/1c680003ee3e0668b8a9\" img_width=\"672\" img_height=\"398\" inline=\"0\" alt=\"肌肉萎缩到只剩骨头的他，拍下真实照片，证明外表不是一切\" onerror=\"javascript:errorimg.call(this);\"><\/p><p>托斯坦喜欢旅行，每年都要出去几次，冬天到来，就算躺着也要滑雪。<\/p>\n\n<p><img src=\"http://p1.pstatp.com/large/1c6e00014a4ace373ab3\" img_width=\"673\" img_height=\"411\" inline=\"0\" alt=\"肌肉萎缩到只剩骨头的他，拍下真实照片，证明外表不是一切\" onerror=\"javascript:errorimg.call(this);\"><\/p><p>他拍下自己的真实照片，证明外表不是一切。他很忙，演讲、旅行、参与政治。他做的事情比绝大多数身体健康的人还多。<\/p>\n\n<p><img src=\"http://p3.pstatp.com/large/1c6b00015f1827d1e9f6\" img_width=\"672\" img_height=\"430\" inline=\"0\" alt=\"肌肉萎缩到只剩骨头的他，拍下真实照片，证明外表不是一切\" onerror=\"javascript:errorimg.call(this);\"><\/p><p>事实证明，一个人的身体不一定决定一个人可以做多少。我们看到太多身残志坚的人。<\/p>\n\n<p><img src=\"http://p3.pstatp.com/large/1c690001674b33f0b8c2\" img_width=\"665\" img_height=\"375\" inline=\"0\" alt=\"肌肉萎缩到只剩骨头的他，拍下真实照片，证明外表不是一切\" onerror=\"javascript:errorimg.call(this);\"><\/p><p>托斯坦躺在树林的草地上，同伴用镜头记录他。<\/p>\n\n<p><img src=\"http://p3.pstatp.com/large/1c680003ee49a308ec9a\" img_width=\"669\" img_height=\"400\" inline=\"0\" alt=\"肌肉萎缩到只剩骨头的他，拍下真实照片，证明外表不是一切\" onerror=\"javascript:errorimg.call(this);\"><\/p><p>这些照片看着触目惊心，在很多人看来，他让人害怕。可得知他的故事后，大家无不佩服。<\/p>\n\n<p><img src=\"http://p9.pstatp.com/large/1c6a000281005e572f29\" img_width=\"666\" img_height=\"383\" inline=\"0\" alt=\"肌肉萎缩到只剩骨头的他，拍下真实照片，证明外表不是一切\" onerror=\"javascript:errorimg.call(this);\"><\/p><p>托斯坦30岁了，医生对他健康状况持否定态度，他明白自己生命不会太长。但他头脑清醒，在每天做够想做的事。如果说这个世界还有一位霍金，非托斯坦莫属。<\/p>\n<\/p>","source":"发现世界","comment_count":538,"video_play_count":0}
     * success : true
     */

    private CkBean _ck;
    private DataBean data;
    private boolean success;

    public CkBean get_ck() {
        return _ck;
    }

    public void set_ck(CkBean _ck) {
        this._ck = _ck;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public static class CkBean implements Serializable{
    }

    public static class DataBean implements Serializable{
        /**
         * detail_source : 发现世界
         * media_user : {"avatar_url":"http://p1.pstatp.com/thumb/411000674c8942528d2","no_display_pgc_icon":false,"id":"6347463786","screen_name":"发现世界"}
         * publish_time : 1493009672
         * title : 肌肉萎缩到只剩骨头的他，拍下真实照片，证明外表不是一切
         * url : http://toutiao.com/group/6412425045356347650/
         * is_original : false
         * is_pgc_article : true
         * content : <p>

         <p><img src="http://p1.pstatp.com/large/1c6900016738df96eb18" img_width="673" img_height="430" inline="0" alt="肌肉萎缩到只剩骨头的他，拍下真实照片，证明外表不是一切" onerror="javascript:errorimg.call(this);"></p><p>托斯坦，一位挪威励志演讲家、旅行家。他的体重跟一个孩子差不多，严重的脊髓性肌肉萎缩症让他只剩下骨头。</p>

         <p><img src="http://p1.pstatp.com/large/1c6b00015f097515e944" img_width="673" img_height="398" inline="0" alt="肌肉萎缩到只剩骨头的他，拍下真实照片，证明外表不是一切" onerror="javascript:errorimg.call(this);"></p><p>他不能走路，永远躺着。不过他喜欢笑，勇敢面对生活，还在欧洲各地演讲，激励无数人。</p>

         <p><img src="http://p3.pstatp.com/large/1c680003ee3e0668b8a9" img_width="672" img_height="398" inline="0" alt="肌肉萎缩到只剩骨头的他，拍下真实照片，证明外表不是一切" onerror="javascript:errorimg.call(this);"></p><p>托斯坦喜欢旅行，每年都要出去几次，冬天到来，就算躺着也要滑雪。</p>

         <p><img src="http://p1.pstatp.com/large/1c6e00014a4ace373ab3" img_width="673" img_height="411" inline="0" alt="肌肉萎缩到只剩骨头的他，拍下真实照片，证明外表不是一切" onerror="javascript:errorimg.call(this);"></p><p>他拍下自己的真实照片，证明外表不是一切。他很忙，演讲、旅行、参与政治。他做的事情比绝大多数身体健康的人还多。</p>

         <p><img src="http://p3.pstatp.com/large/1c6b00015f1827d1e9f6" img_width="672" img_height="430" inline="0" alt="肌肉萎缩到只剩骨头的他，拍下真实照片，证明外表不是一切" onerror="javascript:errorimg.call(this);"></p><p>事实证明，一个人的身体不一定决定一个人可以做多少。我们看到太多身残志坚的人。</p>

         <p><img src="http://p3.pstatp.com/large/1c690001674b33f0b8c2" img_width="665" img_height="375" inline="0" alt="肌肉萎缩到只剩骨头的他，拍下真实照片，证明外表不是一切" onerror="javascript:errorimg.call(this);"></p><p>托斯坦躺在树林的草地上，同伴用镜头记录他。</p>

         <p><img src="http://p3.pstatp.com/large/1c680003ee49a308ec9a" img_width="669" img_height="400" inline="0" alt="肌肉萎缩到只剩骨头的他，拍下真实照片，证明外表不是一切" onerror="javascript:errorimg.call(this);"></p><p>这些照片看着触目惊心，在很多人看来，他让人害怕。可得知他的故事后，大家无不佩服。</p>

         <p><img src="http://p9.pstatp.com/large/1c6a000281005e572f29" img_width="666" img_height="383" inline="0" alt="肌肉萎缩到只剩骨头的他，拍下真实照片，证明外表不是一切" onerror="javascript:errorimg.call(this);"></p><p>托斯坦30岁了，医生对他健康状况持否定态度，他明白自己生命不会太长。但他头脑清醒，在每天做够想做的事。如果说这个世界还有一位霍金，非托斯坦莫属。</p>
         </p>
         * source : 发现世界
         * comment_count : 538
         * video_play_count : 0
         */

        private String detail_source;
        private MediaUserBean media_user;
        private int publish_time;
        private String title;
        private String url;
        private boolean is_original;
        private boolean is_pgc_article;
        private String content;
        private String source;
        private int comment_count;
        private int video_play_count;

        public String getDetail_source() {
            return detail_source;
        }

        public void setDetail_source(String detail_source) {
            this.detail_source = detail_source;
        }

        public MediaUserBean getMedia_user() {
            return media_user;
        }

        public void setMedia_user(MediaUserBean media_user) {
            this.media_user = media_user;
        }

        public int getPublish_time() {
            return publish_time;
        }

        public void setPublish_time(int publish_time) {
            this.publish_time = publish_time;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isIs_original() {
            return is_original;
        }

        public void setIs_original(boolean is_original) {
            this.is_original = is_original;
        }

        public boolean isIs_pgc_article() {
            return is_pgc_article;
        }

        public void setIs_pgc_article(boolean is_pgc_article) {
            this.is_pgc_article = is_pgc_article;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public int getComment_count() {
            return comment_count;
        }

        public void setComment_count(int comment_count) {
            this.comment_count = comment_count;
        }

        public int getVideo_play_count() {
            return video_play_count;
        }

        public void setVideo_play_count(int video_play_count) {
            this.video_play_count = video_play_count;
        }

        public static class MediaUserBean implements Serializable{
            /**
             * avatar_url : http://p1.pstatp.com/thumb/411000674c8942528d2
             * no_display_pgc_icon : false
             * id : 6347463786
             * screen_name : 发现世界
             */

            private String avatar_url;
            private boolean no_display_pgc_icon;
            private String id;
            private String screen_name;

            public String getAvatar_url() {
                return avatar_url;
            }

            public void setAvatar_url(String avatar_url) {
                this.avatar_url = avatar_url;
            }

            public boolean isNo_display_pgc_icon() {
                return no_display_pgc_icon;
            }

            public void setNo_display_pgc_icon(boolean no_display_pgc_icon) {
                this.no_display_pgc_icon = no_display_pgc_icon;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getScreen_name() {
                return screen_name;
            }

            public void setScreen_name(String screen_name) {
                this.screen_name = screen_name;
            }
        }
    }
    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}
