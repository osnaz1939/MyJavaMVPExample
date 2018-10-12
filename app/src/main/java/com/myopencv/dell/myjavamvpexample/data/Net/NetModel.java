package com.myopencv.dell.myjavamvpexample.data.Net;

import com.google.gson.annotations.SerializedName;

public class NetModel {
    @SerializedName("id")
    private String mId;
    @SerializedName("login")
    private String Name;
    @SerializedName("avatar_ur")
    private String Image;

    public String getName() {
        return Name;
    }

    public String getId() {
        return mId;
    }

    public String getImage() {
        return Image;
    }

}
