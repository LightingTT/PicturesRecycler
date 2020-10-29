package com.example.recycleviewpictures.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.recycleviewpictures.Repositories.PictureRepository;
import com.example.recycleviewpictures.Requests.Responsnes.Pictures;

import java.util.List;

public class PictureListViewModel extends ViewModel {

    private MutableLiveData<List<Pictures>> pictureList = new MutableLiveData<>();
    private PictureRepository pictureRepository;

    public PictureListViewModel() {
    pictureRepository = PictureRepository.getInstance();
    }

    //immutable. Can be observed and changed indirectly.
    public LiveData<List<Pictures>> getPictures(){
        return pictureRepository.getPictures();
    }

    public void picturesApi(String page, String limit) {
        pictureRepository.picturesApi(page, limit);
    }

}
