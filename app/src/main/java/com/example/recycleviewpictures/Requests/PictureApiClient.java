/*
 * Copyright (c) 2020. by Piotr Zaremba
 */

package com.example.recycleviewpictures.Requests;

import android.os.Build;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.recycleviewpictures.AppExecutors;
import com.example.recycleviewpictures.Requests.Responsnes.Pictures;
import com.example.recycleviewpictures.Utils.Constants;

import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

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

    public void searchPicturesAPI()
    {
        final Future handler = AppExecutors
                .getInstance()
                .getNetworkIO()
                .submit()

        AppExecutors.getInstance().getNetworkIO().schedule(new Runnable() {
            @Override
            public void run() {
                // Let the user know its timed out
                handler.cancel(true);

            }
        }, Constants.NETWORK_TIMEOUT, TimeUnit.MILLISECONDS);
    }




}
