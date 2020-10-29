/*
 * Copyright (c) 2020. by Piotr Zaremba
 */

package com.example.recycleviewpictures.Requests;

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

    public static PictureApiClient getInstance()
    {
        if(instance == null)
        {
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

    public void picturesAPI(String page, String limit)
    {
        if(retrievePicturesRunnable != null) {
            retrievePicturesRunnable = null;
        }
        retrievePicturesRunnable = new RetrievePicturesRunnable(page, limit);
        final Future handler = AppExecutors
                .getInstance()
                .getNetworkIO()
                .submit(retrievePicturesRunnable);

        AppExecutors.getInstance().getNetworkIO().schedule(new Runnable() {
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
    boolean cancelRequest;

    public RetrievePicturesRunnable(String page, String limit) {
        this.page = page;
        this.limit = limit;
        cancelRequest = false;
    }

    @Override
    public void run() {
        Call<List<Pictures>> responseCall = getPictures(page, limit);
        responseCall.enqueue(new Callback<List<Pictures>>() {
            @Override
            public void onResponse(Call<List<Pictures>> call, Response<List<Pictures>> response) {
                Log.d(Constants.TAG, "onResponse: Server response: " + response.toString());
                List<Pictures> imageList = response.body();
                if(page == "2")
                {
                    picturesLiveData.postValue(imageList);
                }else
                {
                    //Tutaj moze byc zjebane, dodaje jeden obiekt a wyzej dodaje cala liste.
                    List<Pictures> currentList = picturesLiveData.getValue();
                    currentList.add(new Pictures()); // <--
                    picturesLiveData.postValue(currentList);
                }
            }

            @Override
            public void onFailure(Call<List<Pictures>> call, Throwable t) {

            }
        });
        if(cancelRequest) {
            return;
        }
    }

    private Call<List<Pictures>> getPictures(String page, String limit)
    {
        return ServiceGenerator.getApiService().getPictureListApi(page, limit);
    }

    private void cancelRequest()
    {
        Log.d(Constants.TAG, "cancelRequest: cacneling the search request");
        cancelRequest = true;
    }
}



}
