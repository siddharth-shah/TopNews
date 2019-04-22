package co.topnews.news_list.data.api;

import java.util.Map;

import co.topnews.news_list.models.TopHeadlinesResponseItem;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface NewsListApi {
    String QUERY_PARAM_COUNTRY_CODE = "country";
    String QUERY_PARAM_API_KEY = "apiKey";
    String QUERY_PARAM_PAGE = "page";
    String QUERY_PARAM_PAGE_SIZE = "pageSize";


    @GET("/v2/top-headlines")
    Observable<TopHeadlinesResponseItem> getTopHeadLines(@QueryMap Map<String, String> queryParams);


}
