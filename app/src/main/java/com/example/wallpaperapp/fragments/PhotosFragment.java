package com.example.wallpaperapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.wallpaperapp.R;
import com.example.wallpaperapp.viewmodels.PhotosViewModel;

public class PhotosFragment extends Fragment {

    private PhotosViewModel photosViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        photosViewModel = ViewModelProviders.of(this).get(PhotosViewModel.class);

        View root = inflater.inflate(R.layout.fragment_photos, container, false);

        final TextView textView = root.findViewById(R.id.text_collections);

        photosViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        return root;
    }
}