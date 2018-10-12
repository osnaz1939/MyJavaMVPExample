package com.myopencv.dell.myjavamvpexample.data.Net;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkAdapter {
    private static GitHubAPI sGitHubAPI;
    private Retrofit retrofit;

    public NetworkAdapter() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/users/octocat")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        sGitHubAPI = retrofit.create(GitHubAPI.class);
    }

    public static GitHubAPI getApi() {
        return sGitHubAPI;
    }
}