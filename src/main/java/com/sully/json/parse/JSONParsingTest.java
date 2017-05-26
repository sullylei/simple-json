package com.sully.json.parse;

import com.sully.json.model.LatestNews;
import com.sully.json.util.HttpUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Creator: lei.s
 * Create Date: 2017年05月26日
 * 类功能描述：从知乎获取今日的数据，然后解析封装成对象
 */
public class JSONParsingTest {
    //从知乎获取数据
    public static final String urlString = "http://news-at.zhihu.com/api/4/news/latest";

    public static void main(String[] args) {
        try {
            String jsonString = new String(HttpUtil.get(urlString));
            System.out.println("jsonString:"+jsonString);
            JSONObject latestNewsJSON = new JSONObject(jsonString);
            String date = latestNewsJSON.getString("date");
            JSONArray top_storiesJSON = latestNewsJSON.getJSONArray("top_stories");
            System.out.println(top_storiesJSON);
            LatestNews latest = new LatestNews();

            List<LatestNews.TopStory> topStories = new ArrayList<LatestNews.TopStory>();

            for (int i = 0; i < top_storiesJSON.length(); i++) {
                LatestNews.TopStory topStory = new LatestNews.TopStory();
                topStory.setId(((JSONObject) top_storiesJSON.get(i)).getInt("id"));
                topStory.setType(((JSONObject) top_storiesJSON.get(i)).getInt("type"));
                topStory.setImage(((JSONObject) top_storiesJSON.get(i)).getString("image"));
                topStory.setTitle(((JSONObject) top_storiesJSON.get(i)).getString("title"));
                topStories.add(topStory);
            }
            latest.setDate(date);

            System.out.println("date: " + latest.getDate());
            for (int i = 0; i < topStories.size(); i++) {
                System.out.println(topStories.get(i));
            }

            System.out.println("------------------------------");
            JSONArray storiesJSON = latestNewsJSON.getJSONArray("stories");
            List<LatestNews.Story> stories = new ArrayList<LatestNews.Story>();
            for (int i = 0; i < storiesJSON.length(); i++) {
                LatestNews.Story story = new LatestNews.Story();
                List<String> images = new ArrayList<String>();
                story.setId(((JSONObject) storiesJSON.get(i)).getInt("id"));
                story.setType(((JSONObject) storiesJSON.get(i)).getInt("type"));
                JSONArray imagesArray = ((JSONObject) storiesJSON.get(i)).getJSONArray("images");
                System.out.println("imagesArray*****:"+imagesArray.length());
                for(int n=0;n<imagesArray.length();n++){
                    images.add((String) imagesArray.get(n));
                }
                story.setImages(images);
                story.setTitle(((JSONObject) storiesJSON.get(i)).getString("title"));
                stories.add(story);
            }
            for (int i = 0; i < topStories.size(); i++) {
                System.out.println(stories.get(i));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
