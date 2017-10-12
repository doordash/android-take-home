package com.doordash.mvpexample.helpers.rx;


import android.support.annotation.NonNull;

import io.reactivex.Scheduler;

public interface RxSchedulerProvider {
    @NonNull
    Scheduler computation();

    @NonNull
    Scheduler io();

    @NonNull
    Scheduler ui();
}
