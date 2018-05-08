package com.noman.dagger2sample.network;

import com.noman.dagger2sample.model.Hero;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RertofitApis {

    @GET("marvel")
    Call<List<Hero>> getHeroes();

}
