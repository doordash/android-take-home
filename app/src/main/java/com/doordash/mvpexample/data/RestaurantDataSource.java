package com.doordash.mvpexample.data;

import com.doordash.mvpexample.models.Restaurant;
import io.reactivex.Single;

import java.util.List;

/**
 * Created by rohan on 10/12/17.
 */

public interface RestaurantDataSource {

    Single<List<Restaurant>> getRestaurants();
}
