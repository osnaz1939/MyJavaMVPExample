package com.myopencv.dell.myjavamvpexample.presentation.Presenters;

import android.support.annotation.NonNull;

import com.myopencv.dell.myjavamvpexample.presentation.AbstractView;

public interface AbstractPresenter {
    void setView(@NonNull AbstractView view);
}
