package com.myopencv.dell.myjavamvpexample.data;

import com.myopencv.dell.myjavamvpexample.domain.FollowerModel;

import java.util.List;

import io.reactivex.Single;

public interface Repository {
    Single<List<FollowerModel>> getFollowers();
}
