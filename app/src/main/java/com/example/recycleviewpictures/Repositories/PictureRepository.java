/*
 * Copyright (c) 2020. by Piotr Zaremba
 */

package com.example.recycleviewpictures.Repositories;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.recycleviewpictures.Requests.Responsnes.Pictures;
import java.util.List;

public class PictureRepository {
    private static PictureRepository instance;
    private MutableLiveData<List<Pictures>> pictures;

    public static PictureRepository getInstance()
    {
        if(instance == null)
        {
            instance = new PictureRepository();
        }
        return instance;
    }

    public PictureRepository(){
        pictures = new MutableLiveData<>();
    }

    public LiveData<List<Pictures>> getPictures(){
        return pictures;
    }
}