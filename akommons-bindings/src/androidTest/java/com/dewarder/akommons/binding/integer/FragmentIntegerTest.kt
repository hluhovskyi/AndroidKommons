package com.dewarder.akommons.binding.integer

import android.support.test.rule.ActivityTestRule
import com.dewarder.akommons.binding.TestActivity
import com.dewarder.akommons.binding.common.integer.BaseIntegerTest
import com.dewarder.akommons.binding.common.integer.TestableInteger
import org.junit.Rule

class FragmentIntegerTest : BaseIntegerTest() {

    class Activity : TestActivity() {
        override fun initFragment() = TestIntegerFragment()
    }

    @get:Rule
    val activityRule = ActivityTestRule<Activity>(Activity::class.java)

    override fun getTestableInteger(): TestableInteger
        = activityRule.activity.getFragment()
}