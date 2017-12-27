package com.dewarder.katanatest.string

import android.support.test.rule.ActivityTestRule
import com.dewarder.katanatest.integer.BaseIntegerTest
import com.dewarder.katanatest.integer.TestIntegerActivity
import org.junit.Rule

class ActivityStringTest : BaseStringTest() {

    @get:Rule
    val activityRule = ActivityTestRule<TestStringActivity>(TestStringActivity::class.java)

    override fun getTestableString() = activityRule.activity
}