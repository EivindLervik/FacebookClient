package no.hvl.dat153.facebookclient;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by ole-martin on 09.02.2017.
 */

public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void testNavigateGraphApi(){
        onView(withId(R.id.graphAPI)).perform(click());
        onView(withId(R.id.showLikesButton)).check(matches(isDisplayed()));
        onView(withId(R.id.showInformationButton)).check(matches(isDisplayed()));
    }



}
