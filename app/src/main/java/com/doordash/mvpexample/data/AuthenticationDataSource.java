package com.doordash.mvpexample.data;

import android.support.annotation.NonNull;

import com.doordash.mvpexample.models.Token;

import io.reactivex.Single;

public interface AuthenticationDataSource {
    Single<Token> getAuthToken(@NonNull String email, @NonNull String password);
}
