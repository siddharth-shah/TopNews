package co.topnews.news_list.dagger;

import co.topnews.core.NewsApplicationComponent;
import co.topnews.core.scopes.ActivityScope;
import co.topnews.news_list.NewsListActivity;
import co.topnews.news_list.data.dagger.NewsRepositoryModule;
import co.topnews.news_list.data.dagger.NewsListApiModule;
import dagger.Component;

@ActivityScope
@Component(dependencies = {NewsApplicationComponent.class},
        modules = {NewsListApiModule.class, NewsRepositoryModule.class, NewsListViewModule.class}
)
public interface NewsListComponent {
    void inject(NewsListActivity activity);
}
