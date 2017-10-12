package com.doordash.mvpexample.ui.restaurantlist;

import android.support.annotation.NonNull;

import com.doordash.mvpexample.models.Restaurant;
import com.doordash.mvpexample.ui.BaseContract;

import java.util.List;

public class RestaurantListContract {

    interface View extends BaseContract.BaseView {

        void showRestaurantList(@NonNull List<Restaurant> restaurantList);

        void showError(@NonNull String error);
    }

    public interface Presenter extends BaseContract.BasePresenter<View> {
        /**
         * Late initializer for {@link View} interface
         */
        void setView(@NonNull View view);

        void onPause();
    }

}
