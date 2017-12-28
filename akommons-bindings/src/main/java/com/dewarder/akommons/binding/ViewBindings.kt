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

package com.dewarder.akommons.binding

import android.app.Activity
import android.app.Dialog
import android.app.Fragment
import android.support.annotation.IdRes
import android.support.annotation.RestrictTo
import android.view.View
import com.dewarder.akommons.binding.util.defaultViewAbsence
import com.dewarder.akommons.binding.util.defaultViewsAbsence
import com.dewarder.akommons.binding.util.genericViewFinder
import com.dewarder.akommons.binding.util.viewProvider
import com.dewarder.akommons.util.Required
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

//=============================
//      View
//=============================

/**
 * Binds view with specified `id` into read-only property of View or throws exception
 *
 *     val myView: TextView by view(R.id.my_view)
 *
 * @throws IllegalStateException if view isn't found
 * @throws ClassCastException if view can't be casted to specified class
 */
fun <V : View> View.view(@IdRes id: Int): ReadOnlyProperty<View, V>
        = requiredView(this, this::viewProvider, id)


/**
 * Binds view with specified `id` or null into nullable read-only property of View
 *
 *     val myView: TextView? by viewOptional(R.id.my_view)
 *
 * @throws ClassCastException if view can't be casted to specified class
 */
fun <V : View> View.viewOptional(@IdRes id: Int): ReadOnlyProperty<View, V?>
        = optionalView(this::viewProvider, id)

/**
 * Binds views with specified `id` into read-only property of View or throws exception
 *
 *     val myViews: List<TextView> by views(R.id.my_view1, R.id.my_view2)
 *
 * @throws IllegalStateException if view isn't found
 * @throws ClassCastException if one or more view can't be casted to specified class
 */
fun <V : View> View.views(vararg @IdRes ids: Int): ReadOnlyProperty<View, List<V>>
        = requiredViews(this, this::viewProvider, ids)

/**
 * Binds views with specified `id` or null into read-only property of View.
 * List is always non-null but can contain nulls if view isn't found.
 *
 *     val myViews: List<TextView?> by views(R.id.my_view1, R.id.my_view2)
 *
 * @throws ClassCastException if one or more view can't be casted to specified class
 */
fun <V : View> View.viewsOptional(vararg @IdRes ids: Int): ReadOnlyProperty<View, List<V?>>
        = optionalViews(this::viewProvider, ids)


//=============================
//      Activity
//=============================

/**
 * Binds view with specified `id` into read-only property of Activity or throws exception
 *
 *     val myView: TextView by view(R.id.my_view)
 *
 * @throws IllegalStateException if view isn't found
 * @throws ClassCastException if view can't be casted to specified class
 */
fun <V : View> Activity.view(@IdRes id: Int): ReadOnlyProperty<Activity, V>
        = requiredView(this, this::viewProvider, id)

/**
 * Binds view with specified `id` or null into nullable read-only property of Activity
 *
 *     val myView: TextView? by viewOptional(R.id.my_view)
 *
 * @throws ClassCastException if view can't be casted to specified class
 */
fun <V : View> Activity.viewOptional(@IdRes id: Int): ReadOnlyProperty<Activity, V?>
        = optionalView(this::viewProvider, id)

/**
 * Binds views with specified `id` into read-only property of Activity or throws exception
 *
 *     val myViews: List<TextView> by views(R.id.my_view1, R.id.my_view2)
 *
 * @throws IllegalStateException if view isn't found
 * @throws ClassCastException if one or more view can't be casted to specified class
 */
fun <V : View> Activity.views(vararg @IdRes ids: Int): ReadOnlyProperty<Activity, List<V>>
        = requiredViews(this, this::viewProvider, ids)

/**
 * Binds views with specified `id` or null into read-only property of Activity.
 * List is always non-null but can contain nulls if view isn't found.
 *
 *     val myViews: List<TextView?> by views(R.id.my_view1, R.id.my_view2)
 *
 * @throws ClassCastException if one or more view can't be casted to specified class
 */
fun <V : View> Activity.viewsOptional(vararg @IdRes ids: Int): ReadOnlyProperty<Activity, List<V?>>
        = optionalViews(this::viewProvider, ids)


//=============================
//      Fragment
//=============================

/**
 * Binds view with specified `id` into read-only property of Fragment or throws exception
 *
 *     val myView: TextView by view(R.id.my_view)
 *
 * @throws IllegalStateException if view isn't found
 * @throws ClassCastException if view can't be casted to specified class
 */
fun <V : View> Fragment.view(@IdRes id: Int): ReadOnlyProperty<Fragment, V>
        = requiredView(this, this::viewProvider, id)


/**
 * Binds view with specified `id` or null into nullable read-only property of Fragment
 *
 *     val myView: TextView? by viewOptional(R.id.my_view)
 *
 * @throws ClassCastException if view can't be casted to specified class
 */
fun <V : View> Fragment.viewOptional(@IdRes id: Int): ReadOnlyProperty<Fragment, V?>
        = optionalView(this::viewProvider, id)

/**
 * Binds views with specified `id` into read-only property of Fragment or throws exception
 *
 *     val myViews: List<TextView> by views(R.id.my_view1, R.id.my_view2)
 *
 * @throws IllegalStateException if view isn't found
 * @throws ClassCastException if one or more view can't be casted to specified class
 */
fun <V : View> Fragment.views(vararg @IdRes ids: Int): ReadOnlyProperty<Fragment, List<V>>
        = requiredViews(this, this::viewProvider, ids)

/**
 * Binds views with specified `id` or null into read-only property of Fragment.
 * List is always non-null but can contain nulls if view isn't found.
 *
 *     val myViews: List<TextView?> by views(R.id.my_view1, R.id.my_view2)
 *
 * @throws ClassCastException if one or more view can't be casted to specified class
 */
fun <V : View> Fragment.viewsOptional(vararg @IdRes ids: Int): ReadOnlyProperty<Fragment, List<V?>>
        = optionalViews(this::viewProvider, ids)


//=============================
//      Dialog
//=============================
/**
 * Binds view with specified `id` into read-only property of Dialog or throws exception
 *
 *     val myView: TextView by view(R.id.my_view)
 *
 * @throws IllegalStateException if view isn't found
 * @throws ClassCastException if view can't be casted to specified class
 */
fun <V : View> Dialog.view(@IdRes id: Int): ReadOnlyProperty<Dialog, V>
        = requiredView(this, this::viewProvider, id)

/**
 * Binds view with specified `id` or null into nullable read-only property of Dialog
 *
 *     val myView: TextView? by viewOptional(R.id.my_view)
 *
 * @throws ClassCastException if view can't be casted to specified class
 */
fun <V : View> Dialog.viewOptional(@IdRes id: Int): ReadOnlyProperty<Dialog, V?>
        = optionalView(this::viewProvider, id)

/**
 * Binds views with specified `id` into read-only property of Dialog or throws exception
 *
 *     val myViews: List<TextView> by views(R.id.my_view1, R.id.my_view2)
 *
 * @throws IllegalStateException if view isn't found
 * @throws ClassCastException if one or more view can't be casted to specified class
 */
fun <V : View> Dialog.views(vararg @IdRes ids: Int): ReadOnlyProperty<Dialog, List<V>>
        = requiredViews(this, this::viewProvider, ids)

/**
 * Binds views with specified `id` or null into read-only property of Dialog.
 * List is always non-null but can contain nulls if view isn't found.
 *
 *     val myViews: List<TextView?> by views(R.id.my_view1, R.id.my_view2)
 *
 * @throws ClassCastException if one or more view can't be casted to specified class
 */
fun <V : View> Dialog.viewsOptional(vararg @IdRes ids: Int): ReadOnlyProperty<Dialog, List<V?>>
        = optionalViews(this::viewProvider, ids)


//=============================
//      ViewFinderProvider
//=============================

/**
 * Binds view with specified `id` into read-only property of ViewFinderProvider or throws exception
 *
 *     val myView: TextView by view(R.id.my_view)
 *
 * @throws IllegalStateException if view isn't found
 * @throws ClassCastException if view can't be casted to specified class
 */
fun <V : View> ViewFinderProvider.view(@IdRes id: Int): ReadOnlyProperty<ViewFinderProvider, V>
        = requiredView(this, this::genericViewFinder, id)

/**
 * Binds view with specified `id` or null into nullable read-only property of ViewFinderProvider
 *
 *     val myView: TextView? by viewOptional(R.id.my_view)
 *
 * @throws ClassCastException if view can't be casted to specified class
 */
fun <V : View> ViewFinderProvider.viewOptional(@IdRes id: Int): ReadOnlyProperty<ViewFinderProvider, V?>
        = optionalView(this::genericViewFinder, id)

/**
 * Binds views with specified `id` into read-only property of ViewFinderProvider or throws exception
 *
 *     val myViews: List<TextView> by views(R.id.my_view1, R.id.my_view2)
 *
 * @throws IllegalStateException if view isn't found
 * @throws ClassCastException if one or more view can't be casted to specified class
 */
fun <V : View> ViewFinderProvider.views(vararg @IdRes ids: Int): ReadOnlyProperty<ViewFinderProvider, List<V>>
        = requiredViews(this, this::genericViewFinder, ids)

/**
 * Binds views with specified `id` or null into read-only property of ViewFinderProvider.
 * List is always non-null but can contain nulls if view isn't found.
 *
 *     val myViews: List<TextView?> by views(R.id.my_view1, R.id.my_view2)
 *
 * @throws ClassCastException if one or more view can't be casted to specified class
 */
fun <V : View> ViewFinderProvider.viewsOptional(vararg @IdRes ids: Int): ReadOnlyProperty<ViewFinderProvider, List<V?>>
        = optionalViews(this::genericViewFinder, ids)


@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
inline fun <V : View> requiredView(component: Any,
                                   crossinline finder: (KProperty<*>) -> ViewFinder<V>,
                                   @IdRes id: Int): ReadOnlyProperty<Any, V> {

    return Required { property -> finder(property).invoke(id) ?: defaultViewAbsence(component, id, property) }
}

@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
inline fun <V : View> optionalView(crossinline finder: (KProperty<*>) -> ViewFinder<V>,
                                   @IdRes id: Int): ReadOnlyProperty<Any, V?> {

    return Required { property -> finder(property).invoke(id) }
}

@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
inline fun <V : View> requiredViews(component: Any,
                                    crossinline finder: (KProperty<*>) -> ViewFinder<V>,
                                    @IdRes ids: IntArray): ReadOnlyProperty<Any, List<V>> {

    return Required { property ->
        val viewProvider = finder(property)
        ids.map { id -> viewProvider.invoke(id) ?: findAbsentViewsAndThrow(component, viewProvider, ids, property) }
    }
}

@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
inline fun <V : View> optionalViews(crossinline finder: (KProperty<*>) -> ViewFinder<V>,
                                    @IdRes ids: IntArray): ReadOnlyProperty<Any, List<V?>> {
    return Required { property ->
        val viewProvider = finder(property)
        ids.map { id -> viewProvider.invoke(id) }
    }
}

@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
inline fun findAbsentViewsAndThrow(component: Any,
                                   viewFinder: ViewFinder<View>,
                                   ids: IntArray,
                                   property: KProperty<*>): Nothing {

    val absentIds = ids.filter { id -> viewFinder.invoke(id) == null }
    defaultViewsAbsence(component, absentIds, property)
}