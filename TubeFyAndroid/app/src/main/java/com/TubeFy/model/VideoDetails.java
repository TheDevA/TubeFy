package com.TubeFy.model;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class VideoDetails {

    private String videoId;
    private String title;
    private int lengthSeconds;
    private List<String> keywords;
    private String shortDescription;
    private List<String> thumbnails;
    private String author;
    private long viewCount;
    private int averageRating;
    private boolean isLiveContent;

    public VideoDetails() {
    }

    public VideoDetails(JSONObject json) {
        videoId = json.getString("videoId");
        title = json.getString("title");
        lengthSeconds = json.getIntValue("lengthSeconds");
        keywords = json.containsKey("keywords") ? json.getJSONArray("keywords").toJavaList(String.class) : new ArrayList<String>();
        shortDescription = json.getString("shortDescription");
        JSONArray jsonThumbnails = json.getJSONObject("thumbnail").getJSONArray("thumbnails");
        thumbnails = new ArrayList<>(jsonThumbnails.size());
        for (int i = 0; i < jsonThumbnails.size(); i++) {
            JSONObject jsonObject = jsonThumbnails.getJSONObject(i);
            if (jsonObject.containsKey("url"))
                thumbnails.add(jsonObject.getString("url"));
        }
        averageRating = json.getIntValue("averageRating");
        viewCount = json.getLongValue("viewCount");
        author = json.getString("author");
        isLiveContent = json.getBooleanValue("isLiveContent");
    }

    public String videoId() {
        return videoId;
    }

    public String title() {
        return title;
    }

    public int lengthSeconds() {
        return lengthSeconds;
    }

    public List<String> keywords() {
        return keywords;
    }

    public String description() {
        return shortDescription;
    }

    public List<String> thumbnails() {
        return thumbnails;
    }

    public String author() {
        return author;
    }

    public long viewCount() {
        return viewCount;
    }

    public int averageRating() {
        return averageRating;
    }

    public boolean isLive() {
        return isLiveContent;
    }
}
