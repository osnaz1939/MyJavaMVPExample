package com.myopencv.dell.myjavamvpexample.presentation.Presenters;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;

import com.myopencv.dell.myjavamvpexample.domain.FollowerModel;
import com.myopencv.dell.myjavamvpexample.domain.GetFollowers;
import com.myopencv.dell.myjavamvpexample.presentation.IView;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class GetFollowersPresenter implements IPresenter {

    @Inject
    GetFollowers followersUseCase;
    private IView followersListView;

    //TODO review constructor and inject dependencies
    public GetFollowersPresenter(){
    }

    @SuppressLint("CheckResult")
    @Override
    public void setView(@NonNull IView view) {
        this.followersListView = view;
        followersUseCase.getFolowers()
               .subscribe(this::showFollowers);
    }

    @Override
    public void onFollowerClicked(@NonNull FollowerModel folower){
        followersListView.openDetailFragment(folower);
    }

    @Override
    public void showFollowers(List<FollowerModel> followersList) {
        followersListView.showFollowers(followersList);
    }

}
