package com.doordash.mvpexample.ui.login;


import com.doordash.mvpexample.data.AuthenticationDataSource;
import com.doordash.mvpexample.helpers.rx.RxSchedulerProvider;
import com.doordash.mvpexample.models.Token;
import com.doordash.mvpexample.ui.BaseRxPresenter;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class LoginPresenter extends BaseRxPresenter<LoginContract.View>
        implements LoginContract.Presenter {

    private AuthenticationDataSource authenticationDataSource;

    public LoginPresenter(RxSchedulerProvider rxSchedulerProvider,
                          AuthenticationDataSource authenticationDataSource) {
        super(rxSchedulerProvider);
        this.authenticationDataSource = authenticationDataSource;
    }

    @Override
    public void onClickLoginButton() {
        authenticationDataSource.getAuthToken(view.getEmailInput(), view.getPasswordInput())
                .subscribe(new SingleObserver<Token>() {
                    @Override
                    public void onSubscribe(@io.reactivex.annotations.NonNull Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onSuccess(@io.reactivex.annotations.NonNull Token token) {
                        view.goToMainActivity();
                    }

                    @Override
                    public void onError(@io.reactivex.annotations.NonNull Throwable e) {
                        view.showError(e.getLocalizedMessage());
                    }
                });
    }
}
