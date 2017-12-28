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

import android.support.annotation.IntegerRes
import com.dewarder.akommons.binding.optionalInteger
import com.dewarder.akommons.binding.optionalIntegers
import com.dewarder.akommons.binding.requiredInteger
import com.dewarder.akommons.binding.requiredIntegers
import kotlin.properties.ReadOnlyProperty
import android.support.v4.app.Fragment as SupportFragment


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
