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
 *
 */

package com.dewarder.akommons.preferences

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

open class CustomPreferencesProperty<T>(
    defaultValue: T,
    private val key: String?,
    private val getMapper: (String) -> T,
    private val setMapper: (T) -> String = { it.toString() }
) : ReadWriteProperty<SharedPreferencesProvider, T> {

    private val defaultValueRaw: String = setMapper(defaultValue)

    override fun getValue(thisRef: SharedPreferencesProvider, property: KProperty<*>): T {
        val key = property.name
        return getMapper(thisRef.sharedPreferences.getString(key, defaultValueRaw))
    }

    override fun setValue(thisRef: SharedPreferencesProvider, property: KProperty<*>, value: T) {
        val key = property.name
        thisRef.sharedPreferences.save(key, setMapper(value))
    }
}