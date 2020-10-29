package com.example.recycleviewpictures;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.recycleviewpictures.MainActivity.BASE_URL;

public class ApiClient {

    private static Retrofit.Builder retrofitBuilder = new Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();

    private static ApiService apiService = retrofit.create(ApiService.class);

    public static ApiService getPictureApi(){
        return apiService;
    }

}
