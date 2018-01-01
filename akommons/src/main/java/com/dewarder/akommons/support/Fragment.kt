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

@file:[JvmName("SupportFragmentUtils") Suppress("unused")]

package com.dewarder.akommons.support

import android.app.Activity
import android.app.Service
import android.content.ComponentName
import android.content.Intent
import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import com.dewarder.akommons.*


/**
 * Intents
 */
inline fun <reified T : Any> Fragment.intentFor(
    action: String? = null,
    flags: Int = -1
): Intent = context.intentFor<T>(action, flags)

inline fun <reified T : Any> Fragment.intentFor(
    action: String? = null,
    flags: Int = -1,
    init: Intent.() -> Unit
): Intent = intentFor<T>(action, flags).apply(init)

inline fun <reified T : Activity> Fragment.startActivity(
    action: String? = null,
    flags: Int = -1
) = startActivity(intentFor<T>(action, flags))

inline fun <reified T : Activity> Fragment.startActivity(
    action: String? = null,
    flags: Int = -1,
    init: Intent.() -> Unit
) = startActivity(intentFor<T>(action, flags).apply(init))

inline fun <reified T : Service> Fragment.startService(
    action: String? = null
): ComponentName = context.startService(intentFor<T>(action))

inline fun <reified T : Service> Fragment.startService(
    action: String? = null,
    init: Intent.() -> Unit
): ComponentName = context.startService(intentFor<T>(action = action, init = init))


/**
 * Toasts
 */
fun Fragment.showShortToast(@StringRes resId: Int) {
    context.showShortToast(resId)
}

fun Fragment.showShortToast(text: String) {
    context.showShortToast(text)
}

fun Fragment.showLongToast(@StringRes resId: Int) {
    context.showLongToast(resId)
}

fun Fragment.showLongToast(text: String) {
    context.showLongToast(text)
}

/**
 * Permissions
 */
fun Fragment.isPermissionsGranted(vararg permissions: Permission): Boolean =
    context.isPermissionsGranted(*permissions)

fun Fragment.isPermissionsGranted(vararg permissions: String): Boolean =
    context.isPermissionsGranted(*permissions)

fun Fragment.requestPermissions(requestCode: Int, vararg permissions: Permission) {
    requestPermissions(permissions.map(Permission::value).toTypedArray(), requestCode)
}