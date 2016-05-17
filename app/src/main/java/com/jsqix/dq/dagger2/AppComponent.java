package com.jsqix.dq.dagger2;

import android.app.Application;

import com.jsqix.dq.dagger2.data.api.GithubApiModule;
import com.jsqix.dq.dagger2.data.api.GithubApiService;
import com.jsqix.utils.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by dq on 2016/5/16.
 */
@Singleton
@Component(modules = {AppModule.class, GithubApiModule.class})
public interface AppComponent {
    void inject(BaseActivity baseActivity);

    Application getApplication();

    GithubApiService getService();
}