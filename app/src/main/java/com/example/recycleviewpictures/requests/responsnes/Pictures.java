/*
 * Copyright (c) 2020. by Piotr Zaremba
 */

package com.example.recycleviewpictures.requests.responsnes;
import android.os.Parcel;
import android.os.Parcelable;

import com.bumptech.glide.load.resource.drawable.DrawableResource;

import java.io.Serializable;

/*
 * Class responsible for building objects from deserialized data.
 */

public class Pictures implements Serializable {

    private String id;
    private String author;
    private Integer width;
    private Integer height;
    private String url;
    private String download_url;

    @Override
    public String toString() {
        return "Pictures{" +
                "id='" + id + '\'' +
                ", author='" + author + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", url='" + url + '\'' +
                ", downloadUrl='" + download_url + '\'' +
                '}';
    }

    public Pictures(String id, String author, Integer width, Integer height, String url, String downloadUrl) {
        this.id = id;
        this.author = author;
        this.width = width;
        this.height = height;
        this.url = url;
        this.download_url = downloadUrl;
    }

    public Pictures() {

    }
    public String getId() {
        return id;
    }
    public String getAuthor() {
        return author;
    }
    public Integer getWidth() {
        return width;
    }
    public Integer getHeight() {
        return height;
    }
    public String getUrl() { return url; }
    public String getDownloadUrl() {
        return download_url;
    }
}
