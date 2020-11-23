package com.example.recycleviewpictures;


import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.recycleviewpictures.adapters.MyRecycleAdapter;
import com.example.recycleviewpictures.databinding.ActivityMainBinding;
import com.example.recycleviewpictures.requests.responsnes.Pictures;
import com.example.recycleviewpictures.viewModels.PictureListViewModel;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    public static List<Pictures> imageList;
    private MyRecycleAdapter recyclerAdapter;
    private RecyclerView recycleView;
    private PictureListViewModel pictureListViewModel;
    private ActivityMainBinding activityMainBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        pictureListViewModel = new ViewModelProvider(this).get(PictureListViewModel.class);

        initRecyclerView();
        subscribeObservers();
    }

    private void subscribeObservers()
    {
        pictureListViewModel.getPictures().observe(this, pictures ->
                recyclerAdapter.updateRecycleAdapter(pictures));
    }

    private void initRecyclerView()
    {
            recycleView = findViewById(R.id.linear_layout_with_recycleView_ID);
            recycleView.setLayoutManager(new GridLayoutManager(this, 2));
            runAdapter();
    }

    private void runAdapter()
    {
        imageList = new ArrayList<>();
        recyclerAdapter = new MyRecycleAdapter(this, imageList);
        recycleView.setAdapter(recyclerAdapter);
    }
}


