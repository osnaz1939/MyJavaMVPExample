package com.myopencv.dell.myjavamvpexample.presentation.Presenters;

import android.support.annotation.NonNull;

import com.myopencv.dell.myjavamvpexample.domain.FollowerModel;
import com.myopencv.dell.myjavamvpexample.presentation.IView;

import java.util.List;

public interface IPresenter {
    void setView(@NonNull IView view);
    void onFollowerClicked(@NonNull FollowerModel folower);
    void showFollowers(List<FollowerModel> followersList);
}
