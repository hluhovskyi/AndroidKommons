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

import android.support.annotation.ColorRes
import com.dewarder.akommons.binding.optionalColor
import com.dewarder.akommons.binding.optionalColors
import com.dewarder.akommons.binding.requiredColor
import com.dewarder.akommons.binding.requiredColors
import kotlin.properties.ReadOnlyProperty
import android.support.v4.app.Fragment as SupportFragment


/**
 * SupportFragment
 */
fun SupportFragment.color(@ColorRes colorRes: Int): ReadOnlyProperty<SupportFragment, Int>
        = requiredColor(contextProvider, colorRes)

fun SupportFragment.colorOptional(@ColorRes colorRes: Int): ReadOnlyProperty<SupportFragment, Int?>
        = optionalColor(contextProvider, colorRes)

fun SupportFragment.colors(@ColorRes vararg colorRes: Int): ReadOnlyProperty<SupportFragment, List<Int>>
        = requiredColors(contextProvider, colorRes)

fun SupportFragment.colorsOptional(@ColorRes vararg colorRes: Int): ReadOnlyProperty<SupportFragment, List<Int?>>
        = optionalColors(contextProvider, colorRes)