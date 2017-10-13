package com.doordash.mvpexample.ui.restaurantlist;


import com.doordash.mvpexample.data.RestaurantDataSource;
import com.doordash.mvpexample.helpers.rx.RxSchedulerProvider;
import com.doordash.mvpexample.models.Restaurant;
import io.reactivex.SingleObserver;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

import java.util.List;

public class RestaurantListPresenter
        implements RestaurantListContract.Presenter {

    private RestaurantDataSource restaurantDataSource;
    private RxSchedulerProvider rxSchedulerProvider;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private RestaurantListContract.View view;

    public RestaurantListPresenter(RxSchedulerProvider rxSchedulerProvider,
                                   RestaurantDataSource restaurantDataSource) {
        this.restaurantDataSource = restaurantDataSource;
        this.rxSchedulerProvider = rxSchedulerProvider;
    }

    @Override
    public void onCreate() {
        restaurantDataSource
                .getRestaurants()
                .observeOn(rxSchedulerProvider.ui())
                .subscribeOn(rxSchedulerProvider.io())
                .subscribe(new SingleObserver<List<Restaurant>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onSuccess(@NonNull List<Restaurant> restaurants) {
                        view.showRestaurantList(restaurants);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        view.showError(e.getMessage());
                    }
                });
    }

    @Override
    public void onResume() {

    }

    @Override
    public void setView(@android.support.annotation.NonNull RestaurantListContract.View view) {
        this.view = view;
    }

    @Override
    public void onPause() {
        compositeDisposable.clear();
    }
}
