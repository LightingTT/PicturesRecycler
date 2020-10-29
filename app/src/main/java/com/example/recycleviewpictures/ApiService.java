package com.example.recycleviewpictures;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @GET("/v2/list")
    Call<List<Pictures>> getPictureList(@Query("page") String page,
                                        @Query("limit") String limit);
    @GET("/v2/list?page=2&limit=100")
    Call<List<Pictures>> getPicturesOldList();

    @GET("/id/{number}/info")
    Call<Pictures> getPicture(@Path("number") int number);
}
