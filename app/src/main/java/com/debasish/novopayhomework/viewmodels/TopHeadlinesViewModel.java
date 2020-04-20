package com.debasish.novopayhomework.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.debasish.novopayhomework.model.EverythingArticle;
import com.debasish.novopayhomework.model.ServerResponseTopHeadlines;
import com.debasish.novopayhomework.model.Source;
import com.debasish.novopayhomework.model.TopHeadLineArticle;
import com.debasish.novopayhomework.repository.NewsItemRepository;

import java.util.List;

public class TopHeadlinesViewModel extends AndroidViewModel {

    NewsItemRepository newsItemRepository;
    private LiveData<List<TopHeadLineArticle>> topheadlineList;
    private LiveData<List<EverythingArticle>> everythilgList;
    private LiveData<List<Source>> sourceList;

    public TopHeadlinesViewModel(@NonNull Application application) {
        super(application);
        newsItemRepository = new NewsItemRepository();
        this.topheadlineList = newsItemRepository.getAllHeadlines();
        this.everythilgList = newsItemRepository.getEveryHeadlines();
        this.sourceList = newsItemRepository.getSource();
    }

    public LiveData<List<TopHeadLineArticle>> getTopheadlineList(){
        return topheadlineList;
    }

    public LiveData<List<EverythingArticle>> getEverythilgList() {
        return everythilgList;
    }

    public LiveData<List<Source>> getSourceList() {
        return sourceList;
    }
}
