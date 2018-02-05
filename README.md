# Android-Kotlin-Commons

[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-AndroidKotlinCommons-blue.svg?style=flat)](https://android-arsenal.com/details/1/5343)

Yet another library that contains common extensions for Android. Aims:
- Provide the shortest way to do things
- Reduce count of "Compat" and "Utils" classes
- Remove boilerplate code

## Getting started

Add library as dependency to your build.gradle.

```
Deployment in process

```
Probably you don't need all extensions so just copy-paste needed ones.

## What you can do

Visibility

```kotlin
override fun onCreate(savedInstanceState: Bundle) {
    ...
    firstView.isVisible = true
    secondView.isVisible = false
    ...
}
```

Views and resources bindings

```kotlin

class MyActivity : Activity() {

    
    val refreshLayout: SwipeRefreshLayout by view(R.id.swipe_refresh)
    val developersList: RecyclerView by view(R.id.recycler_view)
    
    val errorMessage by string(R.string.error_message)
    val viewBackground by bitmap(R.drawable.my_drawable)
    val viewGradientColors by colors(R.color.color_1, R.color.color_2, R.color.color_3)
    val animationDuration by int(R.integer.animation_duration)
}

```

Starting activities

```
    activity.startActivityForResult<AnotherActivity>(
        requestCode = REQUEST_CODE,
        action = AnotherActivity.ACTION_DO_SOMETHING,
        flags = Intent.FLAG_ACTIVITY_CLEAR_TASK and Intent.FLAG_ACTIVITY_CLEAR_TASK
    ) {
         putExtra( ... )
    }
```

Easy padding

```
override fun onCreate(savedInstanceState: Bundle) {
    ...
    firstView.setOptionalPadding(bottom = 16)   
    secondView.setAllPadding(16)
    ...
}
```

Post runnables

```
override fun onCreate(savedInstanceState: Bundle) {
    ...
    refreshLayout.postDelayedApply(3000) {
        isRefreshing = false
        clearAnimation()
    }
    ...
}
```

Working with database

```kotlin
val db: SQLiteDatabase
 
override fun getAllUsers() {
    ...
    val cursor = db.executeQuery(table = TABLE_USERS, orderBy = COLUMN_NAME)
    ...
    db.executeDelete(table = TABLE_USERS)
    ...
}
```

Working with preferences

```kotlin
class AccountRepository(
    override val sharedPreferences: SharedPreferences
) : SharedPreferencesProvider {
 
    var currentUserId by PreferencesDelegates.int()
    var currentUserName by string() //With import
     
    fun saveUser(id: Int, name: String) {
        this.currentUserId = id
        this.currentUserName = name
    }
}
```

## See more extensions

- Activity
- SharedPreferences
- Theme
- TypedArray
- Context
- Cursor
- SQLiteDatabase
- Bitmap
- View
- ViewGroup
- SearchView
- SeekBar
- TextView

## ...and bindings

- Activity
- View
- Fragment
- Any other class

```
Copyright (C) 2018 Artem Hluhovskyi

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
