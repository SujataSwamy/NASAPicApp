package com.nasa.nasapicapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.nasa.nasapicapp.adapter.NasaRecyclerAdapter;
import com.nasa.nasapicapp.contracts.NasaDataContract;
import com.nasa.nasapicapp.usecase.GetNasaDataUseCase;

import java.util.ArrayList;

public class NasaViewModel extends AndroidViewModel {
    private GetNasaDataUseCase getNasaUseCase;
    private NasaRecyclerAdapter nasaRecyclerAdapter;

    public NasaViewModel(@NonNull Application application, GetNasaDataUseCase getNasaDataUseCase) {
        super(application);
        this.getNasaUseCase = getNasaDataUseCase;
    }

    /*
    Get the nasa pictures data by calling the use case class.
     */
    public void getNasaPicturesData() {
        getNasaUseCase.getNasa(new NasaDataContract.GetNasaPicturesData() {
            @Override
            public void onSuccessfullNasaDataLoaded(ArrayList nasaPicList) {
                setAdapterForNasaData(nasaPicList);
            }
        });
    }

    /*
    @param nasaPicList. This parameter sets the arraylist for displaying nasa images.
     */
    private void setAdapterForNasaData(ArrayList nasaPicList) {
        nasaRecyclerAdapter.setNasaImageList(nasaPicList);
        nasaRecyclerAdapter.notifyDataSetChanged();
    }

    /*
    Set the recyclerview adapter
     */
    public void setAdapter(NasaRecyclerAdapter nasaRecyclerAdapter) {
        this.nasaRecyclerAdapter = nasaRecyclerAdapter;
    }
}
