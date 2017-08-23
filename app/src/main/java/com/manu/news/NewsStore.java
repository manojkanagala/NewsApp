package com.manu.news;

import com.manu.news.model.Article;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Manu on 7/28/2017.
 */

public class NewsStore
{
    private static List<Article> newsArticles = new ArrayList<>();

    public static List<Article> getNewsArticles()
    {
        return newsArticles;
    }

    public static void setNewsArticles(List<Article> newsArticles)
    {
        NewsStore.newsArticles = newsArticles;
    }
}
