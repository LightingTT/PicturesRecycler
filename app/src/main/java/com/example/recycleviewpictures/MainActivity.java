package com.example.recycleviewpictures;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recycleviewpictures.adapters.MyRecycleAdapter;
import com.example.recycleviewpictures.databinding.ActivityMainBinding;
import com.example.recycleviewpictures.requests.responsnes.Pictures;
import com.example.recycleviewpictures.viewModels.PictureListViewModel;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements onClickHandlerInterface{

    public static List<Pictures> imageList;
    private MyRecycleAdapter recyclerAdapter;
    private RecyclerView recycleView;
    private PictureListViewModel pictureListViewModel;
    private ActivityMainBinding activityMainBinding;
    private Context context;


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

    @Override
    public void onClicker(int pos, ImageView imageView, TextView textView) {

        Intent intent = new Intent(context, DetailedViewActivity.class);
        intent.putExtra("picture", (Parcelable) imageList.get(pos));
        Pair<View, String> p1 = Pair.create(imageView, "ImageTN");
        Pair<View, String> p2 = Pair.create(textView, "authorTM");
        ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) context, p1, p2);
        startActivity(intent, activityOptionsCompat.toBundle());

    }
}


