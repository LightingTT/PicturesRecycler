package com.example.recycleviewpictures;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("/v2/list?page=2&limit=100")
    Call<List<Pictures>> getFile();
}
