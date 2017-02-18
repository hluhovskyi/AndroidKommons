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

@file:JvmName("ContextUtils")

package com.dewarder.akommons

import android.accounts.AccountManager
import android.animation.Animator
import android.animation.AnimatorInflater
import android.annotation.TargetApi
import android.app.*
import android.app.admin.DevicePolicyManager
import android.app.job.JobScheduler
import android.appwidget.AppWidgetManager
import android.bluetooth.BluetoothManager
import android.content.*
import android.content.pm.LauncherApps
import android.content.pm.PackageManager
import android.content.res.ColorStateList
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
inline fun <reified T : Any> Context.intentFor(action: String? = null,
                                               flags: Int = -1,
                                               noinline init: (Intent.() -> Unit)? = null): Intent {
    val intent = Intent(this, T::class.java)
    if (action != null) {
        intent.action = action
    }
    if (flags != -1) {
        intent.flags = flags
    }
    if (init != null) {
        init(intent)
    }
    return intent
}

inline fun <reified T : Activity> Context.startActivity(action: String? = null,
                                                        flags: Int = -1,
                                                        noinline init: (Intent.() -> Unit)? = null) {
    startActivity(intentFor<T>(action, flags, init))
}

fun Context.openLink(url: String) {
    openLink(Uri.parse(url))
}

fun Context.openLink(uri: Uri) {
    startActivity(Intent(Intent.ACTION_VIEW, uri))
}

inline fun <reified T : Service> Context.startService(action: String? = null,
                                                      noinline init: (Intent.() -> Unit)? = null) {

    startService(intentFor<T>(action = action, init = init))
}

/**
 * Services
 */
@Suppress("unchecked_cast")
fun <T> Context.getService(name: String): T {
    return getSystemService(name) as T
}

val Context.accessibilityManager: AccessibilityManager
    get() = getService(Context.ACCESSIBILITY_SERVICE)

val Context.accountManager: AccountManager
    get() = getService(Context.ACCOUNT_SERVICE)

val Context.activityManager: ActivityManager
    get() = getService(Context.ACTIVITY_SERVICE)

val Context.alarmManager: AlarmManager
    get() = getService(Context.ALARM_SERVICE)

val Context.appWidgetManager: AppWidgetManager
    get() = getService(Context.APPWIDGET_SERVICE)

val Context.appOpsManager: AppOpsManager
    get() = getService(Context.APP_OPS_SERVICE)

val Context.audioManager: AudioManager
    get() = getService(Context.AUDIO_SERVICE)

val Context.batteryManager: BatteryManager
    get() = getService(Context.BATTERY_SERVICE)

val Context.bluetoothManager: BluetoothManager
    get() = getService(Context.BLUETOOTH_SERVICE)

val Context.cameraManager: CameraManager
    get() = getService(Context.CAMERA_SERVICE)

val Context.captioningManager: CaptioningManager
    get() = getService(Context.CAPTIONING_SERVICE)

val Context.clipboardManager: ClipboardManager
    get() = getService(Context.CLIPBOARD_SERVICE)

val Context.connectivityManager: ConnectivityManager
    get() = getService(Context.CONNECTIVITY_SERVICE)

val Context.consumerIrManager: ConsumerIrManager
    get() = getService(Context.CONSUMER_IR_SERVICE)

val Context.devicePolicyManager: DevicePolicyManager
    get() = getService(Context.DEVICE_POLICY_SERVICE)

val Context.displayManager: DisplayManager
    get() = getService(Context.DISPLAY_SERVICE)

val Context.downloadManager: DownloadManager
    get() = getService(Context.DOWNLOAD_SERVICE)

val Context.dropBoxManager: DropBoxManager
    get() = getService(Context.DROPBOX_SERVICE)

val Context.inputMethodManager: InputMethodManager
    get() = getService(Context.INPUT_METHOD_SERVICE)

val Context.inputManager: InputManager
    get() = getService(Context.INPUT_SERVICE)

val Context.jobScheduler: JobScheduler
    get() = getService(Context.JOB_SCHEDULER_SERVICE)

val Context.keyguardManager: KeyguardManager
    get() = getService(Context.KEYGUARD_SERVICE)

val Context.launcherApps: LauncherApps
    get() = getService(Context.LAUNCHER_APPS_SERVICE)

val Context.layoutInflater: LayoutInflater
    get() = getService(Context.LAYOUT_INFLATER_SERVICE)

val Context.locationManager: LocationManager
    get() = getService(Context.LOCATION_SERVICE)

val Context.mediaProjectionManager: MediaProjectionManager
    get() = getService(Context.MEDIA_PROJECTION_SERVICE)

val Context.mediaRouter: MediaRouter
    get() = getService(Context.MEDIA_ROUTER_SERVICE)

val Context.mediaSessionManager: MediaSessionManager
    get() = getService(Context.MEDIA_SESSION_SERVICE)

val Context.nfcManager: NfcManager
    get() = getService(Context.NFC_SERVICE)

val Context.notificationManager: NotificationManager
    get() = getService(Context.NOTIFICATION_SERVICE)

val Context.nsdManager: NsdManager
    get() = getService(Context.NSD_SERVICE)

val Context.powerManager: PowerManager
    get() = getService(Context.POWER_SERVICE)

val Context.printManager: PrintManager
    get() = getService(Context.PRINT_SERVICE)

val Context.restrictionsManager: RestrictionsManager
    get() = getService(Context.RESTRICTIONS_SERVICE)

val Context.searchManager: SearchManager
    get() = getService(Context.SEARCH_SERVICE)

val Context.sensorManager: SensorManager
    get() = getService(Context.SENSOR_SERVICE)

val Context.storageManager: StorageManager
    get() = getService(Context.STORAGE_SERVICE)

val Context.telecomManager: TelecomManager
    get() = getService(Context.TELECOM_SERVICE)

val Context.telephonyManager: TelephonyManager
    get() = getService(Context.TELEPHONY_SERVICE)

val Context.textServicesManager: TextServicesManager
    get() = getService(Context.TEXT_SERVICES_MANAGER_SERVICE)

val Context.tvInputManager: TvInputManager
    get() = getService(Context.TV_INPUT_SERVICE)

val Context.uiModeManager: UiModeManager
    get() = getService(Context.UI_MODE_SERVICE)

val Context.usbManager: UsbManager
    get() = getService(Context.USB_SERVICE)

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
 * Animations
 */
fun Context.getAnimation(@AnimRes id: Int): Animation {
    return AnimationUtils.loadAnimation(this, id)
}

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
fun Context.getAnimator(@AnimatorRes id: Int): Animator {
    return AnimatorInflater.loadAnimator(this, id)
}

/**
 * ContextCompat
 */
fun Context.getThemedColor(@ColorRes resId: Int): Int {
    return ContextCompat.getColor(this, resId)
}

fun Context.getThemedColorStateList(@ColorRes resId: Int): ColorStateList {
    return ContextCompat.getColorStateList(this, resId)
}

fun Context.getThemedDrawable(@DrawableRes resId: Int): Drawable {
    return ContextCompat.getDrawable(this, resId)
}

/**
 * Permissions
 */
fun Context.isPermissionsGranted(vararg permissions: Permission): Boolean {
    return isPreLollipop() || permissions.all { permission ->
        ContextCompat.checkSelfPermission(this, permission.value) == PackageManager.PERMISSION_GRANTED
    }
}

fun Context.isPermissionsGranted(vararg permissions: String): Boolean {
    return isPreLollipop() || permissions.all { rawPermission ->
        ContextCompat.checkSelfPermission(this, rawPermission) == PackageManager.PERMISSION_GRANTED
    }
}

/**
 * Other
 */
fun Context.convertToDp(pixels: Int): Int {
    return (pixels * resources.displayMetrics.density).toInt()
}

fun Context.convertToSp(pixels: Int): Int {
    return (pixels * resources.displayMetrics.scaledDensity).toInt()
}

fun Context.isNetworkAvailable(): Boolean {
    val networkInfo = connectivityManager.activeNetworkInfo
    return networkInfo?.isConnectedOrConnecting ?: false
}

fun Context.isWifiNetworkAvailable(): Boolean {
    val networkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
    return networkInfo?.isConnectedOrConnecting ?: false
}

fun Context.isPackageInstalled(packageName: String): Boolean = try {
    packageManager.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
    true
} catch (e: PackageManager.NameNotFoundException) {
    false
}