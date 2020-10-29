/*
 * Copyright (c) 2020. by Piotr Zaremba
 */

package com.example.recycleviewpictures;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PicturesResponse {
    private Pictures pictures = new Pictures();

    public Pictures getPicturesFromPicturesResponse(){
        return pictures;
    }

    @Override
    public String toString() {
        return "PicturesResponse{" +
                "pictures=" + pictures +
                '}';
    }
}
