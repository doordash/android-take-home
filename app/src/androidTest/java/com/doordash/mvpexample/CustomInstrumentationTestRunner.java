package com.doordash.mvpexample;

import android.app.Application;
import android.app.Instrumentation;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.test.runner.AndroidJUnitRunner;

import com.doordash.mvpexample.application.EspressoApplication;

public class CustomInstrumentationTestRunner extends AndroidJUnitRunner {
    @Override
    @NonNull
    public Application newApplication(@NonNull ClassLoader cl,
                                      @NonNull String className,
                                      @NonNull Context context)
            throws InstantiationException,
            IllegalAccessException,
            ClassNotFoundException {
        return Instrumentation.newApplication(EspressoApplication.class, context);
    }
}