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

@file:JvmName("SearchViewUtils")

package com.dewarder.akommons

import android.annotation.TargetApi
import android.os.Build
import android.widget.SearchView
import com.dewarder.akommons.adapters.SimpleSearchQueryListener

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
fun SearchView.addOnQueryChangeListener(block: (String) -> Boolean) {
    setOnQueryTextListener(object : SimpleSearchQueryListener() {
        override fun onQueryTextChange(newText: String): Boolean {
            return block(newText)
        }
    })
}

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
fun SearchView.addOnQuerySubmitListener(block: (String) -> Boolean) {
    setOnQueryTextListener(object : SimpleSearchQueryListener() {
        override fun onQueryTextSubmit(query: String): Boolean {
            return block(query)
        }
    })
}