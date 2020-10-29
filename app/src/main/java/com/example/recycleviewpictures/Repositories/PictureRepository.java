/*
 * Copyright (c) 2020. by Piotr Zaremba
 */

package com.example.recycleviewpictures.Repositories;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.recycleviewpictures.Requests.PictureApiClient;
import com.example.recycleviewpictures.Requests.Responsnes.Pictures;
import java.util.List;

public class PictureRepository {
    private static PictureRepository instance;
    private PictureApiClient pictureApiClient;

    public static PictureRepository getInstance() {
        if(instance == null) {
            instance = new PictureRepository();
        }
        return instance;
    }

    public PictureRepository(){
        pictureApiClient = PictureApiClient.getInstance();
    }

    public LiveData<List<Pictures>> getPictures(){
        return pictureApiClient.getPictures();
    }
    public void picturesApi(String page, String limit)
    {
        if (page == "0"){
            page = "1";
        }
        pictureApiClient.picturesAPI(page, limit);
    }
}