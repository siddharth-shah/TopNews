package co.topnews;

import android.app.Application;

import co.topnews.core.DaggerNewsApplicationComponent;
import co.topnews.core.NewsApplicationComponent;
import co.topnews.core.NewsApplicationModule;
import co.topnews.core.network.ApiModule;
import co.topnews.core.network.ClientModule;


public class NewsApplication extends Application {

    private static NewsApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = createComponent();
    }

    private NewsApplicationComponent createComponent() {
        return DaggerNewsApplicationComponent.builder()
                .apiModule(new ApiModule())
                .clientModule(new ClientModule())
                .newsApplicationModule(new NewsApplicationModule())
                .build();
    }

    public static NewsApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
