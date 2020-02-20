package com.nasa.nasapicapp.repository;

import android.content.Context;

import androidx.annotation.NonNull;

import com.nasa.nasapicapp.contracts.NasaDataContract;
import com.nasa.nasapicapp.data.NasaDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class NasaRepository implements NasaDataContract {

    private static NasaRepository INSTANCE;
    private final NasaDataContract nasa;

    public static NasaRepository getInstance(
            NasaDataSource nasaDataSource) {
        if (INSTANCE == null) {
            synchronized (NasaRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new NasaRepository(nasaDataSource);
                }
            }
        }
        return INSTANCE;
    }

    public NasaRepository(NasaDataContract nasa) {
        this.nasa = nasa;
    }

    /*
        This method is used for gettting nasa data from datasource.
     */
    @Override
    public void getNasaData(@NonNull final GetNasaPicturesData callback) {

        nasa.getNasaData(new GetNasaPicturesData() {
            @Override
            public void onSuccessfullNasaDataLoaded(ArrayList nasaPicList) {
                callback.onSuccessfullNasaDataLoaded(nasaPicList);
            }
        });
    }


}
