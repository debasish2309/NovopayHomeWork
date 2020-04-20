package com.debasish.novopayhomework.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.debasish.novopayhomework.model.EverythingArticle;
import com.debasish.novopayhomework.model.ServerResponseEverything;
import com.debasish.novopayhomework.model.ServerResponseSources;
import com.debasish.novopayhomework.model.ServerResponseTopHeadlines;
import com.debasish.novopayhomework.model.Source;
import com.debasish.novopayhomework.model.TopHeadLineArticle;
import com.debasish.novopayhomework.rest.ApiClient;
import com.debasish.novopayhomework.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsItemRepository {

    ApiInterface apiInterface;

    public NewsItemRepository() {
        this.apiInterface = ApiClient.getClient().create(ApiInterface.class);
    }


    public LiveData<List<TopHeadLineArticle>> getAllHeadlines(){
        final MutableLiveData<List<TopHeadLineArticle>> headlines = new MutableLiveData<>();
        apiInterface.getTopHeadlines("us","adaf28d6eee54dc4b27567be3699c57d").enqueue(new Callback<ServerResponseTopHeadlines>() {
            @Override
            public void onResponse(Call<ServerResponseTopHeadlines> call, Response<ServerResponseTopHeadlines> response) {
                if(response.body() != null){
                    headlines.setValue(response.body().getArticles());
                }
            }

            @Override
            public void onFailure(Call<ServerResponseTopHeadlines> call, Throwable t) {
                headlines.setValue(null);
            }
        });
        return headlines;
    }

    public LiveData<List<EverythingArticle>> getEveryHeadlines(){
        final MutableLiveData<List<EverythingArticle>> everyarticle = new MutableLiveData<>();
        apiInterface.getEverything("bitcoin","adaf28d6eee54dc4b27567be3699c57d").enqueue(new Callback<ServerResponseEverything>() {
            @Override
            public void onResponse(Call<ServerResponseEverything> call, Response<ServerResponseEverything> response) {
                if(response.body() != null){
                    everyarticle.setValue(response.body().getArticles());

                }
            }

            @Override
            public void onFailure(Call<ServerResponseEverything> call, Throwable t) {
                everyarticle.setValue(null);

            }
        });
        return everyarticle;

    }

    public LiveData<List<Source>> getSource(){
        final MutableLiveData<List<Source>> sources = new MutableLiveData<>();
        apiInterface.getSources("adaf28d6eee54dc4b27567be3699c57d").enqueue(new Callback<ServerResponseSources>() {
            @Override
            public void onResponse(Call<ServerResponseSources> call, Response<ServerResponseSources> response) {
                if(response.body() != null){
                    sources.setValue(response.body().getSources());
                }
            }

            @Override
            public void onFailure(Call<ServerResponseSources> call, Throwable t) {
                sources.setValue(null);
            }
        });
        return sources;
    }
}
