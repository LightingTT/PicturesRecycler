package com.example.recycleviewpictures;
import com.google.gson.annotations.SerializedName;

public class Pictures {

    @SerializedName("picture")
    private String picturesUrl;

    public Pictures (String picturesUrl)
    {
        this.picturesUrl = picturesUrl;
    }

    public String getImageUrl() {
        return picturesUrl;
    }

    public void setImageUrl(String picturesUrl) {
        this.picturesUrl = picturesUrl;
    }
}
