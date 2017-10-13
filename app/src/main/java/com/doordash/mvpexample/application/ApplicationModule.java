package com.doordash.mvpexample.application;

import com.doordash.mvpexample.api.RestaurantApi;
import com.doordash.mvpexample.data.RestaurantDataSource;
import com.doordash.mvpexample.data.RestaurantManager;
import com.doordash.mvpexample.helpers.rx.RxSchedulerProvider;
import com.doordash.mvpexample.helpers.rx.ThreadedRxSchedulerProvider;
import com.doordash.mvpexample.ui.restaurantlist.RestaurantListContract;
import com.doordash.mvpexample.ui.restaurantlist.RestaurantListPresenter;
import dagger.Module;
import dagger.Provides;

/**
 * Application module.
 */
@Module
public class ApplicationModule {

    private final MvpApplication application;

    public ApplicationModule(MvpApplication application) {
        this.application = application;
    }

    @Provides
    MvpApplication providesMvpApplication() {
        return application;
    }

    @Provides
    RestaurantDataSource providesRestaurantDataSource(RestaurantApi restaurantApi) {
        return new RestaurantManager(restaurantApi);
    }

    @Provides
    RxSchedulerProvider providesRxSchedulerProvider() {
        return new ThreadedRxSchedulerProvider();
    }

    @Provides
    RestaurantListContract.Presenter providesLoginPresenter(RxSchedulerProvider rxSchedulerProvider,
                                                            RestaurantDataSource restaurantDataSource) {
        return new RestaurantListPresenter(rxSchedulerProvider, restaurantDataSource);
    }
}
