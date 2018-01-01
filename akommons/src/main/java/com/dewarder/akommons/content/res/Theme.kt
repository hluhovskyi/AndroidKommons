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

@file:JvmName("ThemeUtils")

package com.dewarder.akommons.content.res

import android.content.res.Resources
import android.content.res.TypedArray
import android.util.AttributeSet

inline fun <R> Resources.Theme.useStyledAttributes(
    set: AttributeSet? = null,
    attrs: IntArray,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0,
    block: (TypedArray) -> R
): R {
    val array = obtainStyledAttributes(set, attrs, defStyleAttr, defStyleRes)
    var recycled = false
    try {
        return block(array)
    } catch (e: Exception) {
        recycled = true
        try {
            array.recycle()
        } catch (recycleException: Exception) {
        }
        throw e
    } finally {
        if (!recycled) {
            array.recycle()
        }
    }
}

inline fun Resources.Theme.applyStyledAttributes(
    set: AttributeSet? = null,
    attrs: IntArray,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0,
    block: TypedArray.() -> Unit
) {
    val array = obtainStyledAttributes(set, attrs, defStyleAttr, defStyleRes)
    var recycled = false
    try {
        block(array)
    } catch (e: Exception) {
        recycled = true
        try {
            array.recycle()
        } catch (recycleException: Exception) {
        }
        throw e
    } finally {
        if (!recycled) {
            array.recycle()
        }
    }
}