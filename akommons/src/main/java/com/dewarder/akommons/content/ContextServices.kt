package com.dewarder.akommons.content

import android.accounts.AccountManager
import android.app.*
import android.app.admin.DevicePolicyManager
import android.app.job.JobScheduler
import android.appwidget.AppWidgetManager
import android.bluetooth.BluetoothManager
import android.content.ClipboardManager
import android.content.Context
import android.content.RestrictionsManager
import android.content.SharedPreferences
import android.content.pm.LauncherApps
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
import android.net.nsd.NsdManager
import android.net.wifi.WifiManager
import android.net.wifi.p2p.WifiP2pManager
import android.nfc.NfcManager
import android.os.*
import android.os.storage.StorageManager
import android.preference.PreferenceManager
import android.print.PrintManager
import android.support.annotation.RequiresApi
import android.telecom.TelecomManager
import android.telephony.TelephonyManager
import android.view.LayoutInflater
import android.view.WindowManager
import android.view.accessibility.AccessibilityManager
import android.view.accessibility.CaptioningManager
import android.view.inputmethod.InputMethodManager
import android.view.textservice.TextServicesManager


@Suppress("unchecked_cast")
fun <T> Context.getService(name: String): T = getSystemService(name) as T

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