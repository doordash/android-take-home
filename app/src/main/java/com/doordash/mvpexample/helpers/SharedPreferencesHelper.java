package com.doordash.mvpexample.helpers;


import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import javax.inject.Inject;

public class SharedPreferencesHelper {

    private final SharedPreferences sharedPrefs;

    @Inject
    public SharedPreferencesHelper(SharedPreferences sharedPrefs) {
        this.sharedPrefs = sharedPrefs;
    }

    public void save(@NonNull String key, @NonNull String value) {
        sharedPrefs.edit().putString(key, value).apply();
    }

    public void clear(@NonNull String key) {
        sharedPrefs.edit().remove(key).apply();
    }

    @Nullable
    public String getString(@NonNull String key) {
        return sharedPrefs.getString(key, null);
    }

}
