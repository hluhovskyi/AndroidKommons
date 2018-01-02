package com.dewarder.akommons.sample

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.dewarder.akommons.app.rootView
import com.dewarder.akommons.app.startActivityForResult

/**
 * Example of usage Activity extensions
 */
class ActivityExtensions(
    private val activity: Activity
) {

    fun example() {
        //Add view on the front of all other views
        activity.rootView.addView(View(activity))

        //Usage in simple case when no need to pass additional data
        activity.startActivityForResult<AnotherActivity>(
            requestCode = REQUEST_CODE
        )

        //In case if you need to specify action
        activity.startActivityForResult<AnotherActivity>(
            requestCode = REQUEST_CODE,
            action = AnotherActivity.ACTION_DO_SOMETHING
        )

        //In case if you need both action and flags
        activity.startActivityForResult<AnotherActivity>(
            requestCode = REQUEST_CODE,
            action = AnotherActivity.ACTION_DO_SOMETHING,
            flags = Intent.FLAG_ACTIVITY_CLEAR_TASK and Intent.FLAG_ACTIVITY_CLEAR_TASK
        )

        //In the most complex case when you need pass some additional
        //data to intent e.g. bundle with arguments
        activity.startActivityForResult<AnotherActivity>(
            requestCode = REQUEST_CODE,
            action = AnotherActivity.ACTION_DO_SOMETHING,
            flags = Intent.FLAG_ACTIVITY_CLEAR_TASK and Intent.FLAG_ACTIVITY_CLEAR_TASK
        ) {
            putExtra(AnotherActivity.EXTRA_DATA_1, "value1")
            putExtra(AnotherActivity.EXTRA_DATA_2, "value2")
        }

        //The most common usage is passing requestCode and arguments only
        activity.startActivityForResult<AnotherActivity>(REQUEST_CODE) {
            putExtra(AnotherActivity.EXTRA_DATA_1, "value1")
            putExtra(AnotherActivity.EXTRA_DATA_2, "value2")
        }
    }


    companion object {
        const val REQUEST_CODE = 1
    }
}

@SuppressLint("Registered")
private class AnotherActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA_1 = "EXTRA_DATA_1"
        const val EXTRA_DATA_2 = "EXTRA_DATA_2"
        const val ACTION_DO_SOMETHING = "ACTION_DO_SOMETHING"
    }
}
