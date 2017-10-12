package com.doordash.mvpexample.ui;


import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;

import com.doordash.mvpexample.helpers.rx.RxSchedulerProvider;

import io.reactivex.SingleTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class BaseRxPresenter<V> implements BaseContract.BasePresenter<V> {
    protected V view;
    private CompositeDisposable compositeDisposable;
    private RxSchedulerProvider rxSchedulerProvider;

    public BaseRxPresenter(RxSchedulerProvider rxSchedulerProvider) {
        this.rxSchedulerProvider = rxSchedulerProvider;
        compositeDisposable = new CompositeDisposable();
    }


    @Override
    public void onCreate() {

    }

    @Override
    public void onResume() {

    }

    @CallSuper
    @Override
    public void onPause() {
        compositeDisposable.clear();
    }

    @Override
    public void setView(@NonNull V view) {
        this.view = view;
    }

    protected void addDisposable(Disposable d) {
        compositeDisposable.add(d);
    }

    protected static <T> SingleTransformer<T, T> applySingleSchedulers() {
        return observable -> observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
