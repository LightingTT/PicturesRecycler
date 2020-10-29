package com.example.recycleviewpictures;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleviewpictures.Adapters.MyRecycleAdapter;
import com.example.recycleviewpictures.Requests.Responsnes.Pictures;
import com.example.recycleviewpictures.ViewModels.PictureListViewModel;

import java.util.List;

/*
 * TODO
 * Class will be redesigned later.
 */

public abstract class MainActivityWingman extends AppCompatActivity {

    public ProgressBar progressBar;
    public static List<Pictures> imageList;
    MyRecycleAdapter recyclerAdapter;
    RecyclerView recycleView;
    GridLayoutManager gridLayoutManager;
    private PictureListViewModel pictureListViewModel;

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);

        ConstraintLayout constraintLayout = (ConstraintLayout) getLayoutInflater().inflate(R.layout.activity_main_wingman, null);
        FrameLayout frameLayout = findViewById(R.id.activity_content_wingman_id);
        progressBar = constraintLayout.findViewById(R.id.progress_bar_id);

        getLayoutInflater().inflate(layoutResID, frameLayout, true);
    }


//    protected void initRecyclerView()
//    {
//        recycleView = findViewById(R.id.linear_layout_with_recycleView_ID);
//        gridLayoutManager = new GridLayoutManager(this, 2);
//
//        recycleView.setLayoutManager(gridLayoutManager);
//        recyclerAdapter = new MyRecycleAdapter(MainActivityWingman.this, imageList);
//        recycleView.setAdapter(recyclerAdapter);
//    }
//
//    protected void apiCallStart()
//    {
//        ApiClient apiClient = new ApiClient(Constants.BASE_URL);
//        apiClient.getApiService().getFile().enqueue(new Callback<List<Pictures>>() {
//            @Override
//            public void onResponse(Call<List<Pictures>> call, Response<List<Pictures>> response) {
//                imageList = response.body();
//                recyclerAdapter.updateRecycleAdapter(imageList);
//                Log.d(Constants.TAG, "onResponse: ------>called<-----");
//            }
//
//            @Override
//            public void onFailure(Call<List<Pictures>> call, Throwable t) {
//                Log.d(Constants.TAG,"onFailure = ------>called<----- "+t.toString());
//            }
//        });
//    }

    public void showProgressBar(boolean visibility)
    {
        if (visibility == true)
        {
            progressBar.setVisibility(View.VISIBLE);
        }
        progressBar.setVisibility(View.INVISIBLE);
    }
}