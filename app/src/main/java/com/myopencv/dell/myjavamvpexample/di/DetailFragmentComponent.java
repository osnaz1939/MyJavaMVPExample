package com.myopencv.dell.myjavamvpexample.di;

import com.myopencv.dell.myjavamvpexample.presentation.Fragments.DetailFragment;

import dagger.Subcomponent;

@Subcomponent(modules = {FollowerModule.class})
@FragmentScope
public interface DetailFragmentComponent {
    void inject(DetailFragment follower);
}
