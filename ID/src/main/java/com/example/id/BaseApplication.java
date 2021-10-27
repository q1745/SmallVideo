package com.example.id;

import android.app.Application;

import com.example.id.component.AppComponent;
import com.example.id.component.DaggerAppComponent;
import com.example.id.module.AppModule;



public class BaseApplication extends Application {

    public AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initAppInjection();
    }

    private void initAppInjection() {
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }
}
