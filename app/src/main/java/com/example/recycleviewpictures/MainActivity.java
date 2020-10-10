package com.example.recycleviewpictures;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<String> imageList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear_layout_with_recycleview);

        fillArrayList(5);

        RecyclerView recycleView = findViewById(R.id.linear_layout_with_recycleView_ID);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recycleView.setLayoutManager(linearLayoutManager);
        recycleView.setAdapter(new MyRecycleAdapter(MainActivity.this, imageList));
    }
    private static void fillArrayList(int x)
    {
        for (int i = 1;i < x + 1; i++)
        {
            imageList.add("https://picsum.photos/200");
        }
    }
}