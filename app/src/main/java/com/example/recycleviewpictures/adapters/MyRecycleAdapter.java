package com.example.recycleviewpictures.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.example.recycleviewpictures.databinding.SinglePictureViewBinding;
import com.example.recycleviewpictures.utils.DiffUtilsCallback;
import com.example.recycleviewpictures.requests.responsnes.Pictures;
import java.util.List;

public class MyRecycleAdapter extends RecyclerView.Adapter<MyRecycleAdapter.ViewHolderClass> {

    private Context context;
    private List<Pictures> imageList;
    private OnClickHandlerInterface onClickHandlerInterface;

    public MyRecycleAdapter(Context context, List<Pictures> imageList, OnClickHandlerInterface onClickHandlerInterface)
    {
        this.context = context;
        this.imageList = imageList;
        this.onClickHandlerInterface = onClickHandlerInterface;
    }

    @NonNull
    @Override
    public ViewHolderClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        SinglePictureViewBinding singlePictureViewBinding = SinglePictureViewBinding.inflate(LayoutInflater.from(context));
        return new ViewHolderClass(singlePictureViewBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderClass holder, int position) {
        holder.singlePictureViewBinding.setPictures(imageList.get(position));
        holder.singlePictureViewBinding.setClickHandler(onClickHandlerInterface);
    }

    public void updateRecycleAdapter(List<Pictures> imageListDiff)
    {
        final DiffUtilsCallback diffUtilsCallback = new DiffUtilsCallback(this.imageList, imageListDiff);
        final DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffUtilsCallback);

        this.imageList.clear();
        this.imageList.addAll(imageListDiff);
        diffResult.dispatchUpdatesTo(this);
    }

    @Override
    public int getItemCount() {
        if(imageList != null){
            return imageList.size();
        }
        return 0;
    }

    public static class ViewHolderClass extends RecyclerView.ViewHolder{

       SinglePictureViewBinding singlePictureViewBinding;

        public ViewHolderClass(@NonNull SinglePictureViewBinding binding) {
            super(binding.getRoot());

            singlePictureViewBinding = binding;
        }
    }
    public interface OnClickHandlerInterface {

        void onClickPicture(Pictures picture, View view);
    }
}
