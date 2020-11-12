/*
 * Copyright (c) 2020. by Piotr Zaremba
 */

package com.example.recycleviewpictures.requests;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.recycleviewpictures.requests.responsnes.Pictures;
import java.util.Collections;
import java.util.List;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PictureApiClient {

    private static PictureApiClient instance;
    private MutableLiveData<List<Pictures>> picturesLiveData;

    public static PictureApiClient getInstance() {
        if (instance == null) {
            instance = new PictureApiClient();
        }
        return instance;
    }

    private PictureApiClient() {
        picturesLiveData = new MutableLiveData<>();
    }

    public LiveData<List<Pictures>> getPictures() {
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

}
