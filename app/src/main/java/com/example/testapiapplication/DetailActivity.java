package com.example.testapiapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebView;

public class DetailActivity extends AppCompatActivity {
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        WebView webView = findViewById(R.id.webView);
        String link = getIntent().getStringExtra("link");
        webView.getSettings().setJavaScriptEnabled(true);
        assert link != null;
        webView.loadUrl(link);


    }
}