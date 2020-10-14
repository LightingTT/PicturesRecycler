package com.example.recycleviewpictures;

import java.util.ArrayList;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface MyService {

    //Co tutaj jest moim endpointem? Dla picsum.photos
    @GET("")
    //Mam zagniezdzoną tutaj klase z danymi, ktore chce pobrac. Czy klasa "Pictures" jest w ogole tutaj potrzebna?
    Call<ArrayList<Pictures>> getFile();
}
