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

@file:RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)

package com.dewarder.akommons.binding.util

import android.app.Fragment
import android.support.annotation.IdRes
import android.support.annotation.RestrictTo
import android.view.View
import kotlin.reflect.KProperty

fun defaultViewAbsence(component: Any, @IdRes id: Int, property: KProperty<*>): Nothing {
    throw IllegalStateException("${component::class.java.simpleName} doesn't contain view with id $id for property '${property.name}'")
}

fun defaultViewsAbsence(component: Any, @IdRes ids: List<Int>, property: KProperty<*>): Nothing {
    throw IllegalStateException("${component::class.java.simpleName} doesn't contain views with ids $ids for property '${property.name}'")
}

internal fun ensureFragmentView(fragment: Fragment, property: KProperty<*>): View {
    return fragment.view ?: throw IllegalStateException("Fragment hasn't view. Do you access to property '${property.name}' before 'onViewCreated'?")
}