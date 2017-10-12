package com.doordash.mvpexample.application;

import android.app.Application;

public class MvpApplication extends Application {

    private static MvpApplication INSTANCE;

    private ApplicationComponent appComponent;

    public static ApplicationComponent getAppComponent() {
        return getInstance().appComponent;
    }

    public static MvpApplication getInstance() {
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        appComponent = buildAppComponenent();
    }

    protected ApplicationComponent buildAppComponenent() {
        return DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }


}
