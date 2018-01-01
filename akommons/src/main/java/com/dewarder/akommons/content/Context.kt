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

@file:[Suppress("unused")]

package com.dewarder.akommons.content

import android.Manifest
import android.animation.Animator
import android.animation.AnimatorInflater
import android.app.Activity
import android.app.PendingIntent
import android.app.Service
import android.content.BroadcastReceiver
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.content.res.ColorStateList
import android.content.res.Configuration
import android.graphics.drawable.Drawable
import android.net.ConnectivityManager
import android.net.Uri
import android.os.Build
import android.support.annotation.*
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast

/**
 * Intents
 */
inline fun <reified T : Any> Context.intentFor(
    action: String? = null,
    flags: Int = -1
): Intent = Intent(this, T::class.java).apply {
    this.action = action
    this.flags = flags
}

inline fun <reified T : Any> Context.intentFor(
    action: String? = null,
    flags: Int = -1,
    init: Intent.() -> Unit
): Intent = intentFor<T>(action, flags).apply(init)


/**
 * Activities
 */
inline fun <reified T : Activity> Context.startActivity(
    action: String? = null,
    flags: Int = -1
) = startActivity(intentFor<T>(action, flags))

inline fun <reified T : Activity> Context.startActivity(
    action: String? = null,
    flags: Int = -1,
    init: Intent.() -> Unit
) = startActivity(intentFor<T>(action, flags, init))

/**
 * Services
 */
inline fun <reified T : Service> Context.startService(
    action: String? = null
): ComponentName = startService(intentFor<T>(action = action))

inline fun <reified T : Service> Context.startService(
    action: String? = null,
    init: Intent.() -> Unit
): ComponentName = startService(intentFor<T>(action = action, init = init))

fun Context.openLink(url: String) {
    openLink(Uri.parse(url))
}

fun Context.openLink(uri: Uri) {
    startActivity(Intent(Intent.ACTION_VIEW, uri))
}

/**
 * PendingIntent
 */
inline fun <reified T : Any> Context.pendingIntentFor(
    intent: Intent,
    requestCode: Int = 0,
    pendingIntentFlags: Int = 0
): PendingIntent = T::class.java.let { clazz ->
    when {
        Activity::class.java.isAssignableFrom(clazz) ->
            PendingIntent.getActivity(this, requestCode, intent, pendingIntentFlags)

        Service::class.java.isAssignableFrom(clazz) ->
            PendingIntent.getService(this, requestCode, intent, pendingIntentFlags)

        BroadcastReceiver::class.java.isAssignableFrom(clazz) ->
            PendingIntent.getBroadcast(this, requestCode, intent, pendingIntentFlags)

        else -> throw IllegalStateException("PendingIntent must be used only with Activity, Service or BroadcastReceiver")
    }
}

inline fun <reified T : Any> Context.pendingIntentFor(
    action: String? = null,
    intentFlags: Int = -1,
    requestCode: Int = 0,
    pendingIntentFlags: Int = 0
): PendingIntent = pendingIntentFor<T>(
    intent = intentFor<T>(action, intentFlags),
    requestCode = requestCode,
    pendingIntentFlags = pendingIntentFlags
)

inline fun <reified T : Any> Context.pendingIntentFor(
    action: String? = null,
    intentFlags: Int = -1,
    requestCode: Int = 0,
    pendingIntentFlags: Int = 0,
    init: Intent.() -> Unit
): PendingIntent = pendingIntentFor<T>(
    intent = intentFor<T>(action, intentFlags, init),
    requestCode = requestCode,
    pendingIntentFlags = pendingIntentFlags
)

/**
 * Toasts
 */
fun Context.showShortToast(@StringRes resId: Int) {
    Toast.makeText(this, resId, Toast.LENGTH_SHORT).show()
}

fun Context.showShortToast(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}

fun Context.showLongToast(@StringRes resId: Int) {
    Toast.makeText(this, resId, Toast.LENGTH_LONG).show()
}

fun Context.showLongToast(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_LONG).show()
}

/**
 * Resources
 */
fun Context.getAnimation(@AnimRes id: Int): Animation =
    AnimationUtils.loadAnimation(this, id)

fun Context.getAnimator(@AnimatorRes id: Int): Animator =
    AnimatorInflater.loadAnimator(this, id)

/**
 * ContextCompat
 */
fun Context.getThemedColor(@ColorRes resId: Int): Int =
    ContextCompat.getColor(this, resId)

fun Context.getThemedColorStateList(@ColorRes resId: Int): ColorStateList =
    ContextCompat.getColorStateList(this, resId)

fun Context.getThemedDrawable(@DrawableRes resId: Int): Drawable =
    ContextCompat.getDrawable(this, resId)


/**
 * Other
 */
val Context.isRtl: Boolean
    get() = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
        resources.configuration.layoutDirection == View.LAYOUT_DIRECTION_RTL
    } else {
        false
    }

val Context.isLtr: Boolean
    get() = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
        resources.configuration.layoutDirection == View.LAYOUT_DIRECTION_LTR
    } else {
        true
    }

val Context.isLandscape: Boolean
    get() = resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

val Context.isPortrait: Boolean
    get() = resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT

fun Context.convertToDp(pixels: Int): Int =
    (pixels * resources.displayMetrics.density).toInt()

fun Context.convertToSp(pixels: Int): Int =
    (pixels * resources.displayMetrics.scaledDensity).toInt()

fun Context.inflate(
    @LayoutRes layoutId: Int,
    root: ViewGroup? = null,
    attachToRoot: Boolean = false
): View = LayoutInflater.from(this).inflate(layoutId, root, attachToRoot)

fun Context.isPackageInstalled(packageName: String): Boolean = try {
    packageManager.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES)
    true
} catch (e: PackageManager.NameNotFoundException) {
    false
}

/**
 * Connections
 */
@get:RequiresPermission(Manifest.permission.ACCESS_NETWORK_STATE)
val Context.hasConnection: Boolean
    get() = connectivityManager.activeNetworkInfo?.isConnectedOrConnecting ?: false

@get:RequiresPermission(Manifest.permission.ACCESS_NETWORK_STATE)
val Context.isConnectedToWifi: Boolean
    get() = connectivityManager.activeNetworkInfo?.type == ConnectivityManager.TYPE_WIFI

@get:RequiresPermission(Manifest.permission.ACCESS_NETWORK_STATE)
inline val Context.isConnectedToMobile: Boolean
    get() = connectivityManager.activeNetworkInfo?.type == ConnectivityManager.TYPE_MOBILE