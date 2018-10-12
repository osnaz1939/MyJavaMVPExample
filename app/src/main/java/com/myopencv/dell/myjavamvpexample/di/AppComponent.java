package com.myopencv.dell.myjavamvpexample.di;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {AppModule.class})
@Singleton
public interface AppComponent {
    MainActivityComponent showListComponent(MainActivityModule activityModule);
    UseCaseComponent logicListComponent(LogicModule logicModule);
}
