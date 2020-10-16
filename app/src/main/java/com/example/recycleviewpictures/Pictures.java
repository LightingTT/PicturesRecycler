package com.example.recycleviewpictures;
import com.google.gson.annotations.SerializedName;

/*
 * Class responsible for building objects from deserialized data.
 *
 */

public class Pictures {

    @SerializedName("picture")
    private String imageUrl;

    public Pictures (String picturesUrl)
    {
        this.imageUrl = picturesUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String picturesUrl) {
        this.imageUrl = picturesUrl;
    }
}
