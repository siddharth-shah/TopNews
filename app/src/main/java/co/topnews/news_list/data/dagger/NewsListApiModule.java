package co.topnews.news_list.data.dagger;

import javax.inject.Singleton;

import co.topnews.news_list.data.api.NewsListApi;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class NewsListApiModule {

    @Provides
    public NewsListApi provideNewsListApi(Retrofit retrofit) {
        return retrofit.create(NewsListApi.class);
    }


}
