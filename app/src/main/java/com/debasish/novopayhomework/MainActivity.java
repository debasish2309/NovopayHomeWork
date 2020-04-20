package com.debasish.novopayhomework;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.debasish.novopayhomework.adapters.PagerAdapter;
import com.debasish.novopayhomework.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        pagerAdapter = new PagerAdapter(getSupportFragmentManager(),binding.tablayout.getTabCount());
        binding.viewPager.setAdapter(pagerAdapter);
        binding.viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(binding.tablayout));
        binding.tablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                binding.viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
