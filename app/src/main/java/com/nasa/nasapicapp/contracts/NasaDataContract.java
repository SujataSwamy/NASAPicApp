package com.nasa.nasapicapp.contracts;

import androidx.annotation.NonNull;

import com.nasa.nasapicapp.data.NasaImage;

import java.util.ArrayList;

/*
This contract is used for getting response from the data layers
 */
public interface NasaDataContract  {

    interface GetNasaPicturesData<T> {
        void onSuccessfullNasaDataLoaded(ArrayList<NasaImage> nasaImagePicList);
    }
    void getNasaData(@NonNull GetNasaPicturesData callback);
}