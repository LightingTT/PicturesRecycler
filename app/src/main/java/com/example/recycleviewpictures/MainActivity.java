package com.example.recycleviewpictures;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.example.recycleviewpictures.Adapters.MyRecycleAdapter;
import com.example.recycleviewpictures.Requests.ApiService;
import com.example.recycleviewpictures.Requests.Responsnes.Pictures;
import com.example.recycleviewpictures.Requests.ApiClient;
import com.example.recycleviewpictures.Requests.ServiceGenerator;
import com.example.recycleviewpictures.Utils.Constants;
import com.example.recycleviewpictures.ViewModels.PictureListViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends MainActivityWingman{

    public static List<Pictures> imageList;
    MyRecycleAdapter recyclerAdapter;
    RecyclerView recycleView;
    GridLayoutManager gridLayoutManager;
    private PictureListViewModel pictureListViewModel;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pictureListViewModel = ViewModelProviders.of(this).get(PictureListViewModel.class);
        subscribeObservers();
        findViewById(R.id.test_button_id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testRetrofit();
        }});

//        imageList = new ArrayList<>();
//        initRecyclerView();
//        apiCallStart();
    }

    private void subscribeObservers()
    {
        pictureListViewModel.getPictures().observe(this, new Observer<List<Pictures>>() {
            @Override
            public void onChanged(List<Pictures> pictures) {

            }
        });
    }

    private void testRetrofit()
    {
        ApiService apiService = ServiceGenerator.getApiService();
        Call<List<Pictures>> responseCall = apiService.getFile();
        responseCall.enqueue(new Callback<List<Pictures>>() {
            @Override
            public void onResponse(Call<List<Pictures>> call, Response<List<Pictures>> response) {
                Log.d(Constants.TAG, "onResponse: Server response: " + response.toString());
                if (Constants.RESPONSE_OK == response.code())
                {
                    Log.d(Constants.TAG, "onResponse: " + response.body().toString());
                    List<Pictures> picture =  new ArrayList<>(response.body());
                    Log.d(Constants.TAG, "onResponse: retrieved picture! " + picture.toString());
                    //TODO retrieve one image
                }else{
                    Log.d(Constants.TAG, "onFailure: " + response.errorBody().toString());

                }

            }

            @Override
            public void onFailure(Call<List<Pictures>> call, Throwable t) {


            }

        });
    }

    private void initRecyclerView()
    {
        recycleView = findViewById(R.id.linear_layout_with_recycleView_ID);
        gridLayoutManager = new GridLayoutManager (this, 2);

        recycleView.setLayoutManager(gridLayoutManager);
        recyclerAdapter = new MyRecycleAdapter(MainActivity.this, imageList);
        recycleView.setAdapter(recyclerAdapter);
    }

    private void apiCallStart()
    {
        ApiClient apiClient = new ApiClient(Constants.BASE_URL);
        apiClient.getApiService().getFile().enqueue(new Callback<List<Pictures>>() {
            @Override
            public void onResponse(Call<List<Pictures>> call, Response<List<Pictures>> response) {
                imageList = response.body();
                recyclerAdapter.updateRecycleAdapter(imageList);
                Log.d(Constants.TAG, "onResponse: ------>called<-----");
            }

            @Override
            public void onFailure(Call<List<Pictures>> call, Throwable t) {
                Log.d(Constants.TAG,"onFailure = ------>called<----- "+t.toString());
            }
        });
    }

}
