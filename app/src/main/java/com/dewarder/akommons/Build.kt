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

@file:JvmName("BuildUtils")

package com.dewarder.akommons

import android.os.Build

fun isLollipop(): Boolean {
    return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP
}

fun isPreLollipop(): Boolean {
    return Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP
}

inline fun ifDebug(block: () -> Unit) {
    if (BuildConfig.DEBUG) {
        block.invoke()
    }
}

inline fun ifApi(api: Api, block: () -> Unit) {
    ifApi(api.sdkCode, block)
}

inline fun ifApi(sdkCode: Int, block: () -> Unit) {
    if (Build.VERSION.SDK_INT >= sdkCode) {
        block()
    }
}

inline fun ifNotApi(api: Api, block: () -> Unit) {
    ifNotApi(api.sdkCode, block)
}

inline fun ifNotApi(sdkCode: Int, block: () -> Unit) {
    if (Build.VERSION.SDK_INT < sdkCode) {
        block()
    }
}

