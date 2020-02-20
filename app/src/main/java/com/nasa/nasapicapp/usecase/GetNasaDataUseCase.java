package com.nasa.nasapicapp.usecase;

import com.nasa.nasapicapp.contracts.NasaDataContract;
import com.nasa.nasapicapp.repository.NasaRepository;

import java.util.ArrayList;

/*
This class is used for doing any filtering logic or ui logic before sending it to presentation layer.
 */
public class GetNasaDataUseCase {
    private NasaRepository nasaRepository;

    public GetNasaDataUseCase(NasaRepository nasaRepository) {
        this.nasaRepository = nasaRepository;
    }

    public void getNasa(final NasaDataContract.GetNasaPicturesData callBack) {
        nasaRepository.getNasaData(new NasaDataContract.GetNasaPicturesData() {
            @Override
            public void onSuccessfullNasaDataLoaded(ArrayList nasaPicList) {
                callBack.onSuccessfullNasaDataLoaded(nasaPicList);
            }
        });
    }
}
