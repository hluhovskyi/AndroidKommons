package com.dewarder.katanatest

import android.app.Dialog
import android.app.Fragment
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.FrameLayout
import com.dewarder.katana.ContextProvider
import android.support.v4.app.Fragment as SupportFragment

open class TestActivity : AppCompatActivity() {

    private lateinit var view: View
    private lateinit var fragment: Fragment
    private lateinit var supportFragment: SupportFragment
    private lateinit var dialog: Dialog
    private lateinit var contextProvider: ContextProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val container = FrameLayout(this).apply {
            id = R.id.action_container
        }
        setContentView(container)

        initView()?.let {
            view = it
            container.addView(view)
        }

        initFragment()?.let {
            fragment = it
            fragmentManager.beginTransaction()
                .replace(R.id.action_container, fragment)
                .commit()
        }

        initSupportFragment()?.let {
            supportFragment = it
            supportFragmentManager.beginTransaction()
                .replace(R.id.action_container, supportFragment)
                .commit()
        }

        initDialog()?.let {
            dialog = it
            dialog.show()
        }

        initContextProvider()?.let {
            contextProvider = it
        }
    }

    protected open fun initView(): View? = null

    protected open fun initFragment(): Fragment? = null

    protected open fun initSupportFragment(): SupportFragment? = null

    protected open fun initDialog(): Dialog? = null

    protected open fun initContextProvider(): ContextProvider? = null

    fun <T> getView(): T {
        return view as T
    }

    fun <T> getFragment(): T {
        return fragment as T
    }

    fun <T> getSupportFragment(): T {
        return supportFragment as T
    }

    fun <T> getDialog(): T {
        return dialog as T
    }

    fun <T> getContextProvider(): T {
        return contextProvider as T
    }
}