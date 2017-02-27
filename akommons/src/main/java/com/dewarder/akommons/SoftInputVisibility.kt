package com.dewarder.akommons

import android.view.WindowManager

enum class SoftInputVisibility(val flag: Int) {

    SOFT_INPUT_STATE_UNSPECIFIED(WindowManager.LayoutParams.SOFT_INPUT_STATE_UNSPECIFIED),
    SOFT_INPUT_STATE_UNCHANGED(WindowManager.LayoutParams.SOFT_INPUT_STATE_UNCHANGED),
    SOFT_INPUT_STATE_HIDDEN(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN),
    SOFT_INPUT_STATE_VISIBLE(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE),
    SOFT_INPUT_STATE_ALWAYS_VISIBLE(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE)
}