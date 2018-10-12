package com.myopencv.dell.myjavamvpexample.presentation.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.myopencv.dell.myjavamvpexample.R;
import com.myopencv.dell.myjavamvpexample.domain.FollowerModel;
import com.myopencv.dell.myjavamvpexample.presentation.Presenters.IPresenter;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FollowerViewHolder extends RecyclerView.ViewHolder {

    private final IPresenter folowersPresenter;
    @BindView(R.id.image_header)
    ImageView headerImage;
    @BindView(R.id.label_name)
    TextView nameLabel;

    public FollowerViewHolder(@NonNull View itemView, @NonNull IPresenter folowersPresenter) {
        super(itemView);
        this.folowersPresenter = folowersPresenter;
        ButterKnife.bind(this, itemView);
    }

    public void render(FollowerModel folower) {
        onItemClick(folower);
        renderFollowerHeaderImage(folower.getPictureOfHeader());
        renderFollowerName(folower.getName());
    }

    private void onItemClick(final FollowerModel folower) {
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                folowersPresenter.onFollowerClicked(folower);
            }
        });
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
}
