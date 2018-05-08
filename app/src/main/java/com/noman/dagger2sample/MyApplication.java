package com.noman.dagger2sample;

import android.app.Application;

import com.noman.dagger2sample.di.ApiComponent;
import com.noman.dagger2sample.di.ApiModule;
import com.noman.dagger2sample.di.AppModule;
import com.noman.dagger2sample.di.DaggerApiComponent;

public class MyApplication extends Application {

    private ApiComponent mApiComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApiComponent = DaggerApiComponent.builder()
                .appModule(new AppModule(this))
                .apiModule(new ApiModule("https://simplifiedcoding.net/demos/"))
                .build();

    }

    public ApiComponent getNetComponent() {
        return mApiComponent;
    }

}
