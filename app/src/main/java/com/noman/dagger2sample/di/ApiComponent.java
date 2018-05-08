package com.noman.dagger2sample.di;


import com.noman.dagger2sample.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

// Dagger2 component that provide modules with providers
@Singleton
@Component(modules = {AppModule.class, ApiModule.class, SharedPrefModule.class})
public interface ApiComponent {

    void inject(MainActivity activity);

}
