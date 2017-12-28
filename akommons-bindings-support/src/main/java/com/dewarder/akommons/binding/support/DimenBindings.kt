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

import android.support.annotation.DimenRes
import com.dewarder.akommons.binding.*
import kotlin.properties.ReadOnlyProperty
import android.support.v4.app.Fragment as SupportFragment


/**
 * SupportFragment
 */
fun SupportFragment.dimen(
        @DimenRes dimenRes: Int,
        dimension: DimensionType = DimensionType.PX
): ReadOnlyProperty<SupportFragment, Float> = requiredDimen(contextProvider, dimenRes, dimension)

fun SupportFragment.dimenOptional(
        @DimenRes dimenRes: Int,
        dimension: DimensionType = DimensionType.PX
): ReadOnlyProperty<SupportFragment, Float?> = optionalDimen(contextProvider, dimenRes, dimension)

fun SupportFragment.dimens(
        @DimenRes vararg dimenRes: Int,
        dimension: DimensionType = DimensionType.PX
): ReadOnlyProperty<SupportFragment, List<Float>> = requiredDimens(contextProvider, dimenRes, dimension)

fun SupportFragment.dimensOptional(
        @DimenRes vararg dimenRes: Int,
        dimension: DimensionType = DimensionType.PX
): ReadOnlyProperty<SupportFragment, List<Float?>> = optionalDimens(contextProvider, dimenRes, dimension)
