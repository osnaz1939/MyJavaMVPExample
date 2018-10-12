package com.myopencv.dell.myjavamvpexample.di;

import com.myopencv.dell.myjavamvpexample.presentation.Presenters.GetFollowersPresenter;
import com.myopencv.dell.myjavamvpexample.presentation.Presenters.IPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {
    private IPresenter mainActivityPresenter;

    public MainActivityModule(){
        mainActivityPresenter = new GetFollowersPresenter();
    }

    @Provides
    @ActivityScope
    IPresenter provideFollowersPresenter(){
        return mainActivityPresenter;
    }
}
