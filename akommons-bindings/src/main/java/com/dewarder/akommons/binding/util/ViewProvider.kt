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
 */

@file:Suppress("UNCHECKED_CAST")

package com.dewarder.akommons.util

import android.app.Activity
import android.app.Dialog
import android.app.Fragment
import android.view.View
import com.dewarder.akommons.binding.ViewFinder
import com.dewarder.akommons.binding.ViewFinderProvider
import com.dewarder.akommons.binding.util.ensureFragmentView
import kotlin.reflect.KProperty
import android.support.v4.app.Fragment as SupportFragment

/**
 * Native
 */
internal fun <V : View> View.viewProvider(property: KProperty<*>): ViewFinder<V>
    = { findViewById(it) as V? }

internal fun <V : View> Activity.viewProvider(property: KProperty<*>): ViewFinder<V>
    = { findViewById(it) as V? }

internal fun <V : View> Fragment.viewProvider(property: KProperty<*>): ViewFinder<V>
    = { ensureFragmentView(this, property).findViewById(it) as V? }

internal fun <V : View> Dialog.viewProvider(property: KProperty<*>): ViewFinder<V>
    = { findViewById(it) as V? }


/**
 * Support
 */
internal fun <V : View> SupportFragment.viewProvider(property: KProperty<*>): ViewFinder<V>
    = { ensureFragmentView(this, property).findViewById(it) as V? }

/**
 * ViewFinderProvider
 */
internal fun <V : View> ViewFinderProvider.genericViewFinder(property: KProperty<*>): ViewFinder<V>
    = { provideViewFinder().invoke(it) as V? }