package com.example.recycleviewpictures;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;

public class MyRecycleAdapter extends RecyclerView.Adapter<MyRecycleAdapter.LinearViewHolderClass> {

    private Context context;
    private ArrayList<String> imageList;

    public class LinearViewHolderClass extends RecyclerView.ViewHolder{

        private ImageView imageView;

        public LinearViewHolderClass(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.single_picture_id);
        }
    }

    public MyRecycleAdapter(Context context, ArrayList<String> imageList)
    {
        this.context = context;
        this.imageList = imageList;
    }

    @NonNull
    @Override
    public LinearViewHolderClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.single_picture_view, parent, false);
        LinearViewHolderClass linearViewHolderClass = new LinearViewHolderClass(view);
        return linearViewHolderClass;
    }

    @Override
    public void onBindViewHolder(@NonNull LinearViewHolderClass holder, int position) {
        Glide
                .with(context)
                .load(imageList.get(position))
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }
}
