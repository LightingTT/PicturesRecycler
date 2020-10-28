package com.example.recycleviewpictures;

import androidx.lifecycle.MutableLiveData;

import com.example.recycleviewpictures.Requests.Responsnes.Pictures;

import java.util.ArrayList;
import java.util.List;

public class PicturesRepo {

    private static PicturesRepo instance;
    private List<Pictures> dataSet = new ArrayList<>();

    public static PicturesRepo getInstance() {
        if (instance == null)
        {
            instance = new PicturesRepo();
        }
        return instance;
    }

    public MutableLiveData<List<Pictures>> getPictures()
    {
        setPictures();
        MutableLiveData<List<Pictures>> data = new MutableLiveData<>();
        data.setValue(dataSet);
        return data;

    }

    private void setPictures()
    {
        //TODO
    }


}
