package com.myopencv.dell.myjavamvpexample.presentation.Presenters;

import android.support.annotation.NonNull;

import com.myopencv.dell.myjavamvpexample.presentation.AbstractView;

public class DetailFollowerPresenter implements AbstractPresenter{

    private AbstractView followerView;

    public void setView(@NonNull AbstractView view) {
        this.followerView = view;
    }

}
