package com.example.recycleviewpictures.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;
import com.example.recycleviewpictures.DetailedViewActivity;
import com.example.recycleviewpictures.R;
import com.example.recycleviewpictures.databinding.SinglePictureViewBinding;
import com.example.recycleviewpictures.utils.DiffUtilsCallback;
import com.example.recycleviewpictures.requests.responsnes.Pictures;

import java.util.List;

import io.reactivex.Single;

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
        return new ViewHolderClass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderClass holder, int position) {
        Glide

                .with(context)
                .load(imageList.get(position).getDownloadUrl())
                .transition(withCrossFade(setTransitionProperties()))
                .into(holder.picture);

        holder.picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailedViewActivity.class);
                intent.putExtra("picture", imageList.get(position));
                Pair<View, String> p1 = Pair.create(holder.picture, "ImageTN");
                Pair<View, String> p2 = Pair.create(holder.author, "authorTM");
                ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) context, p1, p2);
                context.startActivity(intent, activityOptionsCompat.toBundle());
            }
        });

        //testing
        holder.b.setPictureDataBinding(imageList.get(position));
        //Co dla textview? Jak polaczyc z clicklistenerem wyzej? Wszystko do GlideBindingAdaptera?


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

    public static class ViewHolderClass extends RecyclerView.ViewHolder{

       private final ImageView picture;
       private final TextView author;

       //testing
       SinglePictureViewBinding b;

       //drugi argument testing
        public ViewHolderClass(@NonNull View itemView, SinglePictureViewBinding binding) {
            super(itemView);
            picture = itemView.findViewById(R.id.image_view_id);
            author = itemView.findViewById(R.id.author);

            //testing
            b = binding;

        }
    }
}
