package com.example.bakhbk.newapp_st1;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

//Loads a list of news by using an AsyncTask to perform the network request to the given URL.
class NewsLoader extends AsyncTaskLoader<List<News>> {

    //Query URL
    private final String mUrl;

    /**
     * Constructs a new {@link NewsLoader}.
     *
     * @param context of the activity
     * @param url     to load data
     */
    public NewsLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    //This is on a background thread.
    @Override
    public List<News> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of news.
        return NewsAppUtils.fetchNewsData(mUrl);
    }
}