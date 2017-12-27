package com.dewarder.katanatest.integer

import android.support.test.rule.ActivityTestRule
import android.view.View
import com.dewarder.katanatest.TestActivity
import org.junit.Rule

class ViewIntegerTest : BaseIntegerTest() {

    class Activity : TestActivity() {
        override fun initView() = TestIntegerView(this)
    }

    @get:Rule
    val activityRule = ActivityTestRule<Activity>(Activity::class.java)

    override fun getTestableInteger(): TestableInteger
        = activityRule.activity.getView()
}