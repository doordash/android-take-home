package com.doordash.mvpexample.ui.login;

import com.doordash.mvpexample.data.AuthenticationDataSource;
import com.doordash.mvpexample.helpers.rx.ImmediateRxSchedulerProvider;
import com.doordash.mvpexample.models.Token;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import io.reactivex.Single;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LoginPresenterTest {
    private static final String EMAIL = "user@website.com";
    private static final String PASSWORD = "password";
    private static final String TOKEN = "token";
    @Mock
    AuthenticationDataSource authenticationDataSource;
    @Mock
    LoginContract.View loginView;
    LoginPresenter presenter;

    @Before
    public void setUp() throws Exception {
        // instantiate presenter with mock dependencies
        // pass in ImmediateRxSchedulerProvider to make rx calls blocking
        MockitoAnnotations.initMocks(this);
        presenter = new LoginPresenter(new ImmediateRxSchedulerProvider(), authenticationDataSource);
        presenter.setView(loginView);
        // mock view getters
        when(loginView.getEmailInput()).thenReturn(EMAIL);
        when(loginView.getPasswordInput()).thenReturn(PASSWORD);
    }

    @Test
    public void onClickLoginButton_whenLoginSucceeds_goToMainActivity() throws Exception {
        when(authenticationDataSource.getAuthToken(EMAIL, PASSWORD))
                .thenReturn(Single.just(new Token(TOKEN))); // fake successful login
        presenter.onClickLoginButton();
        verify(loginView).goToMainActivity();
    }

    @Test
    public void onClickLoginButton_whenLoginFails_showError() throws Exception {
        Exception error = new Exception("error message");
        when(authenticationDataSource.getAuthToken(EMAIL, PASSWORD))
                .thenReturn(Single.error(error)); // fake failed login
        presenter.onClickLoginButton();
        verify(loginView).showError(error.getLocalizedMessage());
    }

}