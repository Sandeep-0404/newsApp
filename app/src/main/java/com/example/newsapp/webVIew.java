package com.example.newsapp;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class webVIew extends AppCompatActivity {

    WebView webView;
    ProgressBar progressBar;
    String url;
    ConstraintLayout cLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_v_iew);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        Intent intent = getIntent();
        url = intent.getStringExtra("url");

        progressBar = findViewById(R.id.progressBar);
        cLayout = findViewById(R.id.condtLayout);
        webView = (WebView) findViewById(R.id.webView);

        checkConnection();


        webView.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });


        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                progressBar.setVisibility(View.VISIBLE);
                progressBar.setProgress(newProgress);

                if (newProgress == 100) progressBar.setVisibility(View.GONE);

                super.onProgressChanged(view, newProgress);

            }
        });


    }

    private void checkConnection() {
        ConnectivityManager connectivityManager = (ConnectivityManager)
                this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifi = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo net = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);


        if (wifi.isConnected() || net.isConnected()) {
            webView.loadUrl(url);
            webView.setVisibility(View.VISIBLE);
            cLayout.setVisibility(View.GONE);

        } else {
            webView.setVisibility(View.GONE);
            cLayout.setVisibility(View.VISIBLE);

        }

    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else

            super.onBackPressed();
    }

    public void retry(View view) {

        checkConnection();

    }
}