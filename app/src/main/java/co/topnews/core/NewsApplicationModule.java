package co.topnews.core;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;

@Module
public class NewsApplicationModule {

    @Provides
    @Singleton
    HttpUrl provideEndpoint() {
        return HttpUrl.parse(AppConstants.BASE_URL);
    }




}
