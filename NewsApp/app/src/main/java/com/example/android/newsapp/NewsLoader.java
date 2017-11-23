package com.example.android.newsapp;

import android.support.v4.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * Created by tarun on 7/7/17.
 */

public class NewsLoader extends AsyncTaskLoader<List<News>> {

    public NewsLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Override
    public List<News> loadInBackground() {
        List<News> listOfNews = null;
        try {
            URL url = QueryUtils.createUrl();
            String jsonResponse = QueryUtils.makeHttpRequest(url);
            listOfNews = QueryUtils.parseJson(jsonResponse);
        } catch (IOException e) {
            Log.e("Queryutils", "Error in LoadInBackground: ", e);
        }
        return listOfNews;
    }
}
