package com.myopencv.dell.myjavamvpexample;

import android.app.Application;

import com.myopencv.dell.myjavamvpexample.di.AppComponent;
import com.myopencv.dell.myjavamvpexample.di.AppModule;
import com.myopencv.dell.myjavamvpexample.di.DaggerAppComponent;
import com.myopencv.dell.myjavamvpexample.di.DetailFragmentComponent;
import com.myopencv.dell.myjavamvpexample.di.FollowerModule;
import com.myopencv.dell.myjavamvpexample.di.LogicModule;
import com.myopencv.dell.myjavamvpexample.di.MainActivityComponent;
import com.myopencv.dell.myjavamvpexample.di.MainActivityModule;
import com.myopencv.dell.myjavamvpexample.di.UseCaseComponent;

public class MyApplication extends Application {
    protected static MyApplication instance;

    public static MyApplication getInstance() {
        return instance;
    }

    private AppComponent appComponent;
    private MainActivityComponent activityComponent;
    private DetailFragmentComponent fragmentComponent;
    private UseCaseComponent logicComp;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(instance))
                .build();
    }

    public UseCaseComponent logicComponent() {
        if (logicComp == null) {
            logicComp = appComponent.logicListComponent(new LogicModule());
        }
        return logicComp;
    }

    //TODO delete appComponent from this component dependencies

    public MainActivityComponent listFollowersComponent() {
        if (activityComponent == null) {
            activityComponent = appComponent.showListComponent(new MainActivityModule());
        }
        return activityComponent;
    }

    //TODO create dependency manager and destroy presenter when new presenter started

    public void clearlistFollowersComponent() {
        activityComponent = null;
    }

    public DetailFragmentComponent followerComponent() {
        if (fragmentComponent == null) {
            fragmentComponent = activityComponent.showFollowerComponent(new FollowerModule());
        }
        return fragmentComponent;
    }

    public void clearfragmentComponent() {
        fragmentComponent = null;
    }

}
