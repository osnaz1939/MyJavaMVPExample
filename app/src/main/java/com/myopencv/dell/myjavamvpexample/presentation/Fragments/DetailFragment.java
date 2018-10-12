package com.myopencv.dell.myjavamvpexample.presentation.Fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.myopencv.dell.myjavamvpexample.MyApplication;
import com.myopencv.dell.myjavamvpexample.R;
import com.myopencv.dell.myjavamvpexample.domain.FollowerModel;
import com.myopencv.dell.myjavamvpexample.presentation.AbstractView;
import com.myopencv.dell.myjavamvpexample.presentation.Presenters.AbstractPresenter;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

@SuppressLint("ValidFragment")
public class DetailFragment extends Fragment implements AbstractView {

    private static DetailFragment myFragment;
    private FollowerModel folowerDetail;

    @BindView(R.id.image_header)
    ImageView headerImage;
    @BindView(R.id.label_name)
    TextView nameLabel;

    @Inject
    AbstractPresenter followerPresenter;

    @SuppressLint("ValidFragment")
    public DetailFragment(FollowerModel folower){
        this.folowerDetail = folower;
    }

    public static DetailFragment newInstance(FollowerModel follower)
    {
        if(myFragment == null) {
            myFragment = new DetailFragment(follower);
        }
        return myFragment;
    }

    private void render(){
        renderFollowerHeaderImage(folowerDetail.getPictureOfHeader());
        renderFollowerName(folowerDetail.getName());
    }

    private void renderFollowerHeaderImage(String urlHeaderImage) {
        getImage(urlHeaderImage, headerImage);
    }

    private void renderFollowerName(String name) {
        nameLabel.setText(name);
    }

    private void getImage(String photo, ImageView photoImageView) {
        Picasso.get().load(photo).fit().centerCrop().into(photoImageView);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.follower_row, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        MyApplication.getInstance().followerComponent().inject(this);
        followerPresenter.setView(this);
    }
}
