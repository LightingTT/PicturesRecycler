/*
 * Copyright (c) 2020. by Piotr Zaremba
 */

package com.example.recycleviewpictures.Requests;

import com.example.recycleviewpictures.Requests.Responsnes.Pictures;

import java.util.List;

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
}
