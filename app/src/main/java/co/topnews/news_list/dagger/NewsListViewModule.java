package co.topnews.news_list.dagger;

import co.topnews.news_list.NewsListView;
import co.topnews.news_list.data.repository.NewsRepository;
import co.topnews.news_list.presenter.NewsListPresenter;
import co.topnews.news_list.presenter.NewsListPresenterImpl;
import dagger.Module;
import dagger.Provides;

@Module
public class NewsListViewModule {

    private NewsListView view;

    public NewsListViewModule(NewsListView view) {
        this.view = view;
    }

    @Provides
    public NewsListPresenter providesNewsListPresenter(NewsRepository repository) {
        return new NewsListPresenterImpl(view,repository);
    }

}
