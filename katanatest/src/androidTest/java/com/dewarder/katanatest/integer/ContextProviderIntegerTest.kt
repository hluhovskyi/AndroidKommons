package com.dewarder.katanatest.integer

import android.support.test.rule.ActivityTestRule
import com.dewarder.katanatest.TestActivity
import org.junit.Rule

class ContextProviderIntegerTest : BaseIntegerTest() {

    class Activity : TestActivity() {
        override fun initContextProvider() = TestIntegerContextProvider(this)
    }

    @get:Rule
    val activityRule = ActivityTestRule<Activity>(Activity::class.java)

    override fun getTestableInteger(): TestableInteger
        = activityRule.activity.getContextProvider()
}