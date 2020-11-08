/*
 * Copyright (c) 2020. by Piotr Zaremba
 */

package com.example.recycleviewpictures.dataBinding;

import android.content.Context;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class GlideBindingAdapter {

    @BindingAdapter("pictureUrl")
    public static void setPicture(ImageView view, String pictureUrl)
    {
        Context context = view.getContext();
        Glide.with(context).load(pictureUrl).into(view);
    }
}
