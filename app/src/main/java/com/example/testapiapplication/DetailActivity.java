package com.example.testapiapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        webView = findViewById(R.id.webView);
        Intent intent = getIntent();
        String link = getIntent().getStringExtra("link");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(link);


    }
}