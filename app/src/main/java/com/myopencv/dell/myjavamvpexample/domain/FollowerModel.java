package com.myopencv.dell.myjavamvpexample.domain;

public class FollowerModel implements Entity {

    private String name;
    private String pictureOfHeader;

    public FollowerModel(String name, String pictureOfHeader){
        this.name = name;
        this.pictureOfHeader = pictureOfHeader;
    }

    public String getName() {
        return name;
    }

    public String getPictureOfHeader() {
        return pictureOfHeader;
    }

}
