package com.example.recycleviewpictures.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;
import com.example.recycleviewpictures.databinding.SinglePictureViewBinding;
import com.example.recycleviewpictures.requests.responsnes.Pictures;
import com.example.recycleviewpictures.utils.DiffUtilsCallback;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

public class MyRecycleAdapter extends RecyclerView.Adapter<MyRecycleAdapter.ViewHolderClass> {

    private final ImageAdapterClickListener imageAdapterClickListener;
    private Context context;
    private List<Pictures> imageList;

    public MyRecycleAdapter(Context context, List<Pictures> imageList, ImageAdapterClickListener imageAdapterClickListener) {
        this.context = context;
        this.imageList = imageList;
        this.imageAdapterClickListener = imageAdapterClickListener;
    }

    @NonNull
    @Override
    public ViewHolderClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        SinglePictureViewBinding singlePictureViewBinding = SinglePictureViewBinding.inflate(LayoutInflater.from(context));
        ViewHolderClass linearViewHolderClass = new ViewHolderClass(singlePictureViewBinding);
        return linearViewHolderClass;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderClass holder, int position) {
        holder.b.setListener(imageAdapterClickListener);
        holder.b.setPicture(imageList.get(position));
    }

    private DrawableCrossFadeFactory setTransitionProperties() {
        DrawableCrossFadeFactory factory = new DrawableCrossFadeFactory
                .Builder()
                .setCrossFadeEnabled(true)
                .build();

        return factory;
    }

    public void updateRecycleAdapter(List<Pictures> imageListDiff) {
        final DiffUtilsCallback diffUtilsCallback = new DiffUtilsCallback(this.imageList, imageListDiff);
        final DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffUtilsCallback);

        this.imageList.clear();
        this.imageList.addAll(imageListDiff);
        diffResult.dispatchUpdatesTo(this);
    }

    @Override
    public int getItemCount() {
        if (imageList != null) {
            return imageList.size();
        }
        return 0;
    }

    public interface ImageAdapterClickListener {
        void onClick(Pictures pictures, View view);
    }

    public class ViewHolderClass extends RecyclerView.ViewHolder {

        private SinglePictureViewBinding b;

        public ViewHolderClass(@NonNull SinglePictureViewBinding binding) {
            super(binding.getRoot());
            b = binding;
        }
    }
}
