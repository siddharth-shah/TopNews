package co.topnews.core;

import javax.inject.Singleton;

import co.topnews.core.network.ApiModule;
import co.topnews.core.network.ClientModule;
import co.topnews.news_list.NewsListActivity;
import dagger.Component;

@Singleton
@Component(modules = {NewsApplicationModule.class,
        ClientModule.class,
        ApiModule.class})
public interface NewsApplicationComponent {

    void inject(NewsListActivity activity);

}
