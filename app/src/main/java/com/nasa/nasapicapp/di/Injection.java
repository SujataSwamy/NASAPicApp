package com.nasa.nasapicapp.di;

import android.content.Context;

import androidx.annotation.NonNull;

import com.nasa.nasapicapp.data.NasaDataSource;
import com.nasa.nasapicapp.repository.NasaRepository;

import static com.bumptech.glide.util.Preconditions.checkNotNull;

/*
DI file used for service locator pattern
 */
public class Injection {

    public static NasaRepository provideNasaPicturesRepository(@NonNull Context context) {
        checkNotNull(context);
        return NasaRepository.getInstance( NasaDataSource.getInstance(context));
    }
}
