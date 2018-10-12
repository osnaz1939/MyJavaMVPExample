package com.myopencv.dell.myjavamvpexample.data.Net;

import com.myopencv.dell.myjavamvpexample.domain.FollowerModel;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;

public interface GitHubAPI {
    @GET("/followers")
    Observable<List<NetModel>> listFollowers();
}
