package com.dewarder.akommons.app

import android.app.Activity
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import com.dewarder.akommons.content.inputMethodManager

/**
 * Shortcut for [InputMethodManager.showSoftInput]
 */
public fun Activity.showSoftInput(editText: EditText) {
    inputMethodManager.showSoftInput(editText, InputMethodManager.SHOW_FORCED)
}

/**
 * Shortcut for [InputMethodManager.hideSoftInputFromWindow]
 */
public fun Activity.hideSoftInput() {
    inputMethodManager.hideSoftInputFromWindow((currentFocus ?: rootView).windowToken, 0)
}

/**
 * Shortcut for [InputMethodManager.toggleSoftInput]
 */
public fun Activity.toggleSoftInput(
    showFlags: Int = InputMethodManager.SHOW_FORCED,
    hideFlags: Int = 0
) {
    inputMethodManager.toggleSoftInput(showFlags, hideFlags)
}

/**
 * Shortcut for [android.view.Window.setSoftInputMode] which uses
 * enums instead of raw int flags
 */
public fun Activity.setSoftInputMode(
    adjustment: SoftInputAdjustment = SoftInputAdjustment.SOFT_INPUT_ADJUST_UNSPECIFIED,
    visibility: SoftInputVisibility = SoftInputVisibility.SOFT_INPUT_STATE_UNSPECIFIED
) {
    setSoftInputMode(adjustment.flag, visibility.flag)
}

/**
 * Shortcut for [android.view.Window.setSoftInputMode] which uses
 * [WindowManager.LayoutParams] flags to specify adjustment and visibility
 */
public fun Activity.setSoftInputMode(
    adjustmentFlag: Int = WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING,
    visibilityFlag: Int = WindowManager.LayoutParams.SOFT_INPUT_STATE_UNSPECIFIED
) {
    window.setSoftInputMode(adjustmentFlag or visibilityFlag)
}

enum class SoftInputAdjustment(val flag: Int) {
    SOFT_INPUT_ADJUST_UNSPECIFIED(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_UNSPECIFIED),
    SOFT_INPUT_ADJUST_RESIZE(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE),
    SOFT_INPUT_ADJUST_PAN(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
}

enum class SoftInputVisibility(val flag: Int) {
    SOFT_INPUT_STATE_UNSPECIFIED(WindowManager.LayoutParams.SOFT_INPUT_STATE_UNSPECIFIED),
    SOFT_INPUT_STATE_UNCHANGED(WindowManager.LayoutParams.SOFT_INPUT_STATE_UNCHANGED),
    SOFT_INPUT_STATE_HIDDEN(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN),
    SOFT_INPUT_STATE_VISIBLE(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE),
    SOFT_INPUT_STATE_ALWAYS_VISIBLE(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE)
}