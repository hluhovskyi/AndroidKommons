package com.dewarder.katanatest.string

import android.support.test.rule.ActivityTestRule
import com.dewarder.katanatest.TestActivity
import org.junit.Rule

class FragmentStringTest : BaseStringTest() {

    class Activity : TestActivity() {
        override fun initFragment() = TestStringFragment()
    }

    @get:Rule
    val activityRule = ActivityTestRule<Activity>(Activity::class.java)

    override fun getTestableString(): TestableString
        = activityRule.activity.getFragment()
}