package com.debasish.novopayhomework.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ServerResponseEverything implements Serializable {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("totalResults")
    @Expose
    private Integer totalResults;
    @SerializedName("articles")
    @Expose
    private List<EverythingArticle> articles = null;
    private final static long serialVersionUID = 2491656370174138504L;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public List<EverythingArticle> getArticles() {
        return articles;
    }

    public void setArticles(List<EverythingArticle> articles) {
        this.articles = articles;
    }


}
