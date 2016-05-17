package com.jsqix.dq.dagger2.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.jsqix.dq.dagger2.AppComponent;
import com.jsqix.dq.dagger2.R;
import com.jsqix.dq.dagger2.data.api.GithubApiService;
import com.jsqix.dq.dagger2.data.model.Repo;
import com.jsqix.dq.dagger2.ui.adapter.ListAdapter;
import com.jsqix.dq.dagger2.utils.SimpleObserver;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@ContentView(R.layout.activity_repos_list)
public class ReposListActivity extends BaseAty {
    @ViewInject(R.id.repos_rv_list)
    RecyclerView mRvList;

    @ViewInject(R.id.pbLoading)
    ProgressBar pbLoading;

//    @Inject
    GithubApiService githubApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
    }

    @Override
    public void setupActivityComponent(AppComponent appComponent) {
        appComponent.inject(this);
        githubApiService = appComponent.getService();
    }


    private void initView() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRvList.setLayoutManager(manager);

        ListAdapter adapter = new ListAdapter();
        mRvList.setAdapter(adapter);
        loadData(adapter);
    }

    private void loadData(final ListAdapter adapter) {
        showLoading(true);
        githubApiService.getRepoData(getUser())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SimpleObserver<ArrayList<Repo>>() {
                    @Override
                    public void onNext(ArrayList<Repo> repos) {
                        showLoading(false);
                        adapter.setRepos(repos);
                    }

                    @Override
                    public void onError(Throwable e) {
                        showLoading(false);
                    }
                });
    }

    private String getUser() {
        return "a741762308";
    }

    public void showLoading(boolean loading) {
        Log.i("info", loading + " Repos");
        pbLoading.setVisibility(loading ? View.VISIBLE : View.GONE);
    }
}
