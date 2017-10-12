package com.doordash.mvpexample.data;

import com.doordash.mvpexample.api.AuthenticationApi;
import com.doordash.mvpexample.helpers.SharedPreferencesHelper;
import com.doordash.mvpexample.models.Token;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import io.reactivex.Single;

import static com.doordash.mvpexample.data.AuthenticationManager.AUTH_TOKEN_SHARED_PREFS_KEY;
import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class AuthenticationManagerTest {
    private static final String EMAIL = "user@website.com";
    private static final String PASSWORD = "password";
    private static final String API_TOKEN = "api-token";
    private static final String CACHED_TOKEN = "cached-token";

    @Mock
    AuthenticationApi authenticationApi;
    @Mock
    SharedPreferencesHelper sharedPreferencesHelper;
    private AuthenticationManager authenticationManager;

    @Before
    public void setUp() throws Exception {
        // instantiate manager with mock dependencies
        MockitoAnnotations.initMocks(this);
        authenticationManager = new AuthenticationManager(authenticationApi, sharedPreferencesHelper);
    }

    @Test
    public void getAuthToken_whenNotCached_callApiAndCache() throws Exception {
        when(sharedPreferencesHelper.getString(AUTH_TOKEN_SHARED_PREFS_KEY))
                .thenReturn(null); // cache is empty
        when(authenticationApi.getTokenForCredentials(EMAIL, PASSWORD))
                .thenReturn(Single.just(new Token(API_TOKEN))); // api will succeed
        Token token = authenticationManager.getAuthToken(EMAIL, PASSWORD).blockingGet();
        assertEquals(API_TOKEN, token.getToken());
        verify(sharedPreferencesHelper).save(AUTH_TOKEN_SHARED_PREFS_KEY, API_TOKEN);
    }

    @Test
    public void getAuthToken_whenCached_getCachedValue() throws Exception {
        when(sharedPreferencesHelper.getString(AUTH_TOKEN_SHARED_PREFS_KEY))
                .thenReturn(CACHED_TOKEN); // cache is filled
        Token token = authenticationManager.getAuthToken(EMAIL, PASSWORD).blockingGet();
        assertEquals(CACHED_TOKEN, token.getToken());
    }


}