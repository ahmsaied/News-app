package com.bottlesecret.news.newsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class details extends AppCompatActivity {

    private WebView tvDetials;

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        final WebView tvDetials = (WebView) findViewById(R.id.tv_details);

        String url = getIntent().getStringExtra("url");
        tvDetials.loadUrl(url);


    }
}
