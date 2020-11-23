/*
 * Copyright (c) 2020. by Piotr Zaremba
 */

package com.example.recycleviewpictures.repositories;
import androidx.lifecycle.LiveData;

import com.example.recycleviewpictures.requests.PictureApiClient;
import com.example.recycleviewpictures.requests.responsnes.Pictures;
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

    //Gets liveData from ApiClient
    public LiveData<List<Pictures>> getPictures(){
        return pictureApiClient.getPictures();
    }

    public void picturesApi(String page, String limit) {
        if (page.equals("0")){
            page = "1";
        }
        pictureApiClient.picturesAPI(page, limit);
    }
}