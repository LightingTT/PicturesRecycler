package com.example.recycleviewpictures.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.example.recycleviewpictures.repositories.PictureRepository;
import com.example.recycleviewpictures.requests.responsnes.Pictures;

import java.util.List;

public class PictureListViewModel extends ViewModel {

    private MutableLiveData<List<Pictures>> pictureList = new MutableLiveData<>();
    private PictureRepository pictureRepository;
    private SavedStateHandle state;

    public PictureListViewModel() {
    pictureRepository = PictureRepository.getInstance();
    }

    //Gets its liveData from Repository
    public LiveData<List<Pictures>> getPictures(){
        return pictureRepository.getPictures();
    }


    public void picturesApi(String page, String limit) {
        pictureRepository.picturesApi(page, limit);
    }


}
