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

@file:JvmName("TextViewUtils")

package com.dewarder.akommons.widget

import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView
import com.dewarder.akommons.widget.SimpleTextWatcher

inline fun TextView.addOnAfterTextChangedListener(
    crossinline listener: (Editable) -> Unit
): TextWatcher {
    val watcher = object : SimpleTextWatcher() {
        override fun afterTextChanged(s: Editable) = listener(s)
    }
    addTextChangedListener(watcher)
    return watcher
}

inline fun TextView.addOnBeforeTextChangedListener(
    crossinline listener: (s: CharSequence, start: Int, count: Int, after: Int) -> Unit
): TextWatcher {
    val textWatcher = object : SimpleTextWatcher() {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) =
            listener(s, start, count, after)
    }
    addTextChangedListener(textWatcher)
    return textWatcher
}

inline fun TextView.addOnTextChangedListener(
    crossinline listener: (s: CharSequence, start: Int, before: Int, count: Int) -> Unit
): TextWatcher {
    val textWatcher = object : SimpleTextWatcher() {
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            listener(s, start, before, count)
        }
    }
    addTextChangedListener(textWatcher)
    return textWatcher
}

