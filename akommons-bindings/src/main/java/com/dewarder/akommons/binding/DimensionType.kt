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

package com.dewarder.akommons.binding

import android.content.Context

enum class DimensionType {
    PX {
        override fun convert(context: Context, pixels: Float): Float {
            return pixels
        }
    },
    DP {
        override fun convert(context: Context, pixels: Float): Float {
            return pixels / context.resources.displayMetrics.density
        }
    },
    SP {
        override fun convert(context: Context, pixels: Float): Float {
            return pixels / context.resources.displayMetrics.scaledDensity
        }
    };

    abstract fun convert(context: Context, pixels: Float): Float
}