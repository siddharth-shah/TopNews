package co.topnews.core;

import javax.inject.Singleton;

import co.topnews.core.network.ApiModule;
import co.topnews.core.network.ClientModule;
import dagger.Component;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Singleton
@Component(modules = {NewsApplicationModule.class,
        ClientModule.class,
        ApiModule.class})
public interface NewsApplicationComponent {


    OkHttpClient okHttpClient();

    Retrofit retrofit();

    HttpUrl endpoint();


}
