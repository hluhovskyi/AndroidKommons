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

@file:JvmName("ActivityUtils")

package com.dewarder.akommons.app

import android.app.Activity
import android.content.Intent
import android.support.annotation.IdRes
import android.view.View
import android.view.ViewGroup
import com.dewarder.akommons.content.intentFor

/**
 * Shortcut for retrieving root view of Activity
 *
 * @return root view of Activity
 */
public val Activity.rootView: ViewGroup
    get() = findViewById(android.R.id.content)

/**
 * Finds view and apply init block to it.
 *
 * @param id - identifier of [View]
 * @param init - block that applies to found view
 * @return [View] with appropriate type and with applied init block
 */
public inline fun <V : View> Activity.findView(
    @IdRes id: Int,
    init: V.() -> Unit
): V = findViewById<V>(id).apply(init)

/**
 * Starts another Activity for result from receiver Activity.
 * Benefits over standard way that you don't need to build intent manually.
 *
 * @param requestCode code that will be returned in [Activity.onActivityResult] after Activity exits.
 * @param action - value passed as [Intent.setAction]
 * @param flags - value passed as [Intent.setFlags]
 */
public inline fun <reified T : Activity> Activity.startActivityForResult(
    requestCode: Int,
    action: String? = null,
    flags: Int = -1
) {
    startActivityForResult(intentFor<T>(action, flags), requestCode)
}

/**
 * Starts another Activity for result from receiver Activity.
 * Allows to preset data to [Intent] which will fire Activity.
 * Benefits over standard way that you don't need to build intent manually and
 * you have same flexibility as working with [Intent]
 *
 * @param requestCode code that will be returned in [Activity.onActivityResult] after Activity exits.
 * @param action - value passed as [Intent.setAction]
 * @param flags - value passed as [Intent.setFlags]
 * @param init - block which will be applied to firing [Intent]
 */
public inline fun <reified T : Activity> Activity.startActivityForResult(
    requestCode: Int,
    action: String? = null,
    flags: Int = -1,
    init: Intent.() -> Unit
) {
    startActivityForResult(intentFor<T>(action, flags, init), requestCode)
}