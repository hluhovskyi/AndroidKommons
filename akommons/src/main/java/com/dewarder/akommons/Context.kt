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

package com.dewarder.akommons

import android.Manifest
import android.accounts.AccountManager
import android.animation.Animator
import android.animation.AnimatorInflater
import android.app.*
import android.app.admin.DevicePolicyManager
import android.app.job.JobScheduler
import android.appwidget.AppWidgetManager
import android.bluetooth.BluetoothManager
import android.content.*
import android.content.pm.LauncherApps
import android.content.pm.PackageManager
import android.content.res.ColorStateList
import android.content.res.Configuration
import android.graphics.drawable.Drawable
import android.hardware.ConsumerIrManager
import android.hardware.SensorManager
import android.hardware.camera2.CameraManager
import android.hardware.display.DisplayManager
import android.hardware.input.InputManager
import android.hardware.usb.UsbManager
import android.location.LocationManager
import android.media.AudioManager
import android.media.MediaRouter
import android.media.projection.MediaProjectionManager
import android.media.session.MediaSessionManager
import android.media.tv.TvInputManager
import android.net.ConnectivityManager
import android.net.Uri
import android.net.nsd.NsdManager
import android.net.wifi.WifiManager
import android.net.wifi.p2p.WifiP2pManager
import android.nfc.NfcManager
import android.os.*
import android.os.storage.StorageManager
import android.preference.PreferenceManager
import android.print.PrintManager
import android.support.annotation.*
import android.support.v4.content.ContextCompat
import android.telecom.TelecomManager
import android.telephony.TelephonyManager
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.view.accessibility.AccessibilityManager
import android.view.accessibility.CaptioningManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.inputmethod.InputMethodManager
import android.view.textservice.TextServicesManager
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
 * Services
 */
@Suppress("unchecked_cast")
fun <T> Context.getService(name: String): T
    = getSystemService(name) as T

val Context.accessibilityManager: AccessibilityManager
    get() = getService(Context.ACCESSIBILITY_SERVICE)

val Context.accountManager: AccountManager
    get() = getService(Context.ACCOUNT_SERVICE)

val Context.activityManager: ActivityManager
    get() = getService(Context.ACTIVITY_SERVICE)

val Context.alarmManager: AlarmManager
    get() = getService(Context.ALARM_SERVICE)

@get:RequiresApi(Build.VERSION_CODES.LOLLIPOP)
val Context.appWidgetManager: AppWidgetManager
    get() = getService(Context.APPWIDGET_SERVICE)

@get:RequiresApi(Build.VERSION_CODES.KITKAT)
val Context.appOpsManager: AppOpsManager
    get() = getService(Context.APP_OPS_SERVICE)

val Context.audioManager: AudioManager
    get() = getService(Context.AUDIO_SERVICE)

@get:RequiresApi(Build.VERSION_CODES.LOLLIPOP)
val Context.batteryManager: BatteryManager
    get() = getService(Context.BATTERY_SERVICE)

@get:RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
val Context.bluetoothManager: BluetoothManager
    get() = getService(Context.BLUETOOTH_SERVICE)

@get:RequiresApi(Build.VERSION_CODES.LOLLIPOP)
val Context.cameraManager: CameraManager
    get() = getService(Context.CAMERA_SERVICE)

@get:RequiresApi(Build.VERSION_CODES.KITKAT)
val Context.captioningManager: CaptioningManager
    get() = getService(Context.CAPTIONING_SERVICE)

val Context.clipboardManager: ClipboardManager
    get() = getService(Context.CLIPBOARD_SERVICE)

val Context.connectivityManager: ConnectivityManager
    get() = getService(Context.CONNECTIVITY_SERVICE)

@get:RequiresApi(Build.VERSION_CODES.KITKAT)
val Context.consumerIrManager: ConsumerIrManager
    get() = getService(Context.CONSUMER_IR_SERVICE)

val Context.devicePolicyManager: DevicePolicyManager
    get() = getService(Context.DEVICE_POLICY_SERVICE)

@get:RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
val Context.displayManager: DisplayManager
    get() = getService(Context.DISPLAY_SERVICE)

val Context.downloadManager: DownloadManager
    get() = getService(Context.DOWNLOAD_SERVICE)

val Context.dropBoxManager: DropBoxManager
    get() = getService(Context.DROPBOX_SERVICE)

val Context.inputMethodManager: InputMethodManager
    get() = getService(Context.INPUT_METHOD_SERVICE)

@get:RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
val Context.inputManager: InputManager
    get() = getService(Context.INPUT_SERVICE)

@get:RequiresApi(Build.VERSION_CODES.LOLLIPOP)
val Context.jobScheduler: JobScheduler
    get() = getService(Context.JOB_SCHEDULER_SERVICE)

val Context.keyguardManager: KeyguardManager
    get() = getService(Context.KEYGUARD_SERVICE)

@get:RequiresApi(Build.VERSION_CODES.LOLLIPOP)
val Context.launcherApps: LauncherApps
    get() = getService(Context.LAUNCHER_APPS_SERVICE)

val Context.layoutInflater: LayoutInflater
    get() = getService(Context.LAYOUT_INFLATER_SERVICE)

val Context.locationManager: LocationManager
    get() = getService(Context.LOCATION_SERVICE)

@get:RequiresApi(Build.VERSION_CODES.LOLLIPOP)
val Context.mediaProjectionManager: MediaProjectionManager
    get() = getService(Context.MEDIA_PROJECTION_SERVICE)

@get:RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
val Context.mediaRouter: MediaRouter
    get() = getService(Context.MEDIA_ROUTER_SERVICE)

@get:RequiresApi(Build.VERSION_CODES.LOLLIPOP)
val Context.mediaSessionManager: MediaSessionManager
    get() = getService(Context.MEDIA_SESSION_SERVICE)

val Context.nfcManager: NfcManager
    get() = getService(Context.NFC_SERVICE)

val Context.notificationManager: NotificationManager
    get() = getService(Context.NOTIFICATION_SERVICE)

@get:RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
val Context.nsdManager: NsdManager
    get() = getService(Context.NSD_SERVICE)

val Context.powerManager: PowerManager
    get() = getService(Context.POWER_SERVICE)

@get:RequiresApi(Build.VERSION_CODES.KITKAT)
val Context.printManager: PrintManager
    get() = getService(Context.PRINT_SERVICE)

@get:RequiresApi(Build.VERSION_CODES.LOLLIPOP)
val Context.restrictionsManager: RestrictionsManager
    get() = getService(Context.RESTRICTIONS_SERVICE)

val Context.searchManager: SearchManager
    get() = getService(Context.SEARCH_SERVICE)

val Context.sensorManager: SensorManager
    get() = getService(Context.SENSOR_SERVICE)

val Context.storageManager: StorageManager
    get() = getService(Context.STORAGE_SERVICE)

@get:RequiresApi(Build.VERSION_CODES.LOLLIPOP)
val Context.telecomManager: TelecomManager
    get() = getService(Context.TELECOM_SERVICE)

val Context.telephonyManager: TelephonyManager
    get() = getService(Context.TELEPHONY_SERVICE)

val Context.textServicesManager: TextServicesManager
    get() = getService(Context.TEXT_SERVICES_MANAGER_SERVICE)

@get:RequiresApi(Build.VERSION_CODES.LOLLIPOP)
val Context.tvInputManager: TvInputManager
    get() = getService(Context.TV_INPUT_SERVICE)

val Context.uiModeManager: UiModeManager
    get() = getService(Context.UI_MODE_SERVICE)

val Context.usbManager: UsbManager
    get() = getService(Context.USB_SERVICE)

@get:RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
val Context.userManager: UserManager
    get() = getService(Context.USER_SERVICE)

val Context.vibrator: Vibrator
    get() = getService(Context.VIBRATOR_SERVICE)

val Context.wallpaperManager: WallpaperManager
    get() = getService(Context.WALLPAPER_SERVICE)

val Context.wifiP2pManager: WifiP2pManager
    get() = getService(Context.WIFI_P2P_SERVICE)

val Context.wifiManager: WifiManager
    get() = getService(Context.WIFI_SERVICE)

val Context.windowManager: WindowManager
    get() = getService(Context.WINDOW_SERVICE)

val Context.defaultSharedPreferences: SharedPreferences
    get() = PreferenceManager.getDefaultSharedPreferences(this)

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
 * Permissions
 */
fun Context.isPermissionsGranted(vararg permissions: Permission): Boolean =
    isPreLollipop() || permissions.all { permission ->
        ContextCompat.checkSelfPermission(this, permission.value) == PackageManager.PERMISSION_GRANTED
    }

fun Context.isPermissionsGranted(vararg permissions: String): Boolean =
    isPreLollipop() || permissions.all { rawPermission ->
        ContextCompat.checkSelfPermission(this, rawPermission) == PackageManager.PERMISSION_GRANTED
    }

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

fun Context.convertToDp(pixels: Int): Int {
    return (pixels * resources.displayMetrics.density).toInt()
}

fun Context.convertToSp(pixels: Int): Int {
    return (pixels * resources.displayMetrics.scaledDensity).toInt()
}

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