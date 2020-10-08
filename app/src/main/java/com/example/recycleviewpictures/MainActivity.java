package com.example.recycleviewpictures;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear_layout_with_recycleview);

        RecyclerView rv = findViewById(R.id.linear_layout_with_recycleView_ID);
        //MyRecycleAdapter myRecycleAdapter = new MyRecycleAdapter(this);
        rv.setAdapter(new MyRecycleAdapter(this));

        //TODO
        //zrobic tablice i z niej sprobowac zaciagnac obrazki
    }
}