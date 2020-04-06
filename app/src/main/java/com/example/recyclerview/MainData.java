package com.example.recyclerview;

public class MainData {

    private int imgProfile;
    private String tvName;

    public MainData(int imgProfile, String tvName) {
        this.imgProfile=imgProfile;
        this.tvName=tvName;
    }

    public int getImgProfile() {
        return imgProfile;
    }

    public void setImgProfile(int imgProfile) {
        this.imgProfile = imgProfile;
    }

    public String getTvName() {
        return tvName;
    }

    public void setTvName(String tvName) {
        this.tvName = tvName;
    }
}
