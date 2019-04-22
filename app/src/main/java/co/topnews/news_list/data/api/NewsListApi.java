package co.topnews.news_list.data.api;

import java.util.Map;

import co.topnews.news_list.models.TopHeadlinesResponseItem;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface NewsListApi {

    @GET("/v2/top-headlines")
    Observable<TopHeadlinesResponseItem> getTopHeadLines(@QueryMap Map<String, String> queryParams);


}
