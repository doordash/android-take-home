package com.doordash.mvpexample.api;

import android.support.annotation.NonNull;

import com.doordash.mvpexample.models.Token;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * This is a fake api implementation, normally we would hook up to a backend here using
 * Retrofit or a similar library for api calls
 */
public class AuthenticationApi {

    @Inject
    public AuthenticationApi() {

    }

    public Single<Token> getTokenForCredentials(@NonNull String email, @NonNull String password) {
        return Single.just(new Token("fake-token"));
    }
}
