package co.topnews.news_list;

import java.util.List;

import co.topnews.news_list.models.NewsItem;

public interface NewsListView {

    void setData(List<NewsItem> newsItems);

    void showError(String message);

    void showProgress();

    void hideProgress();


}
