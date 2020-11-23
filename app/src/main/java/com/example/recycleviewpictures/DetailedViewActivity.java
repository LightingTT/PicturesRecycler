/*
 * Copyright (c) 2020. by Piotr Zaremba
 */

package com.example.recycleviewpictures;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.example.recycleviewpictures.requests.responsnes.Pictures;


public class DetailedViewActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailed_view);

        getIntentFromMainActivity();
    }

    public void getIntentFromMainActivity() {

        Pictures pictureObject = (Pictures) getIntent().getExtras().getSerializable("picture");
        setObjectValues(pictureObject);
    }

    private void setObjectValues(Pictures pictureObject)
    {
            TextView author = findViewById(R.id.author_id_large);
            author.setText(pictureObject.getAuthor());

            ImageView image = findViewById(R.id.image_view_id_large);
            Glide
                    .with(this)
                    .load(pictureObject.getDownloadUrl())
                    .centerCrop()
                    .into(image);
    }

}


