package com.example.recycleviewpictures;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static final String BASE_URL = "https://picsum.photos/";
    private static final String TAG = "MainActivity";
    public static List<Pictures> imageList;
    MyRecycleAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageList = new ArrayList<>();

        //Create RecycleView object and pin view
        RecyclerView recycleView = findViewById(R.id.linear_layout_with_recycleView_ID);
        GridLayoutManager gridLayoutManager = new GridLayoutManager (this, 2);

        //Setup Adapter
        recycleView.setLayoutManager(gridLayoutManager);
        recyclerAdapter = new MyRecycleAdapter(MainActivity.this, imageList);
        recycleView.setAdapter(recyclerAdapter);

        Log.d(TAG, "onCreate: ------>called<-----");

        //Creating reference for MyService and receiving deserialized data.
        ApiClient apiClient = new ApiClient(BASE_URL);
        apiClient.getApiService().getFile().enqueue(new Callback<List<Pictures>>() {
            @Override
            public void onResponse(Call<List<Pictures>> call, Response<List<Pictures>> response) {
                imageList = response.body();
                Log.d(TAG, "onResponse: ------>called<-----");
                recyclerAdapter.setMyRecycleAdapter(imageList);
            }

            @Override
            public void onFailure(Call<List<Pictures>> call, Throwable t) {
                Log.d("TAG","onFailure = ------>called<----- "+t.toString());
            }
        });

    }

}
