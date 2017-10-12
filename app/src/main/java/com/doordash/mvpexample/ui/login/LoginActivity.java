package com.doordash.mvpexample.ui.login;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.widget.Toast;

import com.doordash.mvpexample.R;
import com.doordash.mvpexample.application.MvpApplication;
import com.doordash.mvpexample.ui.MainActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    @Inject
    LoginContract.Presenter presenter;
    @BindView(R.id.login_email)
    AppCompatEditText emailEditText;
    @BindView(R.id.login_password)
    AppCompatEditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        MvpApplication.getAppComponent().inject(this);
        ButterKnife.bind(this);
        presenter.setView(this);
    }

    @Override
    protected void onPause() {
        presenter.onPause();
        super.onPause();
    }

    @NonNull
    @Override
    public String getEmailInput() {
        return emailEditText.getText().toString();
    }

    @NonNull
    @Override
    public String getPasswordInput() {
        return passwordEditText.getText().toString();
    }

    @Override
    public void goToMainActivity() {
        startActivity(MainActivity.makeIntent(this));
    }

    @Override
    public void showError(@NonNull String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.login_button)
    public void onClickLoginButton() {
        presenter.onClickLoginButton();
    }
}
