package com.example.recycleviewpictures.requests;

import com.example.recycleviewpictures.utils.Constants;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();
    private static ApiService apiService = retrofit.create(ApiService.class);

    public static ApiService getApiService(){
        return apiService;
    }

}
