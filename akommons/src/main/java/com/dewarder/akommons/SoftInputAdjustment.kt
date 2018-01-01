package com.dewarder.akommons

import android.view.WindowManager

enum class SoftInputAdjustment(val flag: Int) {
    SOFT_INPUT_ADJUST_UNSPECIFIED(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_UNSPECIFIED),
    SOFT_INPUT_ADJUST_RESIZE(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE),
    SOFT_INPUT_ADJUST_PAN(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
}