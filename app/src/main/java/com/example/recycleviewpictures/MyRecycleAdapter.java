package com.example.recycleviewpictures;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;
import java.util.zip.Inflater;

public class MyRecycleAdapter extends RecyclerView.Adapter<MyRecycleAdapter.GridViewHolder> {

   private Context context;

    public static class GridViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.single_picture_id);
        }
    }

    public MyRecycleAdapter(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public MyRecycleAdapter.GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.linear_layout_with_recycleview, parent, false);
        return new GridViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecycleAdapter.GridViewHolder holder, int position) {
        Glide
                .with(context)
                .load("https://picsum.photos/200")
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
