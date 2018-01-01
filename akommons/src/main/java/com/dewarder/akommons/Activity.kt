/*
 * Copyright (C) 2017 Artem Hluhovskyi
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

@file:JvmName("ActivityUtils")

package com.dewarder.akommons

import android.app.Activity
import android.content.Intent
import android.support.annotation.IdRes
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.EditText

/**
 * Properties
 */
val Activity.rootView: View
    get() = findViewById(android.R.id.content)

inline fun <V : View> Activity.findView(
    @IdRes id: Int,
    init: V.() -> Unit
): V = findViewById<V>(id).apply(init)

inline fun <reified T : Activity> Activity.startActivityForResult(
    requestCode: Int,
    action: String? = null,
    flags: Int = -1
) = startActivityForResult(intentFor<T>(action, flags), requestCode)

inline fun <reified T : Activity> Activity.startActivityForResult(
    requestCode: Int,
    action: String? = null,
    flags: Int = -1,
    init: Intent.() -> Unit
) = startActivityForResult(intentFor<T>(action, flags, init), requestCode)

/**
 * Keyboard
 */
fun Activity.showSoftInput(editText: EditText) {
    inputMethodManager.showSoftInput(editText, InputMethodManager.SHOW_FORCED)
}

fun Activity.hideSoftInput() {
    inputMethodManager.hideSoftInputFromWindow((currentFocus ?: rootView).windowToken, 0)
}

fun Activity.toggleSoftInput() {
    inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
}

fun Activity.setSoftInputMode(
    adjustment: SoftInputAdjustment = SoftInputAdjustment.SOFT_INPUT_ADJUST_UNSPECIFIED,
    visibility: SoftInputVisibility = SoftInputVisibility.SOFT_INPUT_STATE_UNSPECIFIED
) {
    window.setSoftInputMode(visibility.flag or adjustment.flag)
}

fun Activity.setSoftInputMode(
    adjustmentFlag: Int = WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING,
    visibilityFlag: Int = WindowManager.LayoutParams.SOFT_INPUT_STATE_UNSPECIFIED
) {
    window.setSoftInputMode(adjustmentFlag or visibilityFlag)
}