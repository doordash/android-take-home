package com.doordash.mvpexample.ui.restaurantlist;

import com.doordash.mvpexample.data.AuthenticationDataSource;
import com.doordash.mvpexample.helpers.rx.ImmediateRxSchedulerProvider;
import com.doordash.mvpexample.models.Token;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import io.reactivex.Single;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RestaurantListPresenterTest {
    private static final String EMAIL = "user@website.com";
    private static final String PASSWORD = "password";
    private static final String TOKEN = "token";
    @Mock
    AuthenticationDataSource authenticationDataSource;
    @Mock
    RestaurantListContract.View loginView;
    private RestaurantListPresenter presenter;

    @Before
    public void setUp() throws Exception {
        // instantiate presenter with mock dependencies
        // pass in ImmediateRxSchedulerProvider to make rx calls blocking
        MockitoAnnotations.initMocks(this);
        presenter = new RestaurantListPresenter(new ImmediateRxSchedulerProvider(), authenticationDataSource);
        presenter.setView(loginView);
    }

}