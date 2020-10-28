/*
 * Copyright (c) 2020. by Piotr Zaremba
 */

package com.example.recycleviewpictures.Requests;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.recycleviewpictures.Requests.Responsnes.Pictures;

import java.util.List;

public class PictureApiClient {

    private static PictureApiClient instance;
    private MutableLiveData<List<Pictures>> pictures;

    public static PictureApiClient getInstance()
    {
        if(instance == null)
        {
            instance = new PictureApiClient();
        }
        return instance;
    }

    private PictureApiClient(){
        pictures = new MutableLiveData<>();

    }
    public LiveData<List<Pictures>> getPictures(){
        return pictures;
    }


}
