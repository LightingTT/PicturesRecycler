package com.example.recycleviewpictures;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Picture;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.example.recycleviewpictures.Adapters.MyRecycleAdapter;
import com.example.recycleviewpictures.Requests.ApiService;
import com.example.recycleviewpictures.Requests.Responsnes.Pictures;
import com.example.recycleviewpictures.Requests.ServiceGenerator;
import com.example.recycleviewpictures.Utils.Constants;
import com.example.recycleviewpictures.ViewModels.PictureListViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static List<Pictures> imageList;
    MyRecycleAdapter recyclerAdapter;
    RecyclerView recycleView;
    GridLayoutManager gridLayoutManager;
    private PictureListViewModel pictureListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pictureListViewModel = ViewModelProviders.of(this).get(PictureListViewModel.class);
        subscribeObservers();
        testRetrofit();
//        initRecyclerView();
//        apiCallStart();
    }


    private void initRecyclerView()
    {
        imageList = new ArrayList<>();
        recycleView = findViewById(R.id.linear_layout_with_recycleView_ID);

        gridLayoutManager = new GridLayoutManager (this, 2);
        recycleView.setLayoutManager(gridLayoutManager);
        recyclerAdapter = new MyRecycleAdapter(MainActivity.this, imageList);
        recycleView.setAdapter(recyclerAdapter);
    }

    private void apiCallStart()
    {
        ApiService apiService = ServiceGenerator.getApiService();
        Call<List<Pictures>> responseCall = apiService.getPictureListApi("2", "50");
        responseCall.enqueue(new Callback<List<Pictures>>() {
            @Override
            public void onResponse(Call<List<Pictures>> call, Response<List<Pictures>> response) {
                Log.d(Constants.TAG, "onResponse: Server response: " + response.toString());
                List<Pictures> imageList = response.body();
                recyclerAdapter.updateRecycleAdapter(imageList);
            }

            @Override
            public void onFailure(Call<List<Pictures>> call, Throwable t) {
                Log.d(Constants.TAG,"onFailure = ------>called<----- "+t.toString());
            }
        });
    }

    private void subscribeObservers()
    {
        pictureListViewModel.getPictures().observe(this, new Observer<List<Pictures>>() {
            @Override
            public void onChanged(List<Pictures> pictures) {

            }
        });
    }

    /*
     * MainActivity <-- PictureListViewModel <-- PictureRepository <-- PictureApiClient
     */
    private void picturesApi(String page, String limit)
    {
        pictureListViewModel.picturesApi(page, limit);
    }

    private void testRetrofit(){
        picturesApi("1", "70");
    }

}


