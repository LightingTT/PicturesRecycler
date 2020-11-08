package com.example.recycleviewpictures.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;
import com.example.recycleviewpictures.utils.Constants;
import com.example.recycleviewpictures.utils.DiffUtilsCallback;
import com.example.recycleviewpictures.requests.responsnes.Pictures;
import com.example.recycleviewpictures.R;

import java.util.List;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class MyRecycleAdapter extends RecyclerView.Adapter<MyRecycleAdapter.ViewHolderClass> {

    private Context context;
    private List<Pictures> imageList;

    public MyRecycleAdapter(Context context, List<Pictures> imageList)
    {
        this.context = context;
        this.imageList = imageList;
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
                        .load(imageList.get(position).getDownloadUrl())
                        .transition(withCrossFade(setTransitionProperties()))
                        .centerCrop()
                        .into(holder.imageView);
        Log.d(Constants.TAG, "onBindViewHolder: ------>called<-----");
    }

    private DrawableCrossFadeFactory setTransitionProperties() {
        DrawableCrossFadeFactory factory = new DrawableCrossFadeFactory
                .Builder()
                .setCrossFadeEnabled(true)
                .build();

        return factory;
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

    public class ViewHolderClass extends RecyclerView.ViewHolder{

        private ImageView imageView;

        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.single_picture_id);
        }
    }
}
