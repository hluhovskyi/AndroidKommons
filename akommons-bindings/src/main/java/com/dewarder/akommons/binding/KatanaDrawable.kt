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
import android.graphics.drawable.Drawable
import android.support.annotation.DrawableRes
import android.view.View
import com.dewarder.akommons.util.*
import kotlin.properties.ReadOnlyProperty
import android.support.v4.app.Fragment as SupportFragment

/**
 * View
 */
fun View.drawable(@DrawableRes drawableRes: Int): ReadOnlyProperty<View, Drawable>
    = requiredDrawable(contextProvider, drawableRes)

fun View.drawableOptional(@DrawableRes drawableRes: Int): ReadOnlyProperty<View, Drawable?>
    = optionalDrawable(contextProvider, drawableRes)

fun View.drawables(@DrawableRes vararg drawableRes: Int): ReadOnlyProperty<View, List<Drawable>>
    = requiredDrawables(contextProvider, drawableRes)

fun View.drawablesOptional(@DrawableRes vararg drawableRes: Int): ReadOnlyProperty<View, List<Drawable?>>
    = optionalDrawables(contextProvider, drawableRes)

/**
 * Activity
 */
fun Activity.drawable(@DrawableRes drawableRes: Int): ReadOnlyProperty<Activity, Drawable>
    = requiredDrawable(contextProvider, drawableRes)

fun Activity.drawableOptional(@DrawableRes drawableRes: Int): ReadOnlyProperty<Activity, Drawable?>
    = optionalDrawable(contextProvider, drawableRes)

fun Activity.drawables(@DrawableRes vararg drawableRes: Int): ReadOnlyProperty<Activity, List<Drawable>>
    = requiredDrawables(contextProvider, drawableRes)

fun Activity.drawablesOptional(@DrawableRes vararg drawableRes: Int): ReadOnlyProperty<Activity, List<Drawable?>>
    = optionalDrawables(contextProvider, drawableRes)

/**
 * Fragment
 */
fun Fragment.drawable(@DrawableRes drawableRes: Int): ReadOnlyProperty<Fragment, Drawable>
    = requiredDrawable(contextProvider, drawableRes)

fun Fragment.drawableOptional(@DrawableRes drawableRes: Int): ReadOnlyProperty<Fragment, Drawable?>
    = optionalDrawable(contextProvider, drawableRes)

fun Fragment.drawables(@DrawableRes vararg drawableRes: Int): ReadOnlyProperty<Fragment, List<Drawable>>
    = requiredDrawables(contextProvider, drawableRes)

fun Fragment.drawablesOptional(@DrawableRes vararg drawableRes: Int): ReadOnlyProperty<Fragment, List<Drawable?>>
    = optionalDrawables(contextProvider, drawableRes)

/**
 * Dialog
 */
fun Dialog.drawable(@DrawableRes drawableRes: Int): ReadOnlyProperty<Dialog, Drawable>
    = requiredDrawable(contextProvider, drawableRes)

fun Dialog.drawableOptional(@DrawableRes drawableRes: Int): ReadOnlyProperty<Dialog, Drawable?>
    = optionalDrawable(contextProvider, drawableRes)

fun Dialog.drawables(@DrawableRes vararg drawableRes: Int): ReadOnlyProperty<Dialog, List<Drawable>>
    = requiredDrawables(contextProvider, drawableRes)

fun Dialog.drawablesOptional(@DrawableRes vararg drawableRes: Int): ReadOnlyProperty<Dialog, List<Drawable?>>
    = optionalDrawables(contextProvider, drawableRes)

/**
 * SupportFragment
 */
fun SupportFragment.drawable(@DrawableRes drawableRes: Int): ReadOnlyProperty<SupportFragment, Drawable>
    = requiredDrawable(contextProvider, drawableRes)

fun SupportFragment.drawableOptional(@DrawableRes drawableRes: Int): ReadOnlyProperty<SupportFragment, Drawable?>
    = optionalDrawable(contextProvider, drawableRes)

fun SupportFragment.drawables(@DrawableRes vararg drawableRes: Int): ReadOnlyProperty<SupportFragment, List<Drawable>>
    = requiredDrawables(contextProvider, drawableRes)

fun SupportFragment.drawablesOptional(@DrawableRes vararg drawableRes: Int): ReadOnlyProperty<SupportFragment, List<Drawable?>>
    = optionalDrawables(contextProvider, drawableRes)


/**
 * ContextProvider
 */
fun ContextProvider.drawable(@DrawableRes drawableRes: Int): ReadOnlyProperty<ContextProvider, Drawable>
    = requiredDrawable(this::provideContext, drawableRes)

fun ContextProvider.drawableOptional(@DrawableRes drawableRes: Int): ReadOnlyProperty<ContextProvider, Drawable?>
    = optionalDrawable(this::provideContext, drawableRes)

fun ContextProvider.drawables(@DrawableRes vararg drawableRes: Int): ReadOnlyProperty<ContextProvider, List<Drawable>>
    = requiredDrawables(this::provideContext, drawableRes)

fun ContextProvider.drawablesOptional(@DrawableRes vararg drawableRes: Int): ReadOnlyProperty<ContextProvider, List<Drawable?>>
    = optionalDrawables(this::provideContext, drawableRes)


/**
 * Getters
 */
private inline fun <R> requiredDrawable(crossinline contextProvider: () -> Context,
                                        @DrawableRes drawableRes: Int): ReadOnlyProperty<R, Drawable> {

    return Required { contextProvider().getThemedDrawable(drawableRes) }
}

private inline fun <R> optionalDrawable(crossinline contextProvider: () -> Context,
                                        @DrawableRes drawableRes: Int): ReadOnlyProperty<R, Drawable?> {

    return Optional { contextProvider().getSafeThemedDrawable(drawableRes) }
}

private inline fun <R> requiredDrawables(crossinline contextProvider: () -> Context,
                                         @DrawableRes drawableRes: IntArray): ReadOnlyProperty<R, List<Drawable>> {

    return Required {
        val context = contextProvider()
        drawableRes.map(context::getThemedDrawable)
    }
}

private inline fun <R> optionalDrawables(crossinline contextProvider: () -> Context,
                                         @DrawableRes drawableRes: IntArray): ReadOnlyProperty<R, List<Drawable?>> {

    return Required {
        val context = contextProvider()
        drawableRes.map(context::getSafeThemedDrawable)
    }
}
