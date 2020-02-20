package com.nasa.nasapicapp.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.nasa.nasapicapp.data.NasaImage;
import com.nasa.nasapicapp.viewmodel.NasaViewModel;
import com.nasaImage.nasapicapp.BR;
import com.nasaImage.nasapicapp.R;

import java.util.List;

/*
  Recyclerview Adapter class to display list items. This class displays nasa pictures images in a grid view layout manager
 */
public class NasaRecyclerAdapter extends RecyclerView.Adapter<NasaRecyclerAdapter.ViewHolder> {

    // View Model for the class used for data binding
    private NasaViewModel nasaViewModel;
    // List of NasaImage Data Pojo objects for displaying the nasa pictures in gridview
    private List<NasaImage> nasaImageList;

    // Constructor for initializing the view model
    public NasaRecyclerAdapter(NasaViewModel salesViewModel) {
        super();
        this.nasaViewModel = salesViewModel;
    }

    @Override
    public NasaRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.nasa_pic_row, parent, false);
        // Add data binding in view holder
        return new NasaRecyclerAdapter.ViewHolder(binding);
    }

    public NasaImage getItem(int position) {
        return nasaImageList.get(position);
    }

    @Override
    public void onBindViewHolder(NasaRecyclerAdapter.ViewHolder holder, int position) {
        final NasaImage nasaImageData = getItem(position);
        holder.bind(nasaViewModel, nasaImageData);
    }

    @Override
    public int getItemCount() {
        return null == nasaImageList ? 0 : nasaImageList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding binding;

        ViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(NasaViewModel viewModel, NasaImage nasaImageDataItem) {
            // Add data binding in the xml layout with the viewholder
            binding.setVariable(com.nasaImage.nasapicapp.BR.viewModel, viewModel);
            binding.setVariable(com.nasaImage.nasapicapp.BR.nasaImageDataItem, nasaImageDataItem);
            binding.executePendingBindings();
        }
    }

    public void setNasaImageList(List<NasaImage> nasaImageDataList) {
        this.nasaImageList = nasaImageDataList;
    }

}