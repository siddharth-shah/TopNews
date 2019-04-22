package co.topnews.news_list.data.dagger;

import co.topnews.news_list.data.repository.NewsRepository;
import co.topnews.news_list.data.repository.NewsRepositoryImpl;
import co.topnews.news_list.data.api.NewsListApi;
import dagger.Module;
import dagger.Provides;

@Module
public class NewsRepositoryModule {

    @Provides
    public NewsRepository providesNewsRepo(NewsListApi api) {
        return new NewsRepositoryImpl(api);
    }
}
