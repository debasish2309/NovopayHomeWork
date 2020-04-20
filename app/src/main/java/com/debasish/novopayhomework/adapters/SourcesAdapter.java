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

import java.util.List;

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
        holder.binding.llNewlayout.setOnClickListener(view -> {
            Intent intent = new Intent(context, WebviewActivity.class);
            intent.putExtra("WEBVIEW",sources.get(position).getUrl());
            context.startActivity(intent);


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
