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

package com.dewarder.akommons.util

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

abstract class LazyDelegate<R, T> : ReadOnlyProperty<R, T> {

    private object EMPTY

    private var value: Any? = EMPTY

    @Suppress("unchecked_cast")
    override fun getValue(thisRef: R, property: KProperty<*>): T {
        if (value == EMPTY) {
            value = initializeValue(thisRef, property)
        }
        return value as T
    }

    abstract fun initializeValue(ref: R, property: KProperty<*>): T
}