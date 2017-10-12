package com.doordash.mvpexample.ui.login;

import android.support.annotation.NonNull;

import com.doordash.mvpexample.ui.BaseContract;

public class LoginContract {

    interface View extends BaseContract.BaseView{
        void goToMainActivity();

        void showError(@NonNull String error);

        @NonNull
        String getEmailInput();

        @NonNull
        String getPasswordInput();
    }

    public interface Presenter extends BaseContract.BasePresenter<View> {
        /**
         * Late initializer for {@link View} interface
         */
        void setView(View view);

        void onPause();

        void onClickLoginButton();
    }
}
