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

@file:JvmName("TypedArrayUtils")

package com.dewarder.akommons.content.res

import android.content.Context
import android.content.res.Resources
import android.content.res.TypedArray
import android.support.annotation.AttrRes
import android.support.annotation.StyleRes
import android.support.annotation.StyleableRes
import android.util.AttributeSet

inline fun <R> TypedArray.use(block: (TypedArray) -> R): R {
    var recycled = false
    try {
        return block(this)
    } catch (e: Exception) {
        recycled = true
        try {
            recycle()
        } catch (recycleException: Exception) {
        }
        throw e
    } finally {
        if (!recycled) {
            recycle()
        }
    }
}

inline fun <R> Context.useStyledAttributes(@StyleableRes attrs: IntArray, block: (TypedArray) -> R): R
    = obtainStyledAttributes(attrs).use(block)

inline fun <R> Context.useStyledAttributes(@StyleRes resid: Int, @StyleableRes attrs: IntArray, block: (TypedArray) -> R): R
    = obtainStyledAttributes(resid, attrs).use(block)

inline fun <R> Context.useStyledAttributes(set: AttributeSet, @StyleableRes attrs: IntArray, block: (TypedArray) -> R): R
    = obtainStyledAttributes(set, attrs).use(block)

inline fun <R> Context.useStyledAttributes(set: AttributeSet, @StyleableRes attrs: IntArray, @AttrRes defStyleAttr: Int, @StyleRes defStyleRes: Int, block: (TypedArray) -> R): R
    = obtainStyledAttributes(set, attrs, defStyleAttr, defStyleRes).use(block)
