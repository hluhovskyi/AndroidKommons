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

@file:JvmName("SeekBarUtils")

package com.dewarder.akommons

import android.widget.SeekBar
import com.dewarder.akommons.adapters.SimpleSeekBarChangeListener

inline fun SeekBar.setOnProgressChangedListener(
    crossinline listener: (progress: Int, fromUser: Boolean) -> Unit
) {
    setOnSeekBarChangeListener(object : SimpleSeekBarChangeListener() {
        override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) = listener(progress, fromUser)
    })
}

inline fun SeekBar.setOnStartTrackingTouch(crossinline listener: () -> Unit) {
    setOnSeekBarChangeListener(object : SimpleSeekBarChangeListener() {
        override fun onStartTrackingTouch(seekBar: SeekBar) = listener()
    })
}

inline fun SeekBar.setOnStopTrackingTouch(crossinline listener: () -> Unit) {
    setOnSeekBarChangeListener(object : SimpleSeekBarChangeListener() {
        override fun onStopTrackingTouch(seekBar: SeekBar) = listener()
    })
}