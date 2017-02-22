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
 *
 */

package com.dewarder.akommons.preferences

object PreferencesDelegates {

    fun int(defaultValue: Int = 0, key: String? = null)
            = IntPreferencesProperty(defaultValue, key)

    fun float(defaultValue: Float = 0f, key: String? = null)
            = FloatPreferencesProperty(defaultValue, key)

    fun string(defaultValue: String = "", key: String? = null)
            = StringPreferencesProperty(defaultValue, key)

    fun boolean(defaultValue: Boolean = false, key: String? = null)
            = BooleanPreferencesProperty(defaultValue, key)

    fun date(defaultValue: Long = 0, key: String? = null)
            = DatePreferencesProperty(defaultValue, key)

    fun calendar(defaultValue: Long = 0, key: String? = null)
            = CalendarPreferencesProperty(defaultValue, key)

    fun <T> custom(defaultValue: T, key: String? = null, mapperFrom: (String) -> T)
            = CustomPreferencesProperty<T>(defaultValue, key, mapperFrom)

    fun <T> custom(defaultValue: T, key: String? = null, mapperFrom: (String) -> T, mapperTo: (T) -> String)
            = CustomPreferencesProperty<T>(defaultValue, key, mapperFrom, mapperTo)
}