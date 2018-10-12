package com.myopencv.dell.myjavamvpexample.data;

import com.myopencv.dell.myjavamvpexample.data.Net.NetModel;
import com.myopencv.dell.myjavamvpexample.domain.FollowerModel;

public class Transformer {

    public static FollowerModel transform(NetModel netModel){
        return new FollowerModel(netModel.getName() + netModel.getId(), netModel.getImage());
    }
}
