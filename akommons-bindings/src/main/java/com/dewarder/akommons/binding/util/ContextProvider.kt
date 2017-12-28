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
 */

package com.dewarder.akommons.util

import android.app.Activity
import android.app.Dialog
import android.app.Fragment
import android.content.Context
import android.support.v4.app.Fragment as SupportFragment

/**
 * Native
 */
internal val android.view.View.contextProvider: () -> android.content.Context
    inline get() = this::getContext

internal val Activity.contextProvider: () -> Context
    inline get() = { this }

internal val Fragment.contextProvider: () -> Context
    inline get() = this::getContext

internal val Dialog.contextProvider: () -> Context
    inline get() = this::getContext

/**
 * Support
 */
internal val SupportFragment.contextProvider: () -> Context
    inline get() = this::getContext