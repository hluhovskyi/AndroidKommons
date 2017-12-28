package com.dewarder.akommons.binding.integer

import android.support.test.rule.ActivityTestRule
import android.support.v4.app.Fragment
import com.dewarder.akommons.binding.TestActivity
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