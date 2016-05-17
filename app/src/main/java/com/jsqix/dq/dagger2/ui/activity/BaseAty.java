package com.jsqix.dq.dagger2.ui.activity;

import android.os.Bundle;

import com.jsqix.dq.dagger2.AppApplication;
import com.jsqix.dq.dagger2.AppComponent;
import com.jsqix.utils.BaseActivity;

import org.xutils.x;

/**
 * Created by dq on 2016/5/16.
 */
public abstract class BaseAty extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        setupActivityComponent(AppApplication.getsInstance().getAppComponent());
    }

    protected abstract void setupActivityComponent(AppComponent appComponent);
}
