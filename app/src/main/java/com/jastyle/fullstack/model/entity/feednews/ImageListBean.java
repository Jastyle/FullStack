package com.jastyle.fullstack.model.entity.feednews;

import java.util.List;

/**
 * author jastyle
 * description:
 * date 2017/9/26  下午1:46
 */

public class ImageListBean {
    /**
     * url : http://p3.pstatp.com/list/300x196/3c60000207921d875bf2.webp
     * width : 638
     * url_list : [{"url":"http://p3.pstatp.com/list/300x196/3c60000207921d875bf2.webp"},{"url":"http://pb9.pstatp.com/list/300x196/3c60000207921d875bf2.webp"},{"url":"http://pb1.pstatp.com/list/300x196/3c60000207921d875bf2.webp"}]
     * uri : list/3c60000207921d875bf2
     * height : 358
     */

    public String url;
    public int width;
    public String uri;
    public int height;
    public List<UrlListBean> url_list;

}
