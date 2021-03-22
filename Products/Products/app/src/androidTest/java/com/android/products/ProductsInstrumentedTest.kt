package com.android.products

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.android.products.activity.ProductsActivity
import com.android.products.adapter.HomeAdapter
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ProductsInstrumentedTest {

    @get:Rule
    var activityRule: ActivityScenarioRule<ProductsActivity>
            = ActivityScenarioRule(ProductsActivity::class.java)

    @Test
    fun recyclerViewTest() {
        //Espresso.onView(withId(R.id.recyclerView_home)).perform(RecyclerViewActions.actionOnItemAtPosition(6, ViewActions.click()))
    }

    @Test
    fun viewHolderTest() {
        Espresso.onView(withId(R.id.recyclerView_home)).check(ViewAssertions.matches(hasItem(ViewMatchers.hasDescendant(ViewMatchers.withText("homeViewHolder")))))
    }

    fun hasItem(matcher: Matcher<View?>): Matcher<View?>? {
        return object : BoundedMatcher<View?, RecyclerView>(RecyclerView::class.java) {
            override fun describeTo(description: Description) {
                description.appendText("has item: ")
                matcher.describeTo(description)
            }

            override fun matchesSafely(view: RecyclerView): Boolean {
                val adapter: HomeAdapter? = view.adapter as HomeAdapter?
                for (position in 0 until adapter!!.getItemCount()) {
                    val type: Int = adapter!!.getItemViewType(position)
                    val homeViewHolder: HomeAdapter.HomeViewHolder = adapter.createViewHolder(view, type)
                    adapter.onBindViewHolder(homeViewHolder, position)
                    if (matcher.matches(homeViewHolder.itemView)) {
                        return true
                    }
                }
                return false
            }
        }
    }
}