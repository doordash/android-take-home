package com.doordash.mvpexample.ui.restaurantlist;


import com.doordash.mvpexample.data.AuthenticationDataSource;
import com.doordash.mvpexample.helpers.rx.RxSchedulerProvider;
import com.doordash.mvpexample.ui.BaseRxPresenter;

public class RestaurantListPresenter
        extends BaseRxPresenter<RestaurantListContract.View>
        implements RestaurantListContract.Presenter {

    private AuthenticationDataSource authenticationDataSource;

    public RestaurantListPresenter(RxSchedulerProvider rxSchedulerProvider,
                                   AuthenticationDataSource authenticationDataSource) {
        super(rxSchedulerProvider);
        this.authenticationDataSource = authenticationDataSource;
    }
}
