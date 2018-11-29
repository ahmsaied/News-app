package com.bottlesecret.news.newsapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class CNNNewsActivity extends AppCompatActivity {

    ArrayList<NewsList> arrayList;
    ListView lv;

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        arrayList = new ArrayList<>();
        lv = (ListView) findViewById(R.id.listView);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new CNNNewsActivity.ReadJSON().execute("https://newsapi.org/v2/top-headlines?sources=cnn&apiKey=d0eccea4ff764654b4f7b65b1dc2a664");
            }
        });
    }

    class ReadJSON extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String... params) {
            return readURL(params[0]);
        }

        @Override
        protected void onPostExecute(String content) {
            try {
                final JSONObject jsonObject = new JSONObject(content);
                final JSONArray jsonArray = jsonObject.getJSONArray("articles");


                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject newsListObject = jsonArray.getJSONObject(i);
                    arrayList.add(new NewsList(
                            newsListObject.getString("urlToImage"),
                            newsListObject.getString("title"),
                            newsListObject.getString("publishedAt"),
                            newsListObject.getString("author"),
                            newsListObject.getString("description")
                    ));
                }
                CustomListAdapter adapter = new CustomListAdapter(
                        getApplicationContext(), R.layout.custom_list_layout, arrayList
                );
                lv.setAdapter(adapter);

                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Intent intent = new Intent(CNNNewsActivity.this, details.class);

                        try {
                            JSONObject m = jsonArray.getJSONObject(position);
                            String link = m.getString("url");
                            intent.putExtra("url", link);
                            startActivity(intent);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });

            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
    }

    private static String readURL(String theUrl) {
        StringBuilder content = new StringBuilder();
        try {
            // create a url object
            URL url = new URL(theUrl);
            // create a urlconnection object
            URLConnection urlConnection = url.openConnection();
            // wrap the urlconnection in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            // read from the urlconnection via the bufferedreader
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content.toString();
    }
}

