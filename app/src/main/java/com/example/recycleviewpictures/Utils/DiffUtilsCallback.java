package com.example.recycleviewpictures.Utils;

import androidx.recyclerview.widget.DiffUtil;

import com.example.recycleviewpictures.Requests.Responsnes.Pictures;

import java.util.List;

public class DiffUtilsCallback extends DiffUtil.Callback {

    private final List<Pictures> oldImageList;
    private final List<Pictures> newImageList;

    public DiffUtilsCallback(List<Pictures> oldImageUrl, List<Pictures> newImageUrl) {
        this.oldImageList = oldImageUrl;
        this.newImageList = newImageUrl;
    }

    @Override
    public int getOldListSize() {
        return oldImageList.size();
    }

    @Override
    public int getNewListSize() {
        return newImageList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {

        return oldImageList.get(oldItemPosition).getDownloadUrl() == newImageList.get(newItemPosition).getDownloadUrl();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {

        final Pictures oldImageUrl = oldImageList.get(oldItemPosition);
        final Pictures newImageUrl = newImageList.get(oldItemPosition);

        return oldImageUrl.getDownloadUrl().equals(newImageUrl.getDownloadUrl());

    }
}
