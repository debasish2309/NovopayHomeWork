package com.debasish.novopayhomework.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.debasish.novopayhomework.R;
import com.debasish.novopayhomework.WebviewActivity;
import com.debasish.novopayhomework.databinding.SingleLayoutBinding;
import com.debasish.novopayhomework.model.ServerResponseTopHeadlines;
import com.debasish.novopayhomework.model.TopHeadLineArticle;
import com.jakewharton.rxbinding3.view.RxView;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import kotlin.Unit;

public class TopHeadlinesAdapter extends RecyclerView.Adapter<TopHeadlinesAdapter.MyViewHolder> {

    Context context;
    List<TopHeadLineArticle> articleList;

    public TopHeadlinesAdapter(Context context, List<TopHeadLineArticle> articleList) {
        this.context = context;
        this.articleList = articleList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background);

        Glide.with(context)
                .setDefaultRequestOptions(options)
                .load(articleList.get(position).getUrlToImage())
                .into(holder.binding.ivImage);

        holder.binding.tvDate.setText(articleList.get(position).getPublishedAt());
        holder.binding.tvTitle.setText(articleList.get(position).getTitle());

        //Throttlefirst to handle multiple clicks
        RxView.clicks(holder.binding.llNewlayout)
                .throttleFirst(500, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Unit>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Unit unit) {
                        Intent intent = new Intent(context, WebviewActivity.class);
                        intent.putExtra("WEBVIEW",articleList.get(position).getUrl());
                        context.startActivity(intent);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        SingleLayoutBinding binding;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
}
