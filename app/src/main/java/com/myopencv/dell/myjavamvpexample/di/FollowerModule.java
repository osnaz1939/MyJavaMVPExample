package com.myopencv.dell.myjavamvpexample.di;

import com.myopencv.dell.myjavamvpexample.presentation.Presenters.AbstractPresenter;
import com.myopencv.dell.myjavamvpexample.presentation.Presenters.DetailFollowerPresenter;

import dagger.Provides;

public class FollowerModule {
    private AbstractPresenter followerPresenter;

    public FollowerModule(){
        followerPresenter = new DetailFollowerPresenter();
    }

    @Provides
    @FragmentScope
    AbstractPresenter provideFollowersPresenter(){
        return followerPresenter;
    }
}
