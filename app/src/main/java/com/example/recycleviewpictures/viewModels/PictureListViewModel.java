package com.example.recycleviewpictures.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.recycleviewpictures.repositories.PictureRepository;
import com.example.recycleviewpictures.requests.responsnes.Pictures;

import java.util.List;

public class PictureListViewModel extends ViewModel {

    private final PictureRepository pictureRepository;
    LiveData<List<Pictures>> picturesLiveData;

    public PictureListViewModel() {
    pictureRepository = PictureRepository.getInstance();
    picturesLiveData = pictureRepository.getPictures();

    pictureRepository.picturesApi("5", "100");
    }

    //Gets its liveData from Repository
    public LiveData<List<Pictures>> getPictures(){
        return picturesLiveData;
    }


}
