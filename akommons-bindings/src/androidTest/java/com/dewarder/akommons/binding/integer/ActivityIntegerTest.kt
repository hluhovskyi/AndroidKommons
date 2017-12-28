package com.dewarder.akommons.binding.integer

import android.support.test.rule.ActivityTestRule
import com.dewarder.akommons.binding.common.integer.BaseIntegerTest
import org.junit.Rule

class ActivityIntegerTest : BaseIntegerTest() {

    @get:Rule
    val activityRule = ActivityTestRule<TestIntegerActivity>(TestIntegerActivity::class.java)

    override fun getTestableInteger() = activityRule.activity
}