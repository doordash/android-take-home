package com.doordash.mvpexample.application;

import android.content.SharedPreferences;

import com.doordash.mvpexample.api.AuthenticationApi;
import com.doordash.mvpexample.data.AuthenticationDataSource;
import com.doordash.mvpexample.data.AuthenticationManager;
import com.doordash.mvpexample.helpers.Constants;
import com.doordash.mvpexample.helpers.SharedPreferencesHelper;
import com.doordash.mvpexample.helpers.rx.RxSchedulerProvider;
import com.doordash.mvpexample.helpers.rx.ThreadedRxSchedulerProvider;
import com.doordash.mvpexample.ui.login.LoginContract;
import com.doordash.mvpexample.ui.login.LoginPresenter;

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
    AuthenticationDataSource providesAuthenticationDataSource(AuthenticationApi authenticationApi,
                                                              SharedPreferencesHelper sharedPreferencesHelper) {
        return new AuthenticationManager(authenticationApi, sharedPreferencesHelper);
    }

    @Provides
    RxSchedulerProvider providesRxSchedulerProvider() {
        return new ThreadedRxSchedulerProvider();
    }

    @Provides
    LoginContract.Presenter providesLoginPresenter(RxSchedulerProvider rxSchedulerProvider,
                                                   AuthenticationDataSource authenticationDataSource) {
        return new LoginPresenter(rxSchedulerProvider, authenticationDataSource);
    }

    @Provides
    SharedPreferences providesSharedPreferences() {
        return application.getSharedPreferences(Constants.SHARED_PREFS_NAME, 0);
    }

}
