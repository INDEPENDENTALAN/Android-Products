package com.android.products

import androidx.fragment.app.FragmentActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FragmentInstrumentedTest {

    @get:Rule
    var activityRule: ActivityScenarioRule<FragmentActivity>
            = ActivityScenarioRule(FragmentActivity::class.java)

    @Test
    fun product() {
        Espresso.onView(ViewMatchers.withId(R.id.editText_name)).check(ViewAssertions.matches(ViewMatchers.withText("Jeans")))
        Espresso.onView(ViewMatchers.withId(R.id.editText_price)).check(ViewAssertions.matches(ViewMatchers.withText("26$")))
        Espresso.onView(ViewMatchers.withId(R.id.editText_details)).check(ViewAssertions.matches(ViewMatchers.withText("Clothes, Men")))
        Espresso.onView(ViewMatchers.withId(R.id.button_done)).perform(ViewActions.click()).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun signIn() {
        Espresso.onView(ViewMatchers.withId(R.id.editText_sign_in_name)).check(ViewAssertions.matches(ViewMatchers.withText("ALAN")))
        Espresso.onView(ViewMatchers.withId(R.id.editText_sign_in_password)).check(ViewAssertions.matches(ViewMatchers.withText("alan--")))
        Espresso.onView(ViewMatchers.withId(R.id.button_sign_in)).perform(ViewActions.click()).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun signUp() {
        Espresso.onView(ViewMatchers.withId(R.id.editText_sign_up_name)).check(ViewAssertions.matches(ViewMatchers.withText("ALAN")))
        Espresso.onView(ViewMatchers.withId(R.id.editText_sign_up_password)).check(ViewAssertions.matches(ViewMatchers.withText("alan--")))
        Espresso.onView(ViewMatchers.withId(R.id.editText_sign_up_confirm)).check(ViewAssertions.matches(ViewMatchers.withText("alan--")))
        Espresso.onView(ViewMatchers.withId(R.id.button_sign_up)).perform(ViewActions.click()).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}