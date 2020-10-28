package com.example.recycleviewpictures.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.recycleviewpictures.Requests.Responsnes.Pictures;

import java.util.List;

public class PictureListViewModel extends ViewModel {

    private MutableLiveData<List<Pictures>> pictureList = new MutableLiveData<>();

    public PictureListViewModel(MutableLiveData<List<Pictures>> pictureList) {
        this.pictureList = pictureList;
    }
    public PictureListViewModel() {

    }

    //immutable. Can be observed and changed indirectly.
    public LiveData<List<Pictures>> getPictures(){
        return pictureList;
    }


}
