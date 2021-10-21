package com.example.id.module;

import android.app.Activity;


import com.example.id.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;



@Module
public class ActivityModule {

    private Activity activity;
    public ActivityModule(Activity _activity){
        activity=_activity;
    }

    @ActivityScope
    @Provides
    public Activity provideActivity(){
        return activity;
    }
}
