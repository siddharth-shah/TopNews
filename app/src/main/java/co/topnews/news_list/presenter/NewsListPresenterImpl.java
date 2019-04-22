package co.topnews.news_list.presenter;

import java.util.Map;

import co.topnews.news_list.NewsListView;
import co.topnews.news_list.data.repository.NewsRepository;
import co.topnews.news_list.models.TopHeadlinesResponseItem;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class NewsListPresenterImpl implements NewsListPresenter {

    private Scheduler process;
    private Scheduler setter;
    NewsListView newsListView;
    NewsRepository repository;

    public void attachView(NewsListView view) {
        this.newsListView = view;
    }

    public NewsListPresenterImpl(NewsListView view, NewsRepository repository) {
        this.repository = repository;
    }

    public NewsListPresenterImpl(NewsRepository repository, Scheduler process, Scheduler setter) {
        this.repository = repository;
        this.process = process;
        this.setter = setter;
    }

    @Override
    public void getTopHeadlines(Map<String, String> queryParams) {
        repository.getTopHeadlines(queryParams)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TopHeadlinesResponseItem>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TopHeadlinesResponseItem topHeadlinesResponseItem) {
                        newsListView.setData(topHeadlinesResponseItem.getArticles());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }
}
