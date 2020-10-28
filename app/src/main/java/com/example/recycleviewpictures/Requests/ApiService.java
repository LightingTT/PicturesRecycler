/*
 * Copyright (c) 2020. by Piotr Zaremba
 */

package com.example.recycleviewpictures.Requests;

import com.example.recycleviewpictures.Requests.Responsnes.Pictures;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("/v2/list")
    Call<Pictures> getPictureList(
            @Query("page") String page,
            @Query("limit") String limit
            );

    @GET("/id/0/info")
    Call<Pictures> getPicture();

    @GET("/v2/list?page=2&limit=100")
    Call<List<Pictures>> getFile();
}
