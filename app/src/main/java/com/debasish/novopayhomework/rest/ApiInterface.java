package com.debasish.novopayhomework.rest;

import com.debasish.novopayhomework.model.ServerResponseEverything;
import com.debasish.novopayhomework.model.ServerResponseSources;
import com.debasish.novopayhomework.model.ServerResponseTopHeadlines;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("top-headlines")
    Call<ServerResponseTopHeadlines> getTopHeadlines(@Query("country") String country, @Query("apiKey") String apiKey);

    @GET("everything")
    Call<ServerResponseEverything> getEverything(@Query("q") String q,@Query("apiKey") String apiKey);

    @GET("sources")
    Call<ServerResponseSources> getSources(@Query("apiKey") String apiKey);

}
