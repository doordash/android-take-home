package com.doordash.mvpexample.ui.restaurantlist;

import com.doordash.mvpexample.data.RestaurantDataSource;
import com.doordash.mvpexample.helpers.rx.ImmediateRxSchedulerProvider;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class RestaurantListPresenterTest {
    private static final String EMAIL = "user@website.com";
    private static final String PASSWORD = "password";
    private static final String TOKEN = "token";
    @Mock
    RestaurantDataSource restaurantDataSource;
    @Mock
    RestaurantListContract.View loginView;
    private RestaurantListPresenter presenter;

    @Before
    public void setUp() throws Exception {
        // instantiate presenter with mock dependencies
        // pass in ImmediateRxSchedulerProvider to make rx calls blocking
        MockitoAnnotations.initMocks(this);
        presenter = new RestaurantListPresenter(new ImmediateRxSchedulerProvider(), restaurantDataSource);
        presenter.setView(loginView);
    }

}
