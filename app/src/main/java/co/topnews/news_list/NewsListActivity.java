package co.topnews.news_list;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import co.topnews.NewsApplication;
import co.topnews.R;
import co.topnews.core.NewsApplicationComponent;
import co.topnews.news_list.dagger.DaggerNewsListComponent;
import co.topnews.news_list.dagger.NewsListViewModule;
import co.topnews.news_list.data.dagger.NewsListApiModule;
import co.topnews.news_list.data.dagger.NewsRepositoryModule;
import co.topnews.news_list.models.NewsItem;
import co.topnews.news_list.presenter.NewsListPresenter;

public class NewsListActivity extends AppCompatActivity implements NewsListView {


    @Inject
    NewsListPresenter presenter;
    private RecyclerView newsList;
    private NewsListAdapter newsListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);
        newsList = findViewById(R.id.news_list);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(newsList.getContext(),
                layoutManager.getOrientation());
        newsList.addItemDecoration(dividerItemDecoration);
        newsList.setLayoutManager(layoutManager);
        final EndlessRecyclerViewOnScrollListener endlessRecyclerViewOnScrollListener = setupScrollListener(layoutManager);
        newsList.addOnScrollListener(endlessRecyclerViewOnScrollListener);
        newsListAdapter = new NewsListAdapter(this);
        newsList.setAdapter(newsListAdapter);

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


    private EndlessRecyclerViewOnScrollListener setupScrollListener(
            RecyclerView.LayoutManager layoutManager) {
        return new EndlessRecyclerViewOnScrollListener((LinearLayoutManager) layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount) {

            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.attachView(this);
    }

    @Override
    public void setData(List<NewsItem> newsItems) {
        if (newsListAdapter != null) {
            newsListAdapter.setData(newsItems);
        }
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
