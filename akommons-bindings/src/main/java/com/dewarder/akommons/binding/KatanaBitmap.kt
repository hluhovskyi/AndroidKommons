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
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.support.annotation.DrawableRes
import android.view.View
import com.dewarder.akommons.util.*
import kotlin.properties.ReadOnlyProperty
import android.support.v4.app.Fragment as SupportFragment

/**
 * View
 */
fun View.bitmap(@DrawableRes drawableRes: Int, options: BitmapFactory.Options? = null): ReadOnlyProperty<View, Bitmap>
    = requiredBitmap(contextProvider, drawableRes, options)

fun View.bitmapOptional(@DrawableRes drawableRes: Int, options: BitmapFactory.Options? = null): ReadOnlyProperty<View, Bitmap?>
    = optionalBitmap(contextProvider, drawableRes, options)

fun View.bitmaps(@DrawableRes vararg drawableRes: Int, options: BitmapFactory.Options? = null): ReadOnlyProperty<View, List<Bitmap>>
    = requiredBitmaps(contextProvider, drawableRes, options)

fun View.bitmapsOptional(@DrawableRes vararg drawableRes: Int, options: BitmapFactory.Options? = null): ReadOnlyProperty<View, List<Bitmap?>>
    = optionalBitmaps(contextProvider, drawableRes, options)

/**
 * Activity
 */
fun Activity.bitmap(@DrawableRes drawableRes: Int, options: BitmapFactory.Options? = null): ReadOnlyProperty<Activity, Bitmap>
    = requiredBitmap(contextProvider, drawableRes, options)

fun Activity.bitmapOptional(@DrawableRes drawableRes: Int, options: BitmapFactory.Options? = null): ReadOnlyProperty<Activity, Bitmap?>
    = optionalBitmap(contextProvider, drawableRes, options)

fun Activity.bitmaps(@DrawableRes vararg drawableRes: Int, options: BitmapFactory.Options? = null): ReadOnlyProperty<Activity, List<Bitmap>>
    = requiredBitmaps(contextProvider, drawableRes, options)

fun Activity.bitmapsOptional(@DrawableRes vararg drawableRes: Int, options: BitmapFactory.Options? = null): ReadOnlyProperty<Activity, List<Bitmap?>>
    = optionalBitmaps(contextProvider, drawableRes, options)

/**
 * Fragment
 */
fun Fragment.bitmap(@DrawableRes drawableRes: Int, options: BitmapFactory.Options? = null): ReadOnlyProperty<Fragment, Bitmap>
    = requiredBitmap(contextProvider, drawableRes, options)

fun Fragment.bitmapOptional(@DrawableRes drawableRes: Int, options: BitmapFactory.Options? = null): ReadOnlyProperty<Fragment, Bitmap?>
    = optionalBitmap(contextProvider, drawableRes, options)

fun Fragment.bitmaps(@DrawableRes vararg drawableRes: Int, options: BitmapFactory.Options? = null): ReadOnlyProperty<Fragment, List<Bitmap>>
    = requiredBitmaps(contextProvider, drawableRes, options)

fun Fragment.bitmapsOptional(@DrawableRes vararg drawableRes: Int, options: BitmapFactory.Options? = null): ReadOnlyProperty<Fragment, List<Bitmap?>>
    = optionalBitmaps(contextProvider, drawableRes, options)

/**
 * Dialog
 */
fun Dialog.bitmap(@DrawableRes drawableRes: Int, options: BitmapFactory.Options? = null): ReadOnlyProperty<Dialog, Bitmap>
    = requiredBitmap(contextProvider, drawableRes, options)

fun Dialog.bitmapOptional(@DrawableRes drawableRes: Int, options: BitmapFactory.Options? = null): ReadOnlyProperty<Dialog, Bitmap?>
    = optionalBitmap(contextProvider, drawableRes, options)

fun Dialog.bitmaps(@DrawableRes vararg drawableRes: Int, options: BitmapFactory.Options? = null): ReadOnlyProperty<Dialog, List<Bitmap>>
    = requiredBitmaps(contextProvider, drawableRes, options)

fun Dialog.bitmapsOptional(@DrawableRes vararg drawableRes: Int, options: BitmapFactory.Options? = null): ReadOnlyProperty<Dialog, List<Bitmap?>>
    = optionalBitmaps(contextProvider, drawableRes, options)

/**
 * SupportFragment
 */
fun SupportFragment.bitmap(@DrawableRes drawableRes: Int, options: BitmapFactory.Options? = null): ReadOnlyProperty<SupportFragment, Bitmap>
    = requiredBitmap(contextProvider, drawableRes, options)

fun SupportFragment.bitmapOptional(@DrawableRes drawableRes: Int, options: BitmapFactory.Options? = null): ReadOnlyProperty<SupportFragment, Bitmap?>
    = optionalBitmap(contextProvider, drawableRes, options)

fun SupportFragment.bitmaps(@DrawableRes vararg drawableRes: Int, options: BitmapFactory.Options? = null): ReadOnlyProperty<SupportFragment, List<Bitmap>>
    = requiredBitmaps(contextProvider, drawableRes, options)

fun SupportFragment.bitmapsOptional(@DrawableRes vararg drawableRes: Int, options: BitmapFactory.Options? = null): ReadOnlyProperty<SupportFragment, List<Bitmap?>>
    = optionalBitmaps(contextProvider, drawableRes, options)


/**
 * ContextProvider
 */
fun ContextProvider.bitmap(@DrawableRes drawableRes: Int, options: BitmapFactory.Options? = null): ReadOnlyProperty<ContextProvider, Bitmap>
    = requiredBitmap(this::provideContext, drawableRes, options)

fun ContextProvider.bitmapOptional(@DrawableRes drawableRes: Int, options: BitmapFactory.Options? = null): ReadOnlyProperty<ContextProvider, Bitmap?>
    = optionalBitmap(this::provideContext, drawableRes, options)

fun ContextProvider.bitmaps(@DrawableRes vararg drawableRes: Int, options: BitmapFactory.Options? = null): ReadOnlyProperty<ContextProvider, List<Bitmap>>
    = requiredBitmaps(this::provideContext, drawableRes, options)

fun ContextProvider.bitmapsOptional(@DrawableRes vararg drawableRes: Int, options: BitmapFactory.Options? = null): ReadOnlyProperty<ContextProvider, List<Bitmap?>>
    = optionalBitmaps(this::provideContext, drawableRes, options)


/**
 * Getters
 */
private inline fun <R> requiredBitmap(crossinline contextProvider: () -> Context,
                                      @DrawableRes drawableRes: Int,
                                      options: BitmapFactory.Options?): ReadOnlyProperty<R, Bitmap> {

    return Required { contextProvider().getBitmap(drawableRes, options) }
}

private inline fun <R> optionalBitmap(crossinline contextProvider: () -> Context,
                                      @DrawableRes drawableRes: Int,
                                      options: BitmapFactory.Options?): ReadOnlyProperty<R, Bitmap?> {

    return Optional { contextProvider().getSafeBitmap(drawableRes, options) }
}

private inline fun <R> requiredBitmaps(crossinline contextProvider: () -> Context,
                                       @DrawableRes drawableRes: IntArray,
                                       options: BitmapFactory.Options?): ReadOnlyProperty<R, List<Bitmap>> {

    return Required {
        val context = contextProvider()
        drawableRes.map { id -> context.getBitmap(id, options) }
    }
}

private inline fun <R> optionalBitmaps(crossinline contextProvider: () -> Context,
                                       @DrawableRes drawableRes: IntArray,
                                       options: BitmapFactory.Options?): ReadOnlyProperty<R, List<Bitmap?>> {

    return Required {
        val context = contextProvider()
        drawableRes.map { id -> context.getSafeBitmap(id, options) }
    }
}
