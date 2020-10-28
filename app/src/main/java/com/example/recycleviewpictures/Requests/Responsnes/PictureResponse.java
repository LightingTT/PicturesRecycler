/*
 * Copyright (c) 2020. by Piotr Zaremba
 */

package com.example.recycleviewpictures.Requests.Responsnes;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/*
 * This is the class that would hold object responses from responses we retrieve from retrofit.
 */

public class PictureResponse {

    @SerializedName("picture")
    @Expose
    private Pictures picture;

    public Pictures getPictureResponsess() {
        return picture;
    }


    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
