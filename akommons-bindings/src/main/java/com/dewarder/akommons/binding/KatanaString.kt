/*
 * Copyright (C) 2017 Artem Glugovsky
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
import android.support.annotation.StringRes
import android.view.View
import com.dewarder.akommons.util.Optional
import com.dewarder.akommons.util.Required
import com.dewarder.akommons.util.contextProvider
import com.dewarder.akommons.util.safeString
import kotlin.properties.ReadOnlyProperty

import android.support.v4.app.Fragment as SupportFragment

/**
 * View
 */
fun View.string(@StringRes stringRes: Int): ReadOnlyProperty<View, String>
    = requiredString(contextProvider, stringRes)

fun View.stringOptional(@StringRes stringRes: Int): ReadOnlyProperty<View, String?>
    = optionalString(contextProvider, stringRes)

fun View.strings(@StringRes vararg stringRes: Int): ReadOnlyProperty<View, List<String>>
    = requiredStrings(contextProvider, stringRes)

fun View.stringsOptional(@StringRes vararg stringRes: Int): ReadOnlyProperty<View, List<String?>>
    = optionalStrings(contextProvider, stringRes)

/**
 * Activity
 */
fun Activity.string(@StringRes stringRes: Int): ReadOnlyProperty<Activity, String>
    = requiredString(contextProvider, stringRes)

fun Activity.stringOptional(@StringRes stringRes: Int): ReadOnlyProperty<Activity, String?>
    = optionalString(contextProvider, stringRes)

fun Activity.strings(@StringRes vararg stringRes: Int): ReadOnlyProperty<Activity, List<String>>
    = requiredStrings(contextProvider, stringRes)

fun Activity.stringsOptional(@StringRes vararg stringRes: Int): ReadOnlyProperty<Activity, List<String?>>
    = optionalStrings(contextProvider, stringRes)

/**
 * Fragment
 */
fun Fragment.string(@StringRes stringRes: Int): ReadOnlyProperty<Fragment, String>
    = requiredString(contextProvider, stringRes)

fun Fragment.stringOptional(@StringRes stringRes: Int): ReadOnlyProperty<Fragment, String?>
    = optionalString(contextProvider, stringRes)

fun Fragment.strings(@StringRes vararg stringRes: Int): ReadOnlyProperty<Fragment, List<String>>
    = requiredStrings(contextProvider, stringRes)

fun Fragment.stringsOptional(@StringRes vararg stringRes: Int): ReadOnlyProperty<Fragment, List<String?>>
    = optionalStrings(contextProvider, stringRes)

/**
 * Dialog
 */
fun Dialog.string(@StringRes stringRes: Int): ReadOnlyProperty<Dialog, String>
    = requiredString(contextProvider, stringRes)

fun Dialog.stringOptional(@StringRes stringRes: Int): ReadOnlyProperty<Dialog, String?>
    = optionalString(contextProvider, stringRes)

fun Dialog.strings(@StringRes vararg stringRes: Int): ReadOnlyProperty<Dialog, List<String>>
    = requiredStrings(contextProvider, stringRes)

fun Dialog.stringsOptional(@StringRes vararg stringRes: Int): ReadOnlyProperty<Dialog, List<String?>>
    = optionalStrings(contextProvider, stringRes)

/**
 * SupportFragment
 */
fun SupportFragment.string(@StringRes stringRes: Int): ReadOnlyProperty<SupportFragment, String>
    = requiredString(contextProvider, stringRes)

fun SupportFragment.stringOptional(@StringRes stringRes: Int): ReadOnlyProperty<SupportFragment, String?>
    = optionalString(contextProvider, stringRes)

fun SupportFragment.strings(@StringRes vararg stringRes: Int): ReadOnlyProperty<SupportFragment, List<String>>
    = requiredStrings(contextProvider, stringRes)

fun SupportFragment.stringsOptional(@StringRes vararg stringRes: Int): ReadOnlyProperty<SupportFragment, List<String?>>
    = optionalStrings(contextProvider, stringRes)


/**
 * ContextProvider
 */
fun ContextProvider.string(@StringRes stringRes: Int): ReadOnlyProperty<ContextProvider, String>
    = requiredString(this::provideContext, stringRes)

fun ContextProvider.stringOptional(@StringRes stringRes: Int): ReadOnlyProperty<ContextProvider, String?>
    = optionalString(this::provideContext, stringRes)

fun ContextProvider.strings(@StringRes vararg stringRes: Int): ReadOnlyProperty<ContextProvider, List<String>>
    = requiredStrings(this::provideContext, stringRes)

fun ContextProvider.stringsOptional(@StringRes vararg stringRes: Int): ReadOnlyProperty<ContextProvider, List<String?>>
    = optionalStrings(this::provideContext, stringRes)


/**
 * Getters
 */
private inline fun <R> requiredString(crossinline contextProvider: () -> Context,
                                      @StringRes stringRes: Int): ReadOnlyProperty<R, String> {

    return Required { contextProvider().getString(stringRes) }
}

private inline fun <R> optionalString(crossinline contextProvider: () -> Context,
                                      @StringRes stringRes: Int): ReadOnlyProperty<R, String?> {

    return Optional { contextProvider().safeString(stringRes) }
}

private inline fun <R> requiredStrings(crossinline contextProvider: () -> Context,
                                       @StringRes stringRes: IntArray): ReadOnlyProperty<R, List<String>> {

    return Required {
        val context = contextProvider()
        stringRes.map(context::getString)
    }
}

private inline fun <R> optionalStrings(crossinline contextProvider: () -> Context,
                                       @StringRes stringRes: IntArray): ReadOnlyProperty<R, List<String?>> {

    return Required {
        val context = contextProvider()
        stringRes.map(context::safeString)
    }
}
