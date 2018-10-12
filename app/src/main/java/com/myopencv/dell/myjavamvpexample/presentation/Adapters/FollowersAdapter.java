package com.myopencv.dell.myjavamvpexample.presentation.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myopencv.dell.myjavamvpexample.R;
import com.myopencv.dell.myjavamvpexample.domain.FollowerModel;
import com.myopencv.dell.myjavamvpexample.presentation.Presenters.IPresenter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FollowersAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private final IPresenter presenter;
    private final List<FollowerModel> followers;

    public FollowersAdapter(@NonNull IPresenter presenter) {
        this.presenter = presenter;
        followers = new ArrayList<>();
    }

    @Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.follower_row, parent, false);
        return new FollowerViewHolder(view, presenter);
    }

    @Override public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        FollowerViewHolder followerViewHolder = (FollowerViewHolder) holder;
        FollowerModel follower = followers.get(position);
        followerViewHolder.render(follower);
    }

    @Override public int getItemCount() {
        return followers.size();
    }

    public void addAll(Collection<FollowerModel> collection) {
        followers.addAll(collection);
    }
}
