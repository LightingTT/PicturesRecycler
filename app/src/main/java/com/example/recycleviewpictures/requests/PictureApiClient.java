/*
 * Copyright (c) 2020. by Piotr Zaremba
 */

package com.example.recycleviewpictures.requests;

import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.recycleviewpictures.requests.responsnes.Pictures;
import com.example.recycleviewpictures.utils.Constants;
import java.util.Collections;
import java.util.List;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
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

        ServiceGenerator.getApiService()
                .getPictureListApiRx(page, limit)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe(new SingleObserver<List<Pictures>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<Pictures> value) {
                        picturesLiveData.postValue(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        picturesLiveData.postValue(Collections.emptyList());
                    }
                });
    }

    private class RetrievePicturesRunnable implements Runnable
    {
        private final String page;
        private final String limit;

        public RetrievePicturesRunnable(String page, String limit) {
            this.page = page;
            this.limit = limit;
        }

        @Override
        public void run() {
            ApiService apiService = ServiceGenerator.getApiService();
            Call<List<Pictures>> responseCall = apiService.getPictureListApi(page, limit);
            responseCall.enqueue(new Callback<List<Pictures>>() {
                @Override
                public void onResponse(Call<List<Pictures>> call, Response<List<Pictures>> response) {
                    Log.d(Constants.TAG, "onResponse: Server response: " + response.toString());
                    List<Pictures> imageList = response.body();
                    Log.d(Constants.TAG, "onResponse: " + response.body().toString());
                    for (Pictures picture : imageList) {
                        Log.d(Constants.TAG, "onResponse: " + picture.getDownloadUrl()); // log purposes
                    }
                    picturesLiveData.postValue(imageList);
                }

                @Override
                public void onFailure(Call<List<Pictures>> call, Throwable t) {
                }
            });
        }
    }
}
