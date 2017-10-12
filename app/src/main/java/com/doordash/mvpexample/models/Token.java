package com.doordash.mvpexample.models;

import android.support.annotation.NonNull;

public class Token {

    private String token;

    public Token(@NonNull String token) {

        this.token = token;
    }

    public String getToken() {
        return token;
    }


}
