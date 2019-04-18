package co.topnews.news_list.data;

import java.util.Map;

import co.topnews.news_list.data.api.NewsListApi;
import co.topnews.news_list.models.TopHeadlinesResponseItem;
import io.reactivex.Observable;

public class NewsRepositoryImpl implements NewsRepository {

    private NewsListApi newsListApi;

    public NewsRepositoryImpl(NewsListApi newsListApi) {
        this.newsListApi = newsListApi;
    }

    @Override
    public Observable<TopHeadlinesResponseItem> getTopHeadlines(Map<String, String> queryParams) {
        return newsListApi.getTopHeadLines(queryParams);
    }
}
