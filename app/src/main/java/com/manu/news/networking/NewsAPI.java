package com.manu.news.networking;

import com.manu.news.model.GetArticlesResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Manu on 7/28/2017.
 */

public class NewsAPI
{
    private static final String APIKEY = "c533e7645d924a34b57d6d70647a2b80";
    private static final String APIPATH = "https://newsapi.org/v1/";

    private static NewsService newsService = null;

    // Singleton Instance
    public static NewsService getApi()
    {
        if (newsService == null)
        {
            //Initialize NewService
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(APIPATH)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            newsService = retrofit.create(NewsService.class);
        }
        return newsService;
    }
    public interface NewsService
    {
        @GET("articles?apiKey=" + APIKEY)
        Call<GetArticlesResponse> getArticles(@Query("source") String source, @Query("sortBy") String sortBy);
    }
}
