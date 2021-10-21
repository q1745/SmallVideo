package com.example.id.module;

import android.content.Context;


import com.example.id.BaseApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;



@Module
public class AppModule {
    private BaseApplication application;
    public AppModule(BaseApplication _application){
        application=_application;
    }

    @Singleton
    @Provides
    public Context provideContext(){
        return application;
    }

}
