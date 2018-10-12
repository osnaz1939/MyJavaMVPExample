package com.myopencv.dell.myjavamvpexample.presentation;

import com.myopencv.dell.myjavamvpexample.domain.FollowerModel;

import java.util.List;

public interface IView {
    void openDetailFragment(FollowerModel folower);
    void showFollowers(List<FollowerModel> followersList);
}
