package com.doordash.mvpexample.models;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Restaurant {

    @SerializedName("status")
    String status;

    @SerializedName("asap_time")
    int asapTime;

    @SerializedName("name")
    String name;

    @SerializedName("tags")
    String[] tags;

    @SerializedName("cover_img_url")
    String coverImageUrl;

    public String getStatus() {
        return status;
    }

    public int getAsapTime() {
        return asapTime;
    }

    public String getName() {
        return name;
    }

    public String[] getTags() {
        return tags;
    }

    public String getCoverImageUrl() {
        return coverImageUrl;
    }
}
