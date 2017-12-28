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

@file:JvmName("PreferencesUtils")

package com.dewarder.akommons.preferences

import android.annotation.TargetApi
import android.content.SharedPreferences
import android.os.Build

fun SharedPreferences.save(key: String, value: String, force: Boolean = false) {
    val editor = edit().putString(key, value)
    if (force) editor.commit() else editor.apply()
}

fun SharedPreferences.save(key: String, value: Boolean, force: Boolean = false) {
    val editor = edit().putBoolean(key, value)
    if (force) editor.commit() else editor.apply()
}

fun SharedPreferences.save(key: String, value: Int, force: Boolean = false) {
    val editor = edit().putInt(key, value)
    if (force) editor.commit() else editor.apply()
}

fun SharedPreferences.save(key: String, value: Long, force: Boolean = false) {
    val editor = edit().putLong(key, value)
    if (force) editor.commit() else editor.apply()
}

fun SharedPreferences.save(key: String, value: Float, force: Boolean = false) {
    val editor = edit().putFloat(key, value)
    if (force) editor.commit() else editor.apply()
}

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
fun SharedPreferences.save(key: String, value: Set<String>, force: Boolean = false) {
    val editor = edit().putStringSet(key, value)
    if (force) editor.commit() else editor.apply()
}
