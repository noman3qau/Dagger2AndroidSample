package com.noman.dagger2sample.di;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

// Module for shared prefernces provider
@Module
public class SharedPrefModule {

    private Context context;

    public SharedPrefModule(Context context) {
        this.context = context;
    }


    @Provides
    @Singleton
    public SharedPreferences provideSharedPref() {
        return context.getSharedPreferences("MY_SHARED_PREF", Context.MODE_PRIVATE);
    }


}
