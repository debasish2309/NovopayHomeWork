package com.debasish.novopayhomework.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.debasish.novopayhomework.R;
import com.debasish.novopayhomework.WebviewActivity;
import com.debasish.novopayhomework.model.ServerResponseSources;
import com.debasish.novopayhomework.databinding.SingleLayoutBinding;
import com.debasish.novopayhomework.model.Source;
import com.jakewharton.rxbinding3.view.RxView;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import kotlin.Unit;

public class SourcesAdapter extends RecyclerView.Adapter<SourcesAdapter.MyViewHolder> {

    Context context;
    List<Source> sources;

    public SourcesAdapter(Context context, List<Source> sources) {
        this.context = context;
        this.sources = sources;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.binding.tvTitle.setText(sources.get(position).getDescription());

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
                        intent.putExtra("WEBVIEW",sources.get(position).getUrl());
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
        return sources.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        SingleLayoutBinding binding;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);

        }
    }
}
