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
import android.support.annotation.DimenRes
import android.view.View
import com.dewarder.akommons.util.*
import kotlin.properties.ReadOnlyProperty
import android.support.v4.app.Fragment as SupportFragment

/**
 * View
 */
fun View.dimen(@DimenRes dimenRes: Int, dimension: DimensionType = DimensionType.PX): ReadOnlyProperty<View, Float>
    = requiredDimen(contextProvider, dimenRes, dimension)

fun View.dimenOptional(@DimenRes dimenRes: Int, dimension: DimensionType = DimensionType.PX): ReadOnlyProperty<View, Float?>
    = optionalDimen(contextProvider, dimenRes, dimension)

fun View.dimens(@DimenRes vararg dimenRes: Int, dimension: DimensionType = DimensionType.PX): ReadOnlyProperty<View, List<Float>>
    = requiredDimens(contextProvider, dimenRes, dimension)

fun View.dimensOptional(@DimenRes vararg dimenRes: Int, dimension: DimensionType = DimensionType.PX): ReadOnlyProperty<View, List<Float?>>
    = optionalDimens(contextProvider, dimenRes, dimension)

/**
 * Activity
 */
fun Activity.dimen(@DimenRes dimenRes: Int, dimension: DimensionType = DimensionType.PX): ReadOnlyProperty<Activity, Float>
    = requiredDimen(contextProvider, dimenRes, dimension)

fun Activity.dimenOptional(@DimenRes dimenRes: Int, dimension: DimensionType = DimensionType.PX): ReadOnlyProperty<Activity, Float?>
    = optionalDimen(contextProvider, dimenRes, dimension)

fun Activity.dimens(@DimenRes vararg dimenRes: Int, dimension: DimensionType = DimensionType.PX): ReadOnlyProperty<Activity, List<Float>>
    = requiredDimens(contextProvider, dimenRes, dimension)

fun Activity.dimensOptional(@DimenRes vararg dimenRes: Int, dimension: DimensionType = DimensionType.PX): ReadOnlyProperty<Activity, List<Float?>>
    = optionalDimens(contextProvider, dimenRes, dimension)

/**
 * Fragment
 */
fun Fragment.dimen(@DimenRes dimenRes: Int, dimension: DimensionType = DimensionType.PX): ReadOnlyProperty<Fragment, Float>
    = requiredDimen(contextProvider, dimenRes, dimension)

fun Fragment.dimenOptional(@DimenRes dimenRes: Int, dimension: DimensionType = DimensionType.PX): ReadOnlyProperty<Fragment, Float?>
    = optionalDimen(contextProvider, dimenRes, dimension)

fun Fragment.dimens(@DimenRes vararg dimenRes: Int, dimension: DimensionType = DimensionType.PX): ReadOnlyProperty<Fragment, List<Float>>
    = requiredDimens(contextProvider, dimenRes, dimension)

fun Fragment.dimensOptional(@DimenRes vararg dimenRes: Int, dimension: DimensionType = DimensionType.PX): ReadOnlyProperty<Fragment, List<Float?>>
    = optionalDimens(contextProvider, dimenRes, dimension)

/**
 * Dialog
 */
fun Dialog.dimen(@DimenRes dimenRes: Int, dimension: DimensionType = DimensionType.PX): ReadOnlyProperty<Dialog, Float>
    = requiredDimen(contextProvider, dimenRes, dimension)

fun Dialog.dimenOptional(@DimenRes dimenRes: Int, dimension: DimensionType = DimensionType.PX): ReadOnlyProperty<Dialog, Float?>
    = optionalDimen(contextProvider, dimenRes, dimension)

fun Dialog.dimens(@DimenRes vararg dimenRes: Int, dimension: DimensionType = DimensionType.PX): ReadOnlyProperty<Dialog, List<Float>>
    = requiredDimens(contextProvider, dimenRes, dimension)

fun Dialog.dimensOptional(@DimenRes vararg dimenRes: Int, dimension: DimensionType = DimensionType.PX): ReadOnlyProperty<Dialog, List<Float?>>
    = optionalDimens(contextProvider, dimenRes, dimension)

/**
 * SupportFragment
 */
fun SupportFragment.dimen(@DimenRes dimenRes: Int, dimension: DimensionType = DimensionType.PX): ReadOnlyProperty<SupportFragment, Float>
    = requiredDimen(contextProvider, dimenRes, dimension)

fun SupportFragment.dimenOptional(@DimenRes dimenRes: Int, dimension: DimensionType = DimensionType.PX): ReadOnlyProperty<SupportFragment, Float?>
    = optionalDimen(contextProvider, dimenRes, dimension)

fun SupportFragment.dimens(@DimenRes vararg dimenRes: Int, dimension: DimensionType = DimensionType.PX): ReadOnlyProperty<SupportFragment, List<Float>>
    = requiredDimens(contextProvider, dimenRes, dimension)

fun SupportFragment.dimensOptional(@DimenRes vararg dimenRes: Int, dimension: DimensionType = DimensionType.PX): ReadOnlyProperty<SupportFragment, List<Float?>>
    = optionalDimens(contextProvider, dimenRes, dimension)


/**
 * ContextProvider
 */
fun ContextProvider.dimen(@DimenRes dimenRes: Int, dimension: DimensionType = DimensionType.PX): ReadOnlyProperty<ContextProvider, Float>
    = requiredDimen(this::provideContext, dimenRes, dimension)

fun ContextProvider.dimenOptional(@DimenRes dimenRes: Int, dimension: DimensionType = DimensionType.PX): ReadOnlyProperty<ContextProvider, Float?>
    = optionalDimen(this::provideContext, dimenRes, dimension)

fun ContextProvider.dimens(@DimenRes vararg dimenRes: Int, dimension: DimensionType = DimensionType.PX): ReadOnlyProperty<ContextProvider, List<Float>>
    = requiredDimens(this::provideContext, dimenRes, dimension)

fun ContextProvider.dimensOptional(@DimenRes vararg dimenRes: Int, dimension: DimensionType = DimensionType.PX): ReadOnlyProperty<ContextProvider, List<Float?>>
    = optionalDimens(this::provideContext, dimenRes, dimension)


/**
 * Getters
 */
private inline fun <R> requiredDimen(crossinline contextProvider: () -> Context,
                                     @DimenRes dimenRes: Int,
                                     dimension: DimensionType): ReadOnlyProperty<R, Float> {

    return Required { contextProvider().getDimension(dimenRes, dimension) }
}

private inline fun <R> optionalDimen(crossinline contextProvider: () -> Context,
                                     @DimenRes dimenRes: Int,
                                     dimension: DimensionType): ReadOnlyProperty<R, Float?> {

    return Optional { contextProvider().getSafeDimension(dimenRes, dimension) }
}

private inline fun <R> requiredDimens(crossinline contextProvider: () -> Context,
                                      @DimenRes dimenRes: IntArray,
                                      dimension: DimensionType): ReadOnlyProperty<R, List<Float>> {

    return Required {
        val context = contextProvider()
        dimenRes.map { id -> context.getDimension(id, dimension) }
    }
}

private inline fun <R> optionalDimens(crossinline contextProvider: () -> Context,
                                      @DimenRes dimenRes: IntArray,
                                      dimension: DimensionType): ReadOnlyProperty<R, List<Float?>> {

    return Required {
        val context = contextProvider()
        dimenRes.map { id -> context.getSafeDimension(id, dimension) }
    }
}
