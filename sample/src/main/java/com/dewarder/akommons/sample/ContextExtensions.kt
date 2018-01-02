package com.dewarder.akommons.sample

import android.app.Activity
import android.content.Context
import com.dewarder.akommons.content.intentFor
import com.dewarder.akommons.content.showLongToast
import com.dewarder.akommons.content.showShortToast

class ContextHolder(
    private val context: Context
) {

    fun example() {

        //Toasts
        context.showShortToast("Short toast")
        context.showLongToast("Long toast")

        //Intents
        val intent1 = context.intentFor<Activity>()
        val intent2 = context.intentFor<Activity>()
    }
}