package com.doordash.mvpexample.data;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;

import com.doordash.mvpexample.api.AuthenticationApi;
import com.doordash.mvpexample.helpers.SharedPreferencesHelper;
import com.doordash.mvpexample.models.Token;

import javax.inject.Inject;

import io.reactivex.Single;

public class AuthenticationManager implements AuthenticationDataSource {
    @VisibleForTesting
    static final String AUTH_TOKEN_SHARED_PREFS_KEY = "auth-token";

    private SharedPreferencesHelper sharedPreferencesHelper;
    private AuthenticationApi authenticationApi;

    @Inject
    public AuthenticationManager(AuthenticationApi authenticationApi,
                                 SharedPreferencesHelper sharedPreferencesHelper) {
        this.sharedPreferencesHelper = sharedPreferencesHelper;
        this.authenticationApi = authenticationApi;
    }

    @Override
    public Single<Token> getAuthToken(@NonNull String email, @NonNull String password) {
        return Single.fromCallable(() -> {
            String sharedPreferencesString = sharedPreferencesHelper.getString(AUTH_TOKEN_SHARED_PREFS_KEY);
            if (sharedPreferencesString != null) {
                return Single.just(new Token(sharedPreferencesString));
            }
            return authenticationApi.getTokenForCredentials(email, password).map(token -> {
                sharedPreferencesHelper.save(AUTH_TOKEN_SHARED_PREFS_KEY, token.getToken());
                return token;
            });
        }).flatMap(tokenSingle -> tokenSingle);
    }
}