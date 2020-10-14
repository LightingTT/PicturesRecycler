package com.example.recycleviewpictures;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    public static ArrayList<Pictures> imageList = new ArrayList<>();
    MyRecycleAdapter recyclerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create RecycleView object and pin view
        RecyclerView recycleView = findViewById(R.id.linear_layout_with_recycleView_ID);
        GridLayoutManager linearLayoutManager = new GridLayoutManager (this, 2);

        //Setup Adapter
        recycleView.setLayoutManager(linearLayoutManager);
        recyclerAdapter = new MyRecycleAdapter(MainActivity.this, imageList);
        recycleView.setAdapter(recyclerAdapter);

        Log.d(TAG, "onCreate: ------>called<-----");
        
        //Creating reference for MyService and receiving deserialized data.
        MyService apiClient = ApiClient.getClient().create(MyService.class);
        Call<ArrayList<Pictures>> call = apiClient.getFile();

        call.enqueue(new Callback<ArrayList<Pictures>>() {
            @Override
            public void onResponse(Call<ArrayList<Pictures>> call, Response<ArrayList<Pictures>> response) {
                imageList = response.body();
                Log.d(TAG, "onResponse: ------>called<-----");
                recyclerAdapter.setMyRecycleAdapter(imageList);
            }

            @Override
            public void onFailure(Call<ArrayList<Pictures>> call, Throwable t) {
                Log.d("TAG","onFailure = ------>called<----- "+t.toString());
            }
        });

    }

}
