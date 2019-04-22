package co.topnews.news_list;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import co.topnews.NewsApplication;
import co.topnews.R;
import co.topnews.core.NewsApplicationComponent;
import co.topnews.news_list.dagger.DaggerNewsListComponent;
import co.topnews.news_list.dagger.NewsListViewModule;
import co.topnews.news_list.data.dagger.NewsRepositoryModule;
import co.topnews.news_list.data.dagger.NewsListApiModule;
import co.topnews.news_list.models.NewsItem;
import co.topnews.news_list.presenter.NewsListPresenter;

public class NewsListActivity extends AppCompatActivity implements NewsListView {


    @Inject
    NewsListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);
        setupComponent(NewsApplication.getApplicationComponent());
        HashMap<String, String> query = new HashMap<>();
        query.put("apiKey", "158b3705f4ec43ca913cbb7102c83359");
        query.put("country", "us");
        presenter.getTopHeadlines(query);
    }

    private void setupComponent(NewsApplicationComponent applicationComponent) {
        DaggerNewsListComponent
                .builder()
                .newsApplicationComponent(applicationComponent)
                .newsListApiModule(new NewsListApiModule())
                .newsRepositoryModule(new NewsRepositoryModule())
                .newsListViewModule(new NewsListViewModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void setData(List<NewsItem> newsItems) {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }
}
