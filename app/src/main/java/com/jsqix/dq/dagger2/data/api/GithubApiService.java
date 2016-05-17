package com.jsqix.dq.dagger2.data.api;

import com.jsqix.dq.dagger2.data.model.Repo;

import java.util.ArrayList;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

public interface GithubApiService {
    @GET("/users/{user}/repos")
    Observable<ArrayList<Repo>> getRepoData(@Path("user") String user);
}