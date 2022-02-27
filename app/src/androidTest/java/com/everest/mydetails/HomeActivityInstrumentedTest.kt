package com.everest.mydetails

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class HomeActivityInstrumentedTest {

    @get:Rule
    val activityScenario = ActivityScenarioRule(HomeActivity::class.java)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.everest.mydetails", appContext.packageName)
    }

    @Test
    fun getTextFromPreviousActivity() {
        onView(withId(R.id.firstNameET)).perform(typeText("Pravallika"))
        onView(withId(R.id.ageET)).perform(typeText(21.toString()))
        onView(withId(R.id.bioET)).perform(typeText("Hello"))
        onView(withId(R.id.phoneNumberET)).perform(typeText(9176367899.toString()))
        onView(withId(R.id.submitButton)).perform(click());
        onView(withId(R.id.nameTV)).check(matches(withText("Name: Pravallika")))
        onView(withId(R.id.ageTV)).check(matches(withText("Age: 21")))
        onView(withId(R.id.bioTV)).check(matches(withText("Bio: Hello")))
        onView(withId(R.id.phoneNumberTV)).check(matches(withText("Phno: 9176367899")))
    }
}