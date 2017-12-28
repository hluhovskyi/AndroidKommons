package com.dewarder.akommons.binding.support

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.FrameLayout
import com.dewarder.akommons.binding.common.R
import android.support.v4.app.Fragment as SupportFragment

open class TestActivity : AppCompatActivity() {

    private lateinit var supportFragment: SupportFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val container = FrameLayout(this).apply {
            id = R.id.action_container
        }
        setContentView(container)

        initSupportFragment()?.let {
            supportFragment = it
            supportFragmentManager.beginTransaction()
                    .replace(R.id.action_container, supportFragment)
                    .commit()
        }
    }

    protected open fun initSupportFragment(): SupportFragment? = null

    fun <T> getSupportFragment(): T {
        return supportFragment as T
    }
}