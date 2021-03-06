/*
 * Copyright (c) 2020. by Piotr Zaremba
 */

package com.example.recycleviewpictures.requests;

import com.example.recycleviewpictures.requests.responsnes.Pictures;
import java.util.List;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    //list
    @GET("/v2/list")
    Call<List<Pictures>> getPictureListApi(@Query("page") String page,
                                           @Query("limit") String limit);

    //single image
    @GET("/id/{number}/info")
    Call <Pictures> getPictureApi(@Path("number") int number);


    //RxJava list
    @GET("/v2/list")
    Single<List<Pictures>> getPictureListApiRx(@Query("page") String page,
                                               @Query("limit") String limit);
}
