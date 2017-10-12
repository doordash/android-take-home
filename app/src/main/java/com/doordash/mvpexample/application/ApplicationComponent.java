package com.doordash.mvpexample.application;

import com.doordash.mvpexample.ui.restaurantlist.RestaurantListActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    void inject(MvpApplication app);

    void inject(RestaurantListActivity restaurantListActivity);

}
