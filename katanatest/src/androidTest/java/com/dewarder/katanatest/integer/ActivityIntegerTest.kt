package com.dewarder.katanatest.integer

import android.support.test.rule.ActivityTestRule
import org.junit.Rule

class ActivityIntegerTest : BaseIntegerTest() {

    @get:Rule
    val activityRule = ActivityTestRule<TestIntegerActivity>(TestIntegerActivity::class.java)

    override fun getTestableInteger() = activityRule.activity
}