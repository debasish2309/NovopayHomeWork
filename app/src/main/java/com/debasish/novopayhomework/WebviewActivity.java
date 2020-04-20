package com.debasish.novopayhomework;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.debasish.novopayhomework.databinding.ActivityWebviewBinding;

public class WebviewActivity extends AppCompatActivity {

    ActivityWebviewBinding binding;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_webview);

        url = getIntent().getStringExtra("WEBVIEW");

        binding.webview.getSettings().setJavaScriptEnabled(true);
        binding.webview.loadUrl(url);


    }
}
