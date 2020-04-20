package com.debasish.novopayhomework.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ServerResponseSources implements Serializable {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("sources")
    @Expose
    private List<Source> sources = null;
    private final static long serialVersionUID = 1145512014669342993L;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Source> getSources() {
        return sources;
    }

    public void setSources(List<Source> sources) {
        this.sources = sources;
    }



}
