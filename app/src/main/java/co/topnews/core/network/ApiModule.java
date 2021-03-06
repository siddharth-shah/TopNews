package co.topnews.core.network;

import com.squareup.moshi.Moshi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

@Module
public class ApiModule {

    @Singleton
    @Provides
    public Retrofit provideRetrofit(HttpUrl url, Converter.Factory factory, CallAdapter.Factory callAdapterFactory,
                                    OkHttpClient httpClient) {
        return new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(factory)
                .addCallAdapterFactory(callAdapterFactory)
                .client(httpClient)
                .build();

    }

    @Singleton
    @Provides
    public Converter.Factory provideMoshiConverterFactory(Moshi moshi) {
        return MoshiConverterFactory.create(moshi);
    }

    @Singleton
    @Provides
    public Moshi provideMoshi() {
        return new Moshi.Builder().build();
    }

    @Singleton
    @Provides
    public CallAdapter.Factory provideRxJavaCallAdapterFactory() {
        return RxJava2CallAdapterFactory.create();
    }

}
