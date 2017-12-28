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
import android.support.annotation.IntegerRes
import android.view.View
import com.dewarder.akommons.util.*
import kotlin.properties.ReadOnlyProperty
import android.support.v4.app.Fragment as SupportFragment

/**
 * View
 */
fun View.integer(@IntegerRes integerRes: Int): ReadOnlyProperty<View, Int>
    = requiredInteger(contextProvider, integerRes)

fun View.integerOptional(@IntegerRes integerRes: Int): ReadOnlyProperty<View, Int?>
    = optionalInteger(contextProvider, integerRes)

fun View.integers(@IntegerRes vararg integerRes: Int): ReadOnlyProperty<View, List<Int>>
    = requiredIntegers(contextProvider, integerRes)

fun View.integersOptional(@IntegerRes vararg integerRes: Int): ReadOnlyProperty<View, List<Int?>>
    = optionalIntegers(contextProvider, integerRes)

/**
 * Activity
 */
fun Activity.integer(@IntegerRes integerRes: Int): ReadOnlyProperty<Activity, Int>
    = requiredInteger(contextProvider, integerRes)

fun Activity.integerOptional(@IntegerRes integerRes: Int): ReadOnlyProperty<Activity, Int?>
    = optionalInteger(contextProvider, integerRes)

fun Activity.integers(@IntegerRes vararg integerRes: Int): ReadOnlyProperty<Activity, List<Int>>
    = requiredIntegers(contextProvider, integerRes)

fun Activity.integersOptional(@IntegerRes vararg integerRes: Int): ReadOnlyProperty<Activity, List<Int?>>
    = optionalIntegers(contextProvider, integerRes)

/**
 * Fragment
 */
fun Fragment.integer(@IntegerRes integerRes: Int): ReadOnlyProperty<Fragment, Int>
    = requiredInteger(contextProvider, integerRes)

fun Fragment.integerOptional(@IntegerRes integerRes: Int): ReadOnlyProperty<Fragment, Int?>
    = optionalInteger(contextProvider, integerRes)

fun Fragment.integers(@IntegerRes vararg integerRes: Int): ReadOnlyProperty<Fragment, List<Int>>
    = requiredIntegers(contextProvider, integerRes)

fun Fragment.integersOptional(@IntegerRes vararg integerRes: Int): ReadOnlyProperty<Fragment, List<Int?>>
    = optionalIntegers(contextProvider, integerRes)

/**
 * Dialog
 */
fun Dialog.integer(@IntegerRes integerRes: Int): ReadOnlyProperty<Dialog, Int>
    = requiredInteger(contextProvider, integerRes)

fun Dialog.integerOptional(@IntegerRes integerRes: Int): ReadOnlyProperty<Dialog, Int?>
    = optionalInteger(contextProvider, integerRes)

fun Dialog.integers(@IntegerRes vararg integerRes: Int): ReadOnlyProperty<Dialog, List<Int>>
    = requiredIntegers(contextProvider, integerRes)

fun Dialog.integersOptional(@IntegerRes vararg integerRes: Int): ReadOnlyProperty<Dialog, List<Int?>>
    = optionalIntegers(contextProvider, integerRes)

/**
 * SupportFragment
 */
fun SupportFragment.integer(@IntegerRes integerRes: Int): ReadOnlyProperty<SupportFragment, Int>
    = requiredInteger(contextProvider, integerRes)

fun SupportFragment.integerOptional(@IntegerRes integerRes: Int): ReadOnlyProperty<SupportFragment, Int?>
    = optionalInteger(contextProvider, integerRes)

fun SupportFragment.integers(@IntegerRes vararg integerRes: Int): ReadOnlyProperty<SupportFragment, List<Int>>
    = requiredIntegers(contextProvider, integerRes)

fun SupportFragment.integersOptional(@IntegerRes vararg integerRes: Int): ReadOnlyProperty<SupportFragment, List<Int?>>
    = optionalIntegers(contextProvider, integerRes)


/**
 * ContextProvider
 */
fun ContextProvider.integer(@IntegerRes integerRes: Int): ReadOnlyProperty<ContextProvider, Int>
    = requiredInteger(this::provideContext, integerRes)

fun ContextProvider.integerOptional(@IntegerRes integerRes: Int): ReadOnlyProperty<ContextProvider, Int?>
    = optionalInteger(this::provideContext, integerRes)

fun ContextProvider.integers(@IntegerRes vararg integerRes: Int): ReadOnlyProperty<ContextProvider, List<Int>>
    = requiredIntegers(this::provideContext, integerRes)

fun ContextProvider.integersOptional(@IntegerRes vararg integerRes: Int): ReadOnlyProperty<ContextProvider, List<Int?>>
    = optionalIntegers(this::provideContext, integerRes)


/**
 * Getters
 */
private inline fun <R> requiredInteger(crossinline contextProvider: () -> Context,
                                       @IntegerRes integerRes: Int): ReadOnlyProperty<R, Int> {

    return Required { contextProvider().getInteger(integerRes) }
}

private inline fun <R> optionalInteger(crossinline contextProvider: () -> Context,
                                       @IntegerRes integerRes: Int): ReadOnlyProperty<R, Int?> {

    return Optional { contextProvider().getSafeInteger(integerRes) }
}

private inline fun <R> requiredIntegers(crossinline contextProvider: () -> Context,
                                        @IntegerRes integerRes: IntArray): ReadOnlyProperty<R, List<Int>> {

    return Required {
        val context = contextProvider()
        integerRes.map(context::getInteger)
    }
}

private inline fun <R> optionalIntegers(crossinline contextProvider: () -> Context,
                                        @IntegerRes integerRes: IntArray): ReadOnlyProperty<R, List<Int?>> {

    return Required {
        val context = contextProvider()
        integerRes.map(context::getSafeInteger)
    }
}
