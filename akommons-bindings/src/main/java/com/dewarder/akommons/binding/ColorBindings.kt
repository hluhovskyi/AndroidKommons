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
 */

package com.dewarder.akommons.binding

import android.app.Activity
import android.app.Dialog
import android.app.Fragment
import android.content.Context
import android.support.annotation.ColorRes
import android.support.annotation.RestrictTo
import android.view.View
import com.dewarder.akommons.binding.util.contextProvider
import com.dewarder.akommons.binding.util.getSafeThemedColor
import com.dewarder.akommons.binding.util.getThemedColor
import com.dewarder.akommons.util.Optional
import com.dewarder.akommons.util.Required
import kotlin.properties.ReadOnlyProperty

/**
 * View
 */
fun View.color(@ColorRes colorRes: Int): ReadOnlyProperty<View, Int>
        = requiredColor(contextProvider, colorRes)

fun View.colorOptional(@ColorRes colorRes: Int): ReadOnlyProperty<View, Int?>
        = optionalColor(contextProvider, colorRes)

fun View.colors(@ColorRes vararg colorRes: Int): ReadOnlyProperty<View, List<Int>>
        = requiredColors(contextProvider, colorRes)

fun View.colorsOptional(@ColorRes vararg colorRes: Int): ReadOnlyProperty<View, List<Int?>>
        = optionalColors(contextProvider, colorRes)

/**
 * Activity
 */
fun Activity.color(@ColorRes colorRes: Int): ReadOnlyProperty<Activity, Int>
        = requiredColor(contextProvider, colorRes)

fun Activity.colorOptional(@ColorRes colorRes: Int): ReadOnlyProperty<Activity, Int?>
        = optionalColor(contextProvider, colorRes)

fun Activity.colors(@ColorRes vararg colorRes: Int): ReadOnlyProperty<Activity, List<Int>>
        = requiredColors(contextProvider, colorRes)

fun Activity.colorsOptional(@ColorRes vararg colorRes: Int): ReadOnlyProperty<Activity, List<Int?>>
        = optionalColors(contextProvider, colorRes)

/**
 * Fragment
 */
fun Fragment.color(@ColorRes colorRes: Int): ReadOnlyProperty<Fragment, Int>
        = requiredColor(contextProvider, colorRes)

fun Fragment.colorOptional(@ColorRes colorRes: Int): ReadOnlyProperty<Fragment, Int?>
        = optionalColor(contextProvider, colorRes)

fun Fragment.colors(@ColorRes vararg colorRes: Int): ReadOnlyProperty<Fragment, List<Int>>
        = requiredColors(contextProvider, colorRes)

fun Fragment.colorsOptional(@ColorRes vararg colorRes: Int): ReadOnlyProperty<Fragment, List<Int?>>
        = optionalColors(contextProvider, colorRes)

/**
 * Dialog
 */
fun Dialog.color(@ColorRes colorRes: Int): ReadOnlyProperty<Dialog, Int>
        = requiredColor(contextProvider, colorRes)

fun Dialog.colorOptional(@ColorRes colorRes: Int): ReadOnlyProperty<Dialog, Int?>
        = optionalColor(contextProvider, colorRes)

fun Dialog.colors(@ColorRes vararg colorRes: Int): ReadOnlyProperty<Dialog, List<Int>>
        = requiredColors(contextProvider, colorRes)

fun Dialog.colorsOptional(@ColorRes vararg colorRes: Int): ReadOnlyProperty<Dialog, List<Int?>>
        = optionalColors(contextProvider, colorRes)


/**
 * ContextProvider
 */
fun ContextProvider.color(@ColorRes colorRes: Int): ReadOnlyProperty<ContextProvider, Int>
        = requiredColor(this::provideContext, colorRes)

fun ContextProvider.colorOptional(@ColorRes colorRes: Int): ReadOnlyProperty<ContextProvider, Int?>
        = optionalColor(this::provideContext, colorRes)

fun ContextProvider.colors(@ColorRes vararg colorRes: Int): ReadOnlyProperty<ContextProvider, List<Int>>
        = requiredColors(this::provideContext, colorRes)

fun ContextProvider.colorsOptional(@ColorRes vararg colorRes: Int): ReadOnlyProperty<ContextProvider, List<Int?>>
        = optionalColors(this::provideContext, colorRes)


/**
 * Getters
 */
@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
inline fun <R> requiredColor(crossinline contextProvider: () -> Context,
                             @ColorRes colorRes: Int): ReadOnlyProperty<R, Int> {
    return Required { contextProvider().getThemedColor(colorRes) }
}

@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
inline fun <R> optionalColor(crossinline contextProvider: () -> Context,
                             @ColorRes colorRes: Int): ReadOnlyProperty<R, Int?> {

    return Optional { contextProvider().getSafeThemedColor(colorRes) }
}

@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
inline fun <R> requiredColors(crossinline contextProvider: () -> Context,
                              @ColorRes colorRes: IntArray): ReadOnlyProperty<R, List<Int>> {

    return Required {
        val context = contextProvider()
        colorRes.map(context::getThemedColor)
    }
}

@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
inline fun <R> optionalColors(crossinline contextProvider: () -> Context,
                              @ColorRes colorRes: IntArray): ReadOnlyProperty<R, List<Int?>> {

    return Required {
        val context = contextProvider()
        colorRes.map(context::getSafeThemedColor)
    }
}
