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

open class CustomPreferencesProperty<T> : ReadWriteProperty<SharedPreferencesProvider, T> {

    val defaultValue: T
    val defaultValueRaw: String
    val key: String?

    val mapperFrom: (String) -> T
    val mapperTo: (T) -> String

    constructor(defaultValue: T, key: String?, mapperTo: (String) -> T) :
            this(defaultValue, key, mapperTo, { it.toString() })

    constructor(defaultValue: T, key: String?, mapperTo: (String) -> T, mapperFrom: (T) -> String) {
        this.defaultValue = defaultValue
        this.key = key
        this.mapperFrom = mapperTo
        this.mapperTo = mapperFrom
        this.defaultValueRaw = mapperFrom(defaultValue)
    }

    override fun getValue(thisRef: SharedPreferencesProvider, property: KProperty<*>): T {
        val key = property.name
        return mapperFrom(thisRef.sharedPreferences.getString(key, defaultValueRaw))
    }

    override fun setValue(thisRef: SharedPreferencesProvider, property: KProperty<*>, value: T) {
        val key = property.name
        thisRef.sharedPreferences.save(key, mapperTo(value))
    }
}