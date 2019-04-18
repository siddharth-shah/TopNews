package co.topnews.core;

import javax.inject.Singleton;

import co.topnews.news_list.NewsListActivity;
import dagger.Component;

@Singleton
@Component(modules = {NewsApplicationModule.class,
        ApiModule.class})
public interface NewsApplicationComponent {

    void inject(NewsListActivity activity);

}
