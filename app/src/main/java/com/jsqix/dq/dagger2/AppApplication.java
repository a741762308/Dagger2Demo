package com.jsqix.dq.dagger2;

import android.app.Application;

import com.jsqix.dq.dagger2.data.api.GithubApiModule;

/**
 * Created by dq on 2016/5/16.
 */
public class AppApplication extends Application {

    private static AppApplication sInstance;
    private AppComponent appComponent;

    @Override
    public void onCreate(){
        super.onCreate();
        this.sInstance = this;
        setupCompoent();
    }

    private void setupCompoent(){
        appComponent = DaggerAppComponent.builder()
                .githubApiModule(new GithubApiModule())
                .appModule(new AppModule(this))
                .build();
    }

    public static AppApplication getsInstance(){
        return sInstance;
    }

    public AppComponent getAppComponent(){
        return appComponent;
    }
}