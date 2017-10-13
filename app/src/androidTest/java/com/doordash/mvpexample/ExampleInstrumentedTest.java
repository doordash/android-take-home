package com.doordash.mvpexample;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import com.doordash.mvpexample.ui.restaurantlist.RestaurantListActivity;
import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule<RestaurantListActivity> activityRule
            = new ActivityTestRule<>(RestaurantListActivity.class, false, false);

    @Before
    public void setup() {
        activityRule.launchActivity(new Intent());
    }
}
