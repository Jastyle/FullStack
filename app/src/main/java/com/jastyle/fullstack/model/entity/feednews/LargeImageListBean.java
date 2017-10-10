package com.jastyle.fullstack.model.entity.feednews;

import java.util.List;

/**
 * author jastyle
 * description:
 * date 2017/9/26  下午2:01
 */

public class LargeImageListBean {
    /**
     * url : http://p1.pstatp.com/video1609/3b110002d3d155f4f9c9
     * width : 580
     * url_list : [{"url":"http://p1.pstatp.com/video1609/3b110002d3d155f4f9c9"},{"url":"http://pb3.pstatp.com/video1609/3b110002d3d155f4f9c9"},{"url":"http://pb9.pstatp.com/video1609/3b110002d3d155f4f9c9"}]
     * uri : video1609/3b110002d3d155f4f9c9
     * height : 326
     */

    public String url;
    public int width;
    public String uri;
    public int height;
    public List<UrlListBean> url_list;
}
