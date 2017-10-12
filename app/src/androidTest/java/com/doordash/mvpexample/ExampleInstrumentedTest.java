package com.doordash.mvpexample;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.doordash.mvpexample.ui.restaurantlist.RestaurantListActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public DaggerMockRule

    @Rule
    public ActivityTestRule<RestaurantListActivity> activityRule
            = new ActivityTestRule<>(RestaurantListActivity.class, false, false);

    @Before
    public void setup() {
        activityRule.launchActivity(new Intent());
    }

    @Test
    public void loginButtonPresenterBind() throws Exception {

        onView(withId(R.id.login_button)).perform(click());
    }

    @Test
    public void loginButtonPresenterBind2() throws Exception {
        onView(withId(R.id.login_button)).perform(click());
    }
}
