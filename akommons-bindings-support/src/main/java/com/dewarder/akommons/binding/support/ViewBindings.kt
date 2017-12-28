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

package com.dewarder.akommons.binding.support

import android.support.annotation.IdRes
import android.view.View
import com.dewarder.akommons.binding.*
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty
import android.support.v4.app.Fragment as SupportFragment


/**
 * Support
 */
private fun ensureFragmentView(fragment: SupportFragment, property: KProperty<*>): View {
    return fragment.view ?: throw IllegalStateException("Fragment hasn't view. Do you access to property '${property.name}' before 'onViewCreated'?")
}

private fun <V : View> SupportFragment.viewProvider(property: KProperty<*>): ViewFinder<V>
        = { ensureFragmentView(this, property).findViewById(it) as V? }

//=============================
//      SupportFragment
//=============================

/**
 * Binds view with specified `id` into read-only property of android.support.v4.app.Fragment or throws exception
 *
 *     val myView: TextView by view(R.id.my_view)
 *
 * @throws IllegalStateException if view isn't found
 * @throws ClassCastException if view can't be casted to specified class
 */
fun <V : View> SupportFragment.view(@IdRes id: Int): ReadOnlyProperty<SupportFragment, V>
        = requiredView(this, this::viewProvider, id)

/**
 * Binds view with specified `id` or null into nullable read-only property of android.support.v4.app.Fragment
 *
 *     val myView: TextView? by viewOptional(R.id.my_view)
 *
 * @throws ClassCastException if view can't be casted to specified class
 */
fun <V : View> SupportFragment.viewOptional(@IdRes id: Int): ReadOnlyProperty<SupportFragment, V?>
        = optionalView(this::viewProvider, id)

/**
 * Binds views with specified `id` into read-only property of android.support.v4.app.Fragment or throws exception
 *
 *     val myViews: List<TextView> by views(R.id.my_view1, R.id.my_view2)
 *
 * @throws IllegalStateException if view isn't found
 * @throws ClassCastException if one or more view can't be casted to specified class
 */
fun <V : View> SupportFragment.views(vararg @IdRes ids: Int): ReadOnlyProperty<SupportFragment, List<V>>
        = requiredViews(this, this::viewProvider, ids)

/**
 * Binds views with specified `id` or null into read-only property of android.support.v4.app.Fragment.
 * List is always non-null but can contain nulls if view isn't found.
 *
 *     val myViews: List<TextView?> by views(R.id.my_view1, R.id.my_view2)
 *
 * @throws ClassCastException if one or more view can't be casted to specified class
 */
fun <V : View> SupportFragment.viewsOptional(vararg @IdRes ids: Int): ReadOnlyProperty<SupportFragment, List<V?>>
        = optionalViews(this::viewProvider, ids)