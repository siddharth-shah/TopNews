package co.topnews.news_list.presenter;

import java.util.Map;

import co.topnews.news_list.NewsListView;

public interface NewsListPresenter {

    void attachView(NewsListView view);

    void getTopHeadlines(Map<String, String> queryParams);


}
