package com.sqisland.android.hello;

import junit.framework.TestCase;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Rule;
import org.junit.runners.JUnit4;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(JUnit4.class)
public class MainActivityTest extends TestCase {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule
            = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void bye()  {
       onView(withId(R.id.greeting))
               .check(matches(withText(R.string.hello_world)));

       openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());
       onView(withText(R.string.say_bye))
               .perform(click());
       onView(withId(R.id.greeting))
               .check(matches(withText(R.string.bye)));
    }
}