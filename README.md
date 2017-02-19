# Android-Kotlin-Commons

Small library that contains common extensions for Android. Aims:
- Provide the shortest way to do things
- Reduce count of "Compat" and "Utils" classes
- Remove boilerplate code

## Features

### Views

##### Visibility

Before

```
override fun onCreate(savedInstanceState: Bundle) {
    ...
    firstView.visibility = View.VISIBLE
    secondView.visibility = View.GONE
    ...
}
```
After

```
override fun onCreate(savedInstanceState: Bundle) {
    ...
    firstView.isVisible = true
    secondView.isVisible = false
    ...
}
```
##### Auto-casting

Before

```
private lateinit linearLayout: LinearLayout
 
override fun onCreate(savedInstanceState: Bundle) {
    linearLayout = findViewById(R.id.linearLayout) as LinearLayout
}
```
After

```
private lateinit linearLayout: LinearLayout
 
override fun onCreate(savedInstanceState: Bundle) {
    linearLayout = getViewById(R.id.linearLayout)
}
```

#####Padding

Before
```
override fun onCreate(savedInstanceState: Bundle) {
    ...
    firstView.setPadding(firstView.paddingLeft, firstView.paddingTop, first.paddingRight, 16)
    secondView.setPadding(16, 16, 16, 16)
    ...
}
```
After
```
override fun onCreate(savedInstanceState: Bundle) {
    ...
    firstView.setOptionalPadding(bottom = 16)
    secondView.setAllPadding(16)
    ...
}
```

#####Post runnables

Before
```
override fun onCreate(savedInstanceState: Bundle) {
    ...
    refreshLayout.postDelayed({
        refreshLayout.isRefreshing = false
        refreshLayout.clearAnimation()
    }, 3000)
    ...
}
```
After
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
Also see _postApply_,  _postLet_, _postDelayedLet_

### Shared preferences

##### Delegates

Before

```
class AccountRepository {
 
    val sharedPreferences: SharedPreferences
 
    constructor(context: Context) {
        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
    }
 
    var currentUserId: Int = 0
        get() = sharedPreferences.getInt(CURRENT_USER_ID, 0)
        set(value) {
            sharedPreferences.edit().putInt(CURRENT_USER_ID, value).apply()
            field = value
        }
     
    companion object {
 
        const val CURRENT_USER_ID = "CURRENT_USER_ID"
    }
}
```

After

```
class AccountRepository : SharedPreferencesProvider {
 
    override val sharedPreferences: SharedPreferences
 
    var currentUserId by PreferencesDelegates.int()
     
    constructor(context: Context) {
        this.sharedPreferences = context.defaultSharedPreferences
    }
}
```

##### Shortcuts
Before

```
sharedPreferences.edit()
    .putInt(CURRENT_USER_ID, userId)
    .apply()
    
  ...
  
sharedPreferences.edit()
    .putString(BEARER_TOKEN, token)
    .commit()
```

After
```
sharedPreferences.save(CURRENT_USER_ID, userId)
 
    ...
    
sharedPreferences.save(BEARER_TOKEN, token, force = true)
```

### Context

##### Compat
Before
```
override fun onCreate(savedInstanceState: Bundle) {
    ...
    val color = ContextCompat.getColor(this, R.color.cyan)
    val drawable = ContextCompat.getDrawable(this, R.drawable.background)
    val stateList = ContextCompat.getColorStateList(this, R.drawable.state_list)
    ...
}
```

After
```
override fun onCreate(savedInstanceState: Bundle) {
    ...
    val color = getThemedColor(R.color.cyan)
    val drawable = getThemedDrawable(R.drawable.background)
    val stateList = getThemedColorStateList(R.drawable.state_list)
    ...
}
```

##### Services
Before
```
override fun onCreate(savedInstanceState: Bundle) {
    ...
    val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
    ...
}
```

After
```
override fun onCreate(savedInstanceState: Bundle) {
    ...
    val inflater = layoutInflater
    val sharedPreferences = defaultSharedPreferences
    ...
}
```

##### Toasts

Before
```
override fun onCreate(savedInstanceState: Bundle) {
    ...
    Toast.makeText(this, "Hi!", Toast.LENGTH_SHORT).show()
    Toast.makeText(this, R.string.hello, Toast.LENGTH_LONG).show()
    ...
}
```

After
```
override fun onCreate(savedInstanceState: Bundle) {
    ...
    showShortToast("Hi!")
    showLongToast(R.string.hello)
    ...
}
```

##### Permissions

Before
```
override fun onCreate(savedInstanceState: Bundle) {
    ...
    if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED &&
            ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
        
        ...
        
    }
    ...
}
```

After
```
override fun onCreate(savedInstanceState: Bundle) {
    ...
    if (isPermissionsGranted(Permission.WRITE_EXTERNAL_STORAGE, Permission.ACCESS_FINE_LOCATION)) {
        ...        
    }
    ...
}
```

## License

```
Copyright (C) 2017 Artem Glugovsky

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
