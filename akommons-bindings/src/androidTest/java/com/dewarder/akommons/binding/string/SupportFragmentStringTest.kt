package com.dewarder.akommons.binding.string

import android.support.test.rule.ActivityTestRule
import com.dewarder.akommons.binding.TestActivity
import org.junit.Rule

class SupportFragmentStringTest : BaseStringTest() {

    class Activity : TestActivity() {
        override fun initSupportFragment() = TestStringSupportFragment()
    }

    @get:Rule
    val activityRule = ActivityTestRule<Activity>(Activity::class.java)

    override fun getTestableString(): TestableString
        = activityRule.activity.getSupportFragment()
}