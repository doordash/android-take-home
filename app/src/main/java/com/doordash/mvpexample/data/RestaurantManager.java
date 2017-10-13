package com.doordash.mvpexample.data;

import android.support.annotation.VisibleForTesting;
import com.doordash.mvpexample.api.RestaurantApi;
import com.doordash.mvpexample.models.Restaurant;
import com.doordash.mvpexample.models.Token;
import io.reactivex.Single;

import javax.inject.Inject;
import java.util.List;

public class RestaurantManager implements RestaurantDataSource {
    @VisibleForTesting
    static final String AUTH_TOKEN_SHARED_PREFS_KEY = "auth-token";

    private RestaurantApi restaurantApi;

    @Inject
    public RestaurantManager(RestaurantApi restaurantApi) {
        this.restaurantApi = restaurantApi;
    }

    @Override
    public Single<List<Restaurant>> getRestaurants() {
        return restaurantApi.getRestaurants();
    }
}