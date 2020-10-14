package com.example.recycleviewpictures;

import java.util.ArrayList;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface MyService {

    //What is my endpoint for lorem.picsum here?
    @GET("")
    //Do I need nested Pictures class here?I saw examples like:
    //Call<Collection> yourGetFunction() 
    //without data class.
    Call<ArrayList<Pictures>> getFile();
}
