package com.noman.dagger2sample.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Data implements Parcelable {
    ArrayList<Hero> heroArrayList;

    public Data(ArrayList<Hero> heroArrayList) {
        this.heroArrayList = heroArrayList;
    }

    protected Data(Parcel in) {
    }

    public static final Creator<Data> CREATOR = new Creator<Data>() {
        @Override
        public Data createFromParcel(Parcel in) {
            return new Data(in);
        }

        @Override
        public Data[] newArray(int size) {
            return new Data[size];
        }
    };

    public ArrayList<Hero> getHeroArrayList() {
        return heroArrayList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
