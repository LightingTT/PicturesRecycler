package com.example.recycleviewpictures.Requests;

import com.example.recycleviewpictures.Utils.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();
    private static ApiService apiService = retrofit.create(ApiService.class);

    public static ApiService getApiService(){
        return apiService;
    }

}
