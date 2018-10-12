package com.myopencv.dell.myjavamvpexample.di;

import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private Context appContext;

    public AppModule(@NonNull Context context){
        appContext = context;
    }

    @Provides
    @Singleton
    Context provideContext(){
        return appContext;
    }
}
