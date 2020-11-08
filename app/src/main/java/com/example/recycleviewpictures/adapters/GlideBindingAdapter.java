/*
 * Copyright (c) 2020. by Piotr Zaremba
 */

package com.example.recycleviewpictures.adapters;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;

import androidx.databinding.BindingAdapter;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class GlideBindingAdapter {

    @BindingAdapter("pictureUrl")
    public static void setPicture(ImageView view, String pictureUrl) {
        Context context = view.getContext();
        Glide.with(context)
        .load(pictureUrl)
                .transition(withCrossFade(setTransitionProperties()))
                .centerCrop().
       into(view);
    }

    static DrawableCrossFadeFactory setTransitionProperties() {
        DrawableCrossFadeFactory factory = new DrawableCrossFadeFactory
                .Builder()
                .setCrossFadeEnabled(true)
                .build();

        return factory;
    }


}
