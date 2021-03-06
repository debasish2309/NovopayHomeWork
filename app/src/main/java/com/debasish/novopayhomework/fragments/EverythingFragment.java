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
import android.widget.LinearLayout;

import com.debasish.novopayhomework.R;
import com.debasish.novopayhomework.adapters.EverythingAdapter;
import com.debasish.novopayhomework.adapters.SourcesAdapter;
import com.debasish.novopayhomework.adapters.TopHeadlinesAdapter;
import com.debasish.novopayhomework.databinding.FragmentEverythingBinding;
import com.debasish.novopayhomework.model.EverythingArticle;
import com.debasish.novopayhomework.model.ServerResponseEverything;
import com.debasish.novopayhomework.model.ServerResponseSources;
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
public class EverythingFragment extends Fragment {

    FragmentEverythingBinding binding;
    List<EverythingArticle> articleList = new ArrayList<>();
    EverythingAdapter everythingAdapter;
    ApiInterface apiInterface;
    TopHeadlinesViewModel viewModel;

    public EverythingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_everything, container, false);
        View view = binding.getRoot();

        viewModel = ViewModelProviders.of(getActivity()).get(TopHeadlinesViewModel.class);
        viewModel.getEverythilgList().observe(getActivity(), everythingArticles -> {
            articleList.addAll(everythingArticles);
            everythingAdapter = new EverythingAdapter(getActivity(),articleList);
            binding.rvPastOrders.setLayoutManager(new LinearLayoutManager(getActivity()));
            binding.rvPastOrders.setAdapter(everythingAdapter);
        });
        return view;
    }


}
