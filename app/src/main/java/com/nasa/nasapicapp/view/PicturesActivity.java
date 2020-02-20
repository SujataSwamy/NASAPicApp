package com.nasa.nasapicapp.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;

import com.nasa.nasapicapp.adapter.NasaRecyclerAdapter;
import com.nasa.nasapicapp.viewmodel.NasaViewModel;
import com.nasa.nasapicapp.di.NasaViewModelFactory;
import com.nasaImage.nasapicapp.R;
import com.nasaImage.nasapicapp.databinding.PicturesContentMainBinding;

public class PicturesActivity extends AppCompatActivity {

    private PicturesContentMainBinding dataBinding;
    private NasaViewModel nasaViewModel;
    private NasaRecyclerAdapter nasaRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Configure data binding
        dataBinding = DataBindingUtil.setContentView(this, R.layout.pictures_content_main);
        NasaViewModelFactory factory = NasaViewModelFactory.getInstance(getApplication());

        nasaViewModel = ViewModelProviders.of(this, factory).get(NasaViewModel.class);
        dataBinding.setModel(nasaViewModel);
        //setup recyclerview
        setUpNasaPicDataRecyclerView();

        // set the recyclerview adapter in viewmodel
        nasaViewModel.setAdapter(nasaRecyclerAdapter);

        nasaViewModel.getNasaPicturesData();
    }

    /*
    Instantiate the adapter
     */
    private void setUpNasaPicDataRecyclerView() {
        dataBinding.picturesRecyclerView.setHasFixedSize(true);
        nasaRecyclerAdapter = new NasaRecyclerAdapter(nasaViewModel);
        dataBinding.picturesRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        dataBinding.picturesRecyclerView.setAdapter(nasaRecyclerAdapter);
    }
}
