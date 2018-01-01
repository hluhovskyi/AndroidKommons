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

package com.dewarder.akommons.view

import android.content.res.ColorStateList
import android.support.v4.view.ViewCompat
import android.view.View

/**
 * Properties
 */
var View.isVisible: Boolean
    get() = visibility == View.VISIBLE
    set(value) {
        visibility = if (value) View.VISIBLE else View.GONE
    }

var View.isInvisible: Boolean
    get() = visibility == View.INVISIBLE
    set(value) {
        visibility = if (value) View.INVISIBLE else View.VISIBLE
    }

var View.backgroundTintStateList: ColorStateList
    get() = ViewCompat.getBackgroundTintList(this)
    set(value) = ViewCompat.setBackgroundTintList(this, value)

var View.axisZ: Float
    get() = ViewCompat.getZ(this)
    set(value) = ViewCompat.setZ(this, value)

var View.translationAxisZ: Float
    get() = ViewCompat.getTranslationZ(this)
    set(value) = ViewCompat.setTranslationZ(this, value)

/**
 * Methods
 */
fun View.setAllPadding(padding: Int) {
    setPadding(padding, padding, padding, padding)
}

fun View.setOptionalPadding(
    left: Int = paddingLeft,
    top: Int = paddingTop,
    right: Int = paddingRight,
    bottom: Int = paddingBottom
) {
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