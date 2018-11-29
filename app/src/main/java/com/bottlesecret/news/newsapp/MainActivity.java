package com.bottlesecret.news.newsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // Find the View that shows the ABC News category
        TextView news = (TextView) findViewById(R.id.abc_news);

        // Set a click listener on that View
        news.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the ABC News category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link ABCNewsActivity}
                Intent ABCNewsIntent = new Intent(MainActivity.this, ABCNewsActivity.class);
                Log.e("eee", "llll");
                // Start the new activity
                MainActivity.this.startActivity(ABCNewsIntent);
            }
        });

        // Find the View that shows the The Washington Post category
        TextView TheWashingtonPost = (TextView) findViewById(R.id.the_washington_post);

        // Set a click listener on that View
        TheWashingtonPost.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the The Washington Post category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link TheWashingtonPostActivity}
                Intent TheWashingtonPostIntent = new Intent(MainActivity.this, TheWashingtonPostActivity.class);

                // Start the new activity
                startActivity(TheWashingtonPostIntent);
            }
        });

        // Find the View that shows the Fox News category
        TextView FoxNews = (TextView) findViewById(R.id.fox_news);

        // Set a click listener on that View
        FoxNews.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the Fox News category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link FoxNewsActivity}
                Intent FoxNewsIntent = new Intent(MainActivity.this, FoxNewsActivity.class);

                // Start the new activity
                startActivity(FoxNewsIntent);
            }
        });

        // Find the View that shows the CBS News category
        TextView CBSNews = (TextView) findViewById(R.id.cbs_news);

        // Set a click listener on that View
        CBSNews.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the CBS News category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link CBSNewsActivity}
                Intent CBSNewsIntent = new Intent(MainActivity.this, CBSNewsActivity.class);

                // Start the new activity
                startActivity(CBSNewsIntent);
            }
        });


        // Find the View that shows the CBS News category
        TextView BBCNews = (TextView) findViewById(R.id.bbc_news);

        // Set a click listener on that View
        BBCNews.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the CBS News category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link CBSNewsActivity}
                Intent BBCNewsIntent = new Intent(MainActivity.this, BBCNewsActivity.class);

                // Start the new activity
                startActivity(BBCNewsIntent);
            }
        });

        // Find the View that shows the CBS News category
        TextView CNNNews = (TextView) findViewById(R.id.cnn_news);

        // Set a click listener on that View
        CNNNews.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the CBS News category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link CBSNewsActivity}
                Intent CNNNewsIntent = new Intent(MainActivity.this, CNNNewsActivity.class);

                // Start the new activity
                startActivity(CNNNewsIntent);
            }
        });
    }
}
