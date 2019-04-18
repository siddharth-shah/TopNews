package co.topnews.news_list.models;

import java.util.List;

public class TopHeadlinesResponseItem {

    String status;
    int totalResults;
    List<NewsItem> articles;

    public String getStatus() {
        return status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public List<NewsItem> getArticles() {
        return articles;
    }
}
