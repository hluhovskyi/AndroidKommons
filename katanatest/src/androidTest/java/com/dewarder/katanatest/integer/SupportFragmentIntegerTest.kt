package com.dewarder.katanatest.integer

import android.support.test.rule.ActivityTestRule
import android.support.v4.app.Fragment
import com.dewarder.katanatest.TestActivity
import org.junit.Rule

class SupportFragmentIntegerTest : BaseIntegerTest() {

    class Activity : TestActivity() {
        override fun initSupportFragment() = TestIntegerSupportFragment()
    }

    @get:Rule
    val activityRule = ActivityTestRule<Activity>(Activity::class.java)

    override fun getTestableInteger(): TestableInteger
        = activityRule.activity.getSupportFragment()
}