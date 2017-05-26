package com.sully.json.parse;

import com.google.gson.Gson;
import com.sully.json.model.LatestNews;
import com.sully.json.util.HttpUtil;

/**
 * Creator: lei.s
 * Create Date: 2017年05月26日
 * 类功能描述：
 */
public class GsonTest {
    public static final String urlString = "http://news-at.zhihu.com/api/4/news/latest";
    public static void main(String[] args) {
        LatestNews latest = new LatestNews();
        String jsonString = new String(HttpUtil.get(urlString));
        latest = (new Gson()).fromJson(jsonString, LatestNews.class);
        System.out.println(latest.getDate());
        for (int i = 0; i < latest.getTop_stories().size(); i++) {
            System.out.println(latest.getTop_stories().get(i));
        }
        System.out.println("#################");
        for(int i = 0; i < latest.getStories().size(); i++){
            System.out.println(latest.getStories().get(i).getId());
        }
    }

}
