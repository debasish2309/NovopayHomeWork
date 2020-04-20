package com.debasish.novopayhomework.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.debasish.novopayhomework.R;
import com.debasish.novopayhomework.WebviewActivity;
import com.debasish.novopayhomework.model.EverythingArticle;
import com.debasish.novopayhomework.model.ServerResponseEverything;
import com.debasish.novopayhomework.databinding.SingleLayoutBinding;
import com.jakewharton.rxbinding3.view.RxView;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import kotlin.Unit;

public class EverythingAdapter extends RecyclerView.Adapter<EverythingAdapter.MyViewHolder> {

    Context context;
    List<EverythingArticle> articleList;

    public EverythingAdapter(Context context, List<EverythingArticle> articleList) {
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

        holder.binding.llNewlayout.setOnClickListener(view -> {
            Intent intent = new Intent(context, WebviewActivity.class);
            intent.putExtra("WEBVIEW",articleList.get(position).getUrl());
            context.startActivity(intent);
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
