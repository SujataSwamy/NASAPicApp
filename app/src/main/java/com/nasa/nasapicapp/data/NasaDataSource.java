package com.nasa.nasapicapp.data;

import android.content.Context;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.nasa.nasapicapp.contracts.NasaDataContract;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

/*
DataSource for getting the data from assets file.
 */
public class NasaDataSource implements NasaDataContract {

    private static NasaDataSource nasaDataSource;
    static Context appContext;

    /*
    Instantiate datasource and get context from service locator
     */
    public static NasaDataSource getInstance(Context context) {
        appContext = context;
        if (nasaDataSource == null) {
            nasaDataSource = new NasaDataSource();
        }
        return nasaDataSource;
    }

    /*
    This method gets the nasa data by parsing json files using assetmanager.
     */
    @Override
    public void getNasaData(@NonNull GetNasaPicturesData callback) {
        // Get NasaImage Json parsing data from assetmanager here
        String nasaDataFromAssets = getJsonFromAssets(appContext, "data.json");
        // Parsing gson file
        Gson gson = new Gson();
        NasaImage[] nasaImage = gson.fromJson(nasaDataFromAssets, NasaImage[].class);
        callback.onSuccessfullNasaDataLoaded(new ArrayList<>(Arrays.asList(nasaImage)));
    }


    public static String getJsonFromAssets(Context context, String fileName) {
        String jsonString;
        try {
            InputStream is = context.getAssets().open(fileName);

            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            jsonString = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return jsonString;
    }
}
