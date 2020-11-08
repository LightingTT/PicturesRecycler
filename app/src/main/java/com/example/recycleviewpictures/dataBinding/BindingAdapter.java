/*
 * Copyright (c) 2020. by Piotr Zaremba
 */

package com.example.recycleviewpictures.dataBinding;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleviewpictures.adapters.MyRecycleAdapter;
import com.example.recycleviewpictures.requests.responsnes.Pictures;
import java.util.List;

public class BindingAdapter {

    @androidx.databinding.BindingAdapter("pictures")
    public static void setPictureList(RecyclerView view, List<Pictures> picturesList)
    {
        RecyclerView.LayoutManager layoutManager = view.getLayoutManager();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(view.getContext(), 2);
        view.setLayoutManager(gridLayoutManager);

        MyRecycleAdapter adapter = new MyRecycleAdapter(view.getContext(), picturesList);
        view.setAdapter(adapter);
    }

}
