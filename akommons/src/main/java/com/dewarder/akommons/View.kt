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

@file:JvmName("ViewUtils")

package com.dewarder.akommons

import android.support.annotation.IdRes
import android.view.View

/**
 * Variables
 */
var View.isVisible: Boolean
    get() = visibility == View.VISIBLE
    set(value) {
        visibility = if (value) View.VISIBLE else View.GONE
    }

/**
 * Methods
 */
@Suppress("unchecked_cast")
fun <V : View> View.getViewById(@IdRes id: Int): V {
    return findViewById(id) as V
}

fun View.setAllPadding(padding: Int) {
    setPadding(padding, padding, padding, padding)
}

fun View.setOptionalPadding(left: Int = paddingLeft,
                            top: Int = paddingTop,
                            right: Int = paddingRight,
                            bottom: Int = paddingBottom) {

    setPadding(left, top, right, bottom)
}

/**
 * Post functions
 */
inline fun <T : View> T.postLet(crossinline block: (T) -> Unit) {
    post { block(this) }
}

inline fun <T : View> T.postDelayedLet(delay: Long, crossinline block: (T) -> Unit) {
    postDelayed({ block(this) }, delay)
}

inline fun <T : View> T.postApply(crossinline block: T.() -> Unit) {
    post { block(this) }
}

inline fun <T : View> T.postDelayedApply(delay: Long, crossinline block: T.() -> Unit) {
    postDelayed({ block(this) }, delay)
}