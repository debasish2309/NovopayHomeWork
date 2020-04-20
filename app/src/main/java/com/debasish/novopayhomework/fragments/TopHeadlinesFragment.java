package com.debasish.novopayhomework.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.debasish.novopayhomework.R;
import com.debasish.novopayhomework.adapters.TopHeadlinesAdapter;
import com.debasish.novopayhomework.databinding.FragmentTopHeadlinesBinding;
import com.debasish.novopayhomework.model.ServerResponseTopHeadlines;
import com.debasish.novopayhomework.model.TopHeadLineArticle;
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
public class TopHeadlinesFragment extends Fragment {

    FragmentTopHeadlinesBinding binding;
    List<TopHeadLineArticle> articleList =  new ArrayList<>();
    TopHeadlinesAdapter topHeadlinesAdapter;
  //  ApiInterface apiInterface;
    TopHeadlinesViewModel viewModel;

    public TopHeadlinesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_top_headlines, container, false);
        View view = binding.getRoot();

        viewModel = ViewModelProviders.of(getActivity()).get(TopHeadlinesViewModel.class);
        viewModel.getTopheadlineList().observe(getActivity(), topHeadLineArticles -> {
            articleList.addAll(topHeadLineArticles);
            topHeadlinesAdapter = new TopHeadlinesAdapter(getActivity(),articleList);
            binding.rvPastOrders.setLayoutManager(new LinearLayoutManager(getActivity()));
            binding.rvPastOrders.setAdapter(topHeadlinesAdapter);

        });

        return view;
    }

}
