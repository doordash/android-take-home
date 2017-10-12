package com.doordash.mvpexample.application;

import com.doordash.mvpexample.ui.login.LoginActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    void inject(MvpApplication app);

    void inject(LoginActivity loginActivity);

}
