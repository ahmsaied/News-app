package com.bottlesecret.news.newsapp;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomListAdapter extends ArrayAdapter<NewsList> {

    ArrayList<NewsList> newsLists;
    Context context;
    int resource;

    public CustomListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<NewsList> newsLists) {
        super(context, resource, newsLists);
        this.newsLists = newsLists;
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.custom_list_layout,null,true);
        }
        NewsList newsList = getItem(position);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);
        Picasso.get().load(newsList.getImage()).into(imageView);

        TextView newsTitle = (TextView) convertView.findViewById(R.id.newsTitle);
        newsTitle.setText(newsList.getTitle());

        TextView publishedAt = (TextView) convertView.findViewById(R.id.publishedAt);
        publishedAt.setText(newsList.getPublishedAt());

        TextView author = (TextView) convertView.findViewById(R.id.author);
        author.setText(newsList.getAuthor());

        TextView description = (TextView) convertView.findViewById(R.id.description);
        description.setText(newsList.getDescription());

        return convertView;
    }
}

