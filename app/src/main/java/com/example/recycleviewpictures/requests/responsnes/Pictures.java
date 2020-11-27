/*
 * Copyright (c) 2020. by Piotr Zaremba
 */

package com.example.recycleviewpictures.requests.responsnes;

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

    public Pictures() {
    }

    public Pictures(String id, String author, Integer width, Integer height, String url, String downloadUrl) {
        this.id = id;
        this.author = author;
        this.width = width;
        this.height = height;
        this.url = url;
        this.download_url = downloadUrl;
    }

    public String getId() {
        return id;
    }
    public String getAuthor() {
        return author;
    }
    public String getDownloadUrl() {
        return download_url;
    }


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
}