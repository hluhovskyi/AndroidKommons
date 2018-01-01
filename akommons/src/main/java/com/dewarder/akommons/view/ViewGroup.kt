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

@file:JvmName("ViewGroupUtils")

package com.dewarder.akommons.view

import android.support.annotation.LayoutRes
import android.view.View
import android.view.ViewGroup
import com.dewarder.akommons.content.inflate

val ViewGroup.views: List<View>
    get() = (0 until childCount).map(this::getChildAt)

infix operator fun ViewGroup.plusAssign(view: View) {
    addView(view)
}

infix operator fun ViewGroup.minusAssign(view: View) {
    removeView(view)
}

operator fun ViewGroup.get(index: Int): View = getChildAt(index)

fun ViewGroup.inflateInto(
    @LayoutRes layoutReId: Int,
    attachToRoot: Boolean = false
): View = context.inflate(layoutReId, this, attachToRoot)