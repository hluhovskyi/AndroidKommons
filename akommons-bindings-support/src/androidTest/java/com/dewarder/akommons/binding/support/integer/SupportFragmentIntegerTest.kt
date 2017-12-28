package com.dewarder.akommons.binding.support.integer

import android.support.test.rule.ActivityTestRule
import com.dewarder.akommons.binding.support.TestActivity
import com.dewarder.akommons.binding.common.integer.BaseIntegerTest
import com.dewarder.akommons.binding.common.integer.TestableInteger
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