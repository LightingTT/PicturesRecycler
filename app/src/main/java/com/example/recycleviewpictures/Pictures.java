package com.example.recycleviewpictures;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pictures {

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

    public String getUrl() {
        return url;
    }

    public String getDownloadUrl() {
        return download_url;
    }



}
