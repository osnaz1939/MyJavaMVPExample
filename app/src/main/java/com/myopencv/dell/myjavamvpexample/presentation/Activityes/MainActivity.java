package com.myopencv.dell.myjavamvpexample.presentation.Activityes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.myopencv.dell.myjavamvpexample.MyApplication;
import com.myopencv.dell.myjavamvpexample.R;
import com.myopencv.dell.myjavamvpexample.domain.FollowerModel;
import com.myopencv.dell.myjavamvpexample.presentation.Adapters.FollowersAdapter;
import com.myopencv.dell.myjavamvpexample.presentation.Fragments.DetailFragment;
import com.myopencv.dell.myjavamvpexample.presentation.IView;
import com.myopencv.dell.myjavamvpexample.presentation.Presenters.IPresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity implements IView {

    @Inject
    IPresenter presenter;

    @BindView(R.id.followers)
    RecyclerView followers;
    private FollowersAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyApplication.getInstance().listFollowersComponent().inject(this);
        presenter.setView(this);
        initializeAdapter();
        initializeRecyclerView();

    }

    public void showFollowers(List<FollowerModel> followersList) {
        adapter.addAll(followersList);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void openDetailFragment(FollowerModel folower) {
        DetailFragment detailFrag= DetailFragment.newInstance(folower);
        this.getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, detailFrag,"findThisFragment")
                .addToBackStack(null)
                .commit();
    }

    private void initializeAdapter() {
        adapter = new FollowersAdapter(presenter);
    }

    private void initializeRecyclerView() {
        followers.setLayoutManager(new LinearLayoutManager(this));
        followers.addItemDecoration(new android.support.v7.widget.DividerItemDecoration(this,
                android.support.v7.widget.DividerItemDecoration.VERTICAL));
        followers.setHasFixedSize(true);
        followers.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
