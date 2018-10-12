package com.myopencv.dell.myjavamvpexample.data;

import com.myopencv.dell.myjavamvpexample.data.Net.NetworkAdapter;
import com.myopencv.dell.myjavamvpexample.domain.FollowerModel;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ExternalRepositoryImpl implements ExternalRepository {
    private NetworkAdapter mNetworkAdapter = new NetworkAdapter();
    @Override
    public Single<List<FollowerModel>> getFollowers() {
        return mNetworkAdapter.getApi().listFollowers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(Observable::fromIterable)
                .map(it->Transformer.transform(it))
                .filter(it -> it.getPictureOfHeader()!=null)
                .toList();

    }
}
