package com.myopencv.dell.myjavamvpexample.domain;

import com.myopencv.dell.myjavamvpexample.data.Repository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Single;

public class GetFollowers implements UseCase {
    @Inject
    Repository dataRepositiry;

    public GetFollowers(){

    }

    public Single<List<FollowerModel>> getFolowers(){
        return dataRepositiry.getFollowers();
    }
}
