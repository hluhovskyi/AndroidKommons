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

package com.dewarder.akommons.binding.support

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.support.annotation.DrawableRes
import com.dewarder.akommons.binding.optionalBitmap
import com.dewarder.akommons.binding.optionalBitmaps
import com.dewarder.akommons.binding.requiredBitmap
import com.dewarder.akommons.binding.requiredBitmaps
import kotlin.properties.ReadOnlyProperty
import android.support.v4.app.Fragment as SupportFragment


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