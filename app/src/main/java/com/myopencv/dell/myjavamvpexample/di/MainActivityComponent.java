package com.myopencv.dell.myjavamvpexample.di;

import com.myopencv.dell.myjavamvpexample.presentation.Activityes.MainActivity;

import dagger.Subcomponent;

@Subcomponent(modules = {MainActivityModule.class})
@ActivityScope
public interface MainActivityComponent {
    DetailFragmentComponent showFollowerComponent(FollowerModule detailModule);
    void inject(MainActivity mainActivity);
}
