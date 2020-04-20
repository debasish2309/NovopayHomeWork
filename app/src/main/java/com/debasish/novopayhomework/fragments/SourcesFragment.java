package com.debasish.novopayhomework.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.debasish.novopayhomework.R;
import com.debasish.novopayhomework.adapters.SourcesAdapter;
import com.debasish.novopayhomework.databinding.FragmentSourcesBinding;
import com.debasish.novopayhomework.model.ServerResponseSources;
import com.debasish.novopayhomework.model.Source;
import com.debasish.novopayhomework.rest.ApiClient;
import com.debasish.novopayhomework.rest.ApiInterface;
import com.debasish.novopayhomework.viewmodels.TopHeadlinesViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class SourcesFragment extends Fragment {

    FragmentSourcesBinding binding;
    List<Source> sourceList = new ArrayList<>();
    SourcesAdapter adapter;
    TopHeadlinesViewModel viewModel;

    public SourcesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_sources, container, false);
        View view = binding.getRoot();


        viewModel = ViewModelProviders.of(getActivity()).get(TopHeadlinesViewModel.class);
        viewModel.getSourceList().observe(getActivity(), sources -> {
            sourceList.addAll(sources);
            adapter = new SourcesAdapter(getActivity(),sourceList);
            binding.rvPastOrders.setLayoutManager(new LinearLayoutManager(getActivity()));
            binding.rvPastOrders.setAdapter(adapter);

        });
        return view;
    }

}
