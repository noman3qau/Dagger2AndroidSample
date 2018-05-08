package com.noman.dagger2sample.model;

import com.google.gson.annotations.SerializedName;

public class Hero {

    @SerializedName("name")
    String name;
    @SerializedName("realname")
    String realname;
    @SerializedName("team")
    String team;
    @SerializedName("firstappearance")
    String firstappearance;
    @SerializedName("createdby")
    String createdby;
    @SerializedName("publisher")
    String publisher;
    @SerializedName("imageurl")
    String imageurl;
    @SerializedName("bio")
    String bio;


    public Hero(String name, String realname, String team, String firstappearance, String createdby, String publisher, String imageurl, String bio) {
        this.name = name;
        this.realname = realname;
        this.team = team;
        this.firstappearance = firstappearance;
        this.createdby = createdby;
        this.publisher = publisher;
        this.imageurl = imageurl;
        this.bio = bio;
    }


    public String getName() {
        return name;
    }

    public String getRealname() {
        return realname;
    }

    public String getTeam() {
        return team;
    }

    public String getFirstappearance() {
        return firstappearance;
    }

    public String getCreatedby() {
        return createdby;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getImageurl() {
        return imageurl;
    }

    public String getBio() {
        return bio;
    }


}
