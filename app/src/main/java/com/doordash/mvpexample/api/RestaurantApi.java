package com.doordash.mvpexample.api;

import com.doordash.mvpexample.models.Restaurant;
import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.http.GET;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by rohan on 10/12/17.
 */

public class RestaurantApi {

    public RestaurantService service;

    @Inject
    public RestaurantApi(Retrofit retrofit) {
        service = retrofit.create(RestaurantService.class);
    }

    public Single<List<Restaurant>> getRestaurants() {
        return service.getRestaurants();
    }

    private interface RestaurantService {
        // Starting points api
        @GET("/v2/restaurant/?lat=37.422740&lng=-122.139956")
        Single<List<Restaurant>> getRestaurants();
    }
}
