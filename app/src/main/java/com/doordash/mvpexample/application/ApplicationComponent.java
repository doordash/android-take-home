package com.doordash.mvpexample.application;

import com.doordash.mvpexample.ui.restaurantlist.RestaurantListActivity;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface ApplicationComponent {

    void inject(MvpApplication app);

    void inject(RestaurantListActivity restaurantListActivity);

}
