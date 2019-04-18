package co.topnews.news_list.data;

import java.util.List;
import java.util.Map;

import co.topnews.news_list.models.NewsItem;
import io.reactivex.Observable;

public class NewsRepositoryImpl implements NewsRepository {
    @Override
    public Observable<List<NewsItem>> getTopHeadlines(Map<String, String> queryParams) {
        return null;
    }
}
