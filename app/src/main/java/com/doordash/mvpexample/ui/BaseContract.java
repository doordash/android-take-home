package com.doordash.mvpexample.ui;

import android.support.annotation.NonNull;
import android.view.View;

public class BaseContract {
    public interface BaseView {

    }

    public interface BasePresenter<T> {
        void onCreate();
        void onResume();
        void onPause();
        void setView(@NonNull T view);
    }
}
