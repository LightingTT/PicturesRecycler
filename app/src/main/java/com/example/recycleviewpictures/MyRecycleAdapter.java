package com.example.recycleviewpictures;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import java.util.ArrayList;

public class MyRecycleAdapter extends RecyclerView.Adapter<MyRecycleAdapter.ViewHolderClass> {

    private static final String TAG = "MainActivity";
    private Context context;
    private ArrayList<Pictures> imageList;

    //Constructor
    public MyRecycleAdapter(Context context, ArrayList<Pictures> imageList)
    {
        this.context = context;
        this.imageList = imageList;
    }
    //
    public void setMyRecycleAdapter(ArrayList<Pictures> imageList)
    {
        this.imageList = imageList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolderClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.single_picture_view, parent, false);
        ViewHolderClass linearViewHolderClass = new ViewHolderClass(view);
        return linearViewHolderClass;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderClass holder, int position) {
        Glide
                        .with(context)
                        .load(imageList
                        .get(position).getImageUrl())
                        .apply(RequestOptions
                        .centerCropTransform())
                        .into(holder.imageView);
        Log.d(TAG, "onBindViewHolder: ------>called<-----");
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    public class ViewHolderClass extends RecyclerView.ViewHolder{

        private ImageView imageView;

        //Constructor
        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.single_picture_id);
        }
    }
}
