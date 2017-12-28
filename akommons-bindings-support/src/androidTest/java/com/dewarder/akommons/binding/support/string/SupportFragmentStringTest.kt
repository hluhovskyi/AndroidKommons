package com.dewarder.akommons.binding.support.string

import android.support.test.rule.ActivityTestRule
import com.dewarder.akommons.binding.support.TestActivity
import com.dewarder.akommons.binding.common.string.BaseStringTest
import com.dewarder.akommons.binding.common.string.TestableString
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