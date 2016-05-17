package com.jsqix.dq.dagger2.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.jsqix.dq.dagger2.AppComponent;
import com.jsqix.dq.dagger2.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;

@ContentView(R.layout.activity_main)
public class MainActivity extends BaseAty {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Event(value = R.id.showButton)
    private void onShowRepositoriesClick(View v) {
        startActivity(new Intent(this, ReposListActivity.class));
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
    }
}
