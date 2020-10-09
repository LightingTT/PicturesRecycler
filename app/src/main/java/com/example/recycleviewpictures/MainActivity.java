package com.example.recycleviewpictures;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static List<String> imageList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear_layout_with_recycleview);

        imageList.add("https://picsum.photos/200");
        imageList.add("https://picsum.photos/200");
        imageList.add("https://picsum.photos/200");
        imageList.add("https://picsum.photos/200");
        imageList.add("https://picsum.photos/200");
        imageList.add("https://picsum.photos/200");
        imageList.add("https://picsum.photos/200");
        imageList.add("https://picsum.photos/200");
        imageList.add("https://picsum.photos/200");
        imageList.add("https://picsum.photos/200");
        imageList.add("https://picsum.photos/200");
        imageList.add("https://picsum.photos/200");
        imageList.add("https://picsum.photos/200");
        imageList.add("https://picsum.photos/200");
        imageList.add("https://picsum.photos/200");
        imageList.add("https://picsum.photos/200");
        imageList.add("https://picsum.photos/200");
        imageList.add("https://picsum.photos/200");
        imageList.add("https://picsum.photos/200");
        imageList.add("https://picsum.photos/200");
        imageList.add("https://picsum.photos/200");

        RecyclerView recycleView = findViewById(R.id.linear_layout_with_recycleView_ID);
        recycleView.setAdapter(new MyRecycleAdapter(this, imageList));

    }
}