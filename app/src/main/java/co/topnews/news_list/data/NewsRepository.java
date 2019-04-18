package co.topnews.news_list.data;

import java.util.Map;

import co.topnews.news_list.models.TopHeadlinesResponseItem;
import io.reactivex.Observable;

public interface NewsRepository {
    Observable<TopHeadlinesResponseItem> getTopHeadlines(Map<String, String> queryParams);
}
