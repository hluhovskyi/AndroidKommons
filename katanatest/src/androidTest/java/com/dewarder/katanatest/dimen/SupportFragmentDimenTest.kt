package com.dewarder.katanatest.dimen

import android.content.res.Resources
import android.support.test.rule.ActivityTestRule
import com.dewarder.katanatest.TestActivity
import org.junit.Rule

class SupportFragmentDimenTest : BaseDimenTest() {

    class Activity : TestActivity() {
        override fun initSupportFragment() = TestDimenSupportFragment()
    }

    @get:Rule
    val activityRule = ActivityTestRule<Activity>(Activity::class.java)

    override fun getTestableDimen(): TestableDimen = activityRule.activity.getSupportFragment()

    override fun getResources(): Resources = activityRule.activity.resources
}