package com.example.recycleviewpictures;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("id/0/5616/3744/")
    Call<List<Pictures>> getFile();
}
