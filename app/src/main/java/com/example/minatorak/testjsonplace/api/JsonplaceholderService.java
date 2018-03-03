package com.example.minatorak.testjsonplace.api;

import com.example.minatorak.testjsonplace.Pojo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;

/**
 * Created by minatorak on 3/3/2018 AD.
 */

public interface JsonplaceholderService {
    @GET("/posts/{number}")
    Call<Pojo> getposts(@Path("number") String number);
}
