package com.example.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
    private List<newsModel> newsList;
    private Context context;

    public NewsAdapter(List<newsModel> newsList, Context context) {
        this.newsList = newsList;
        this.context = context;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_news_item, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        newsModel news = newsList.get(position);
        holder.title.setText(news.getTitle());
        holder.desc.setText(news.getDescription());
        Picasso.get().load(news.getUrlToImage()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    class NewsViewHolder extends RecyclerView.ViewHolder {
        TextView title, desc;
        ImageView image;

        public NewsViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.newsTitle);
            desc = itemView.findViewById(R.id.newsDesc);
            image = itemView.findViewById(R.id.newsImage);
        }
    }
}