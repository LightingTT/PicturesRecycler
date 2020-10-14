package com.example.recycleviewpictures;

import java.util.ArrayList;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface MyService {

    //Co tutaj jest moim endpointem? Dla picsum.photos
    @GET("")
    Call<ArrayList<Pictures>> getFile();
}
