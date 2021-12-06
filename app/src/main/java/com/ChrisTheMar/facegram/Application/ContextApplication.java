package com.ChrisTheMar.facegram.Application;

import android.app.Application;
import android.content.Context;

import androidx.appcompat.app.AppCompatDelegate;

public class ContextApplication extends Application {

    private static ContextApplication instance;
    private static Context appContext;

    public static ContextApplication getInstance(){return instance;}

    public static Context getAppContext(){return appContext;}

    public void setAppContext(Context mAppContext){this.appContext=mAppContext;}

    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
        this.setAppContext(getApplicationContext());
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }
}
