package com.doordash.mvpexample.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.doordash.mvpexample.R;

public class MainActivity extends AppCompatActivity {

    public static Intent makeIntent(Activity activity) {
        return new Intent(activity, MainActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
