package com.example.recycleviewpictures;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.provider.ContactsContract;

import com.example.recycleviewpictures.adapters.MyRecycleAdapter;
import com.example.recycleviewpictures.databinding.ActivityMainBinding;
import com.example.recycleviewpictures.requests.responsnes.Pictures;
import com.example.recycleviewpictures.viewModels.PictureListViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static List<Pictures> imageList;
    private MyRecycleAdapter recyclerAdapter;
    private PictureListViewModel pictureListViewModel;
    private ActivityMainBinding activityMainBinding;
    private static boolean isNew = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        pictureListViewModel = ViewModelProviders.of(this).get(PictureListViewModel.class);

        initRecyclerView();
        subscribeObservers();
        callAPI();
    }

    private void subscribeObservers()
    {
        //This is where Activity is observing the livedata in the ViewModel
        pictureListViewModel.getPictures().observe(this, pictures ->
                recyclerAdapter.updateRecycleAdapter(pictures));
    }

    private void initRecyclerView()
    {
            imageList = new ArrayList<>();
            RecyclerView recycleView = findViewById(R.id.linear_layout_with_recycleView_ID);

            GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
            recycleView.setLayoutManager(gridLayoutManager);
            recyclerAdapter = new MyRecycleAdapter(MainActivity.this, imageList);
            recycleView.setAdapter(recyclerAdapter);
    }

     //MainActivity <-- PictureListViewModel <-- PictureRepository <-- PictureApiClient
    private void picturesApi(String page, String limit)
    {
        pictureListViewModel.picturesApi(page, limit);
    }

    //Temp workaround for changing to landscape and saving state
    private void callAPI(){
        if (!isNew)
        {
            picturesApi("4", "40");
            isNew = true;
        }
    }
}


