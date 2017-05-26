package com.sully.json.model;

import java.io.Serializable;
import java.util.List;

/**
 * Creator: lei.s
 * Create Date: 2017年05月26日
 * 类功能描述：
 */
public class LatestNews {
    private String date;
    private List<TopStory> top_stories;
    private List<Story> stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<TopStory> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStory> top_stories) {
        this.top_stories = top_stories;
    }

    public List<Story> getStories() {
        return stories;
    }

    public void setStories(List<Story> stories) {
        this.stories = stories;
    }

    public static class TopStory {
        private String image;
        private int type;
        private int id;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        @Override
        public String toString() {
            return "TopStory{" +
                    "image='" + image + '\'' +
                    ", type=" + type +
                    ", id=" + id +
                    ", title='" + title + '\'' +
                    '}';
        }
    }

    public static class Story implements Serializable {
        private List<String> images;
        private int type;
        private int id;
        private String title;

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        @Override
        public String toString() {
            return "Story{" +
                    "images=" + images +
                    ", type=" + type +
                    ", id=" + id +
                    ", title='" + title + '\'' +
                    '}';
        }
    }

}
