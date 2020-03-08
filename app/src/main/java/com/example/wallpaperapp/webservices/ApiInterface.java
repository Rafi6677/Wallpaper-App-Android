package com.example.wallpaperapp.webservices;

import com.example.wallpaperapp.models.Photo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("photos")
    Call<List<Photo>> getPhotos();
}
