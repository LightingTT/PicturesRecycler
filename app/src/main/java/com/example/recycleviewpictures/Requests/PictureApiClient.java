/*
 * Copyright (c) 2020. by Piotr Zaremba
 */

package com.example.recycleviewpictures.Requests;

import android.graphics.Picture;
import android.os.Build;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.recycleviewpictures.AppExecutors;
import com.example.recycleviewpictures.Requests.Responsnes.Pictures;
import com.example.recycleviewpictures.Utils.Constants;

import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PictureApiClient {

    private static PictureApiClient instance;
    private MutableLiveData<List<Pictures>> picturesLiveData;
    private RetrievePicturesRunnable retrievePicturesRunnable;

    public static PictureApiClient getInstance() {
        if(instance == null) {
            instance = new PictureApiClient();
        }
        return instance;
    }

    private PictureApiClient(){
        picturesLiveData = new MutableLiveData<>();
    }

    public LiveData<List<Pictures>> getPictures(){
        return picturesLiveData;
    }

    public void picturesAPI(String page, String limit) {

        if(retrievePicturesRunnable != null) {
            retrievePicturesRunnable = null;
        }
        retrievePicturesRunnable = new RetrievePicturesRunnable(page, limit);
        final Future handler = AppExecutors
                .getInstance()
                .getNetworkIO()
                .submit(retrievePicturesRunnable);

        AppExecutors
                .getInstance()
                .getNetworkIO()
                .schedule(new Runnable() {
            @Override
            public void run() {
                // Let the user know its timed out
                handler.cancel(true);
            }
        }, Constants.NETWORK_TIMEOUT, TimeUnit.MILLISECONDS);
    }

private class RetrievePicturesRunnable implements Runnable
{
    private String page;
    private String limit;


    public RetrievePicturesRunnable(String page, String limit) {
        this.page = page;
        this.limit = limit;
    }

    @Override
    public void run() {
        ApiService apiService = ServiceGenerator.getApiService();
        Call<List<Pictures>> responseCall =apiService.getPictureListApi(page, limit);
        responseCall.enqueue(new Callback<List<Pictures>>() {
            @Override
            public void onResponse(Call<List<Pictures>> call, Response<List<Pictures>> response) {
                Log.d(Constants.TAG, "onResponse: Server response: " + response.toString());
                List<Pictures> imageList = response.body();
                Log.d(Constants.TAG, "onResponse: " + response.body().toString());
                for(Pictures picture : imageList){
                    Log.d(Constants.TAG, "onResponse: " + picture.getDownloadUrl());
                }

                if(page == "1")
                {
                    picturesLiveData.postValue(imageList);
                }
                else
                {
                    //Tutaj jest zjebane, dodaje jeden obiekt a wyzej dodaje cala liste.
                    List<Pictures> currentList = picturesLiveData.getValue();
                    currentList.add(new Pictures()); // <--
                    picturesLiveData.postValue(currentList);
                }
            }

            @Override
            public void onFailure(Call<List<Pictures>> call, Throwable t) {
            }
        });
    }
}



}
