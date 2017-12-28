package com.dewarder.akommons.binding.string

import android.support.test.rule.ActivityTestRule
import com.dewarder.akommons.binding.common.string.BaseStringTest
import org.junit.Rule

class ActivityStringTest : BaseStringTest() {

    @get:Rule
    val activityRule = ActivityTestRule<TestStringActivity>(TestStringActivity::class.java)

    override fun getTestableString() = activityRule.activity
}