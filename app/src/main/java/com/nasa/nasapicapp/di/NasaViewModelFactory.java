package com.nasa.nasapicapp.di;

import android.app.Application;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.nasa.nasapicapp.repository.NasaRepository;
import com.nasa.nasapicapp.usecase.GetNasaDataUseCase;
import com.nasa.nasapicapp.viewmodel.NasaViewModel;

// service locator
public class NasaViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private static NasaViewModelFactory INSTANCE;
    private static Application application_;

    private final NasaRepository nasaRepository;

    public static NasaViewModelFactory getInstance(Application application) {
        application_ = application;
        if (INSTANCE == null) {
            synchronized (NasaViewModelFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new NasaViewModelFactory(
                            Injection.provideNasaPicturesRepository(application.getApplicationContext()));
                }
            }
        }
        return INSTANCE;
    }

    private NasaViewModelFactory(NasaRepository repository) {
        nasaRepository = repository;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(NasaViewModel.class)) {
            return (T) new NasaViewModel(application_, new GetNasaDataUseCase(nasaRepository));
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
